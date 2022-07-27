package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.ReusableMethods;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static javax.swing.UIManager.getInt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class emailValidations extends ReusableMethods {

    RequestSpecification resp;
    ResponseSpecification respec;
    Response response;

    @Given("^Search for user with username \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void searchForUserWithUsernameWithHttpRequest(String resource, String method) throws IOException {

        respec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        resp = given().spec(requestSpecification());

        //Constructor will be called with value of resource which was passed
        APIResources resourceAPI = APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("GET"))
        response= resp.when().get(resourceAPI.getResource());
    }

    @When("^Search for post written by \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void searchForPostWrittenByWithHttpRequest(String resource, String method) {
        //Constructor will be called with value of resource which was passed
        APIResources resourceAPI = APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("GET"))
        response= resp.when().get(resourceAPI.getResource());
    }

    @Then("^Fetch the comments for each \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void fetchTheCommentsForEachWithHttpRequest(String resource, String method) {
        //Constructor will be called with value of resource which was passed
        APIResources resourceAPI = APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("GET"))
            response= resp.when().get(resourceAPI.getResource());
    }

    @And("^Get all \"([^\"]*)\" for each user post with \"([^\"]*)\" http request$")
    public void getAllForEachUserPostWithHttpRequest(String resource, String method)
    {
        //Constructor will be called with value of resource which was passed
        APIResources resourceAPI = APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("GET"))
            response= resp.when().get(resourceAPI.getResource());
    }

    @When("^Validate if the \"([^\"]*)\" in comment section are in the proper email \"([^\"]*)\"\\.$")
    public void validateIfTheInCommentSectionAreInTheProperEmail(String emailAddress, String regexPattern) {
        int count = getInt("comments.size");
        JsonPath js = new JsonPath(String.valueOf(response)); //parsing Json
        for(int i = 0; i < count; i++){
            emailAddress = js.getString("["+i+"].email");
            regexPattern = "^(.+)@(\\S+)$";
            assertTrue(ReusableMethods.patternMatches(emailAddress, regexPattern));
        }

    }
    @Then("^the API call is success with status code (\\d+)$")
    public void the_api_call_is_success_with_status_code(Integer int1) {

        assertEquals(response.getStatusCode(),200);
    }
}
