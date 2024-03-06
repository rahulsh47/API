import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UPDATE {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
    }

    @Test(priority = 3)
    public void updateUserTest() {
        // Assuming userId is obtained from the response of the POST request or set it to a known value
        String userId = "6763083"; // Replace this with the actual userId you want to update

        String updatedName = "Rahul1424";
        String updatedEmail = "rahul1424@example.com";

        String requestBody = "{\"name\":\"" + updatedName + "\",\"email\":\"" + updatedEmail + "\",\"gender\":\"male\",\"status\":\"active\"}";

        Response response = given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 91b3e2b169578cfdf231ba8926d23da5e10f9aeb2e44e4450021ae703b390580")
                .body(requestBody)
                .when()
                .patch("/users/" + userId);

        // Print the response body
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());

        response.then().statusCode(200); // Assuming 200 is the expected status code
    }
}
