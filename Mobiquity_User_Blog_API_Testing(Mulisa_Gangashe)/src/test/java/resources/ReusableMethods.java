package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.regex.Pattern;

public class ReusableMethods {
    public static RequestSpecification req;
    public static Response response;
    public static RequestSpecification resp;

    public RequestSpecification requestSpecification() throws IOException
    {
        PrintStream log;
        if(req==null) {
            log = new PrintStream(new FileOutputStream("logging.json"));
            log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("BaseURI")) //Call the global URL property
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static String apiMethods(String resource, String method){
        //Constructor will be called with value of resource which was passed
        APIResources resourceAPI = APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("GET"))
            response = resp.when().get(resourceAPI.getResource());
        return resource;
    }

}
