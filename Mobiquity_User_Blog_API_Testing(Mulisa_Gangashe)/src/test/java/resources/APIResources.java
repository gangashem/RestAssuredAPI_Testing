package resources;
//enum is a special class in java which has collection of constants or methods
public enum APIResources {
    getDelphineAPI("/?username=Delphine"),
    getUsername("/users?username=Delphine"),
    getUserPostsAPI("/posts?userId=9"),
    getCommentsAPI("/comments?postId=81&postId=82&postId=83&postId=84&postId=85&postId=86&postId=87&postId=88&postId=89&postId=90"),
    ;
    private String resource;

    APIResources (String resource) {
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
