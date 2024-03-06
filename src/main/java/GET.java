import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GET {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
    }

    @Test(priority = 1)
    public void getUserTest(String name , String email , String gender , String status) {
        String userId = "6763252"; // UserId created in POST request

        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 91b3e2b169578cfdf231ba8926d23da5e10f9aeb2e44e4450021ae703b390580")
                .when()
                .get("/users/" + userId);

        // Print the response body
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());

        response.then().statusCode(200);
    }
}
