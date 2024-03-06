import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class POST{
    @Test(priority = 1)
    public int createUserTest(String name , String email , String gender , String status) {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";


        String requestBody = "{\"name\":\""+name+"\", \"gender\":\""+gender+"\", " + "\"email\":\""+email+"\", \"status\":\"active\"}";

        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 91b3e2b169578cfdf231ba8926d23da5e10f9aeb2e44e4450021ae703b390580")
                .body(requestBody)
                .post("/users");

        // Print the response body
        System.out.println("Status:"+response.getStatusCode());
        //for (String S1:)
        System.out.println("Body:"+response.getBody().asString());
        //response.prettyPrint();

        String userId = response.jsonPath().getString("id");
        System.out.println(userId);
        return response.statusCode();  // Assuming 200 is the expected status code
    }

        static int InvalidRequest(String name, String email, String gender, String status) {
            RestAssured.baseURI = "https://gorest.co.in/public/v2";

            Map<String, Object> requestBodyMap = new HashMap<>();
            requestBodyMap.put("name", name);
            requestBodyMap.put("email", email);
            requestBodyMap.put("gender", gender);
            requestBodyMap.put("status", status);

            StringBuilder requestBodyBuilder = new StringBuilder("{");
            for (Map.Entry<String, Object> entry : requestBodyMap.entrySet()) {
                requestBodyBuilder.append("\"").append(entry.getKey()).append("\":\"");
                if (entry.getValue() != null) {
                    requestBodyBuilder.append(entry.getValue());
                }
                requestBodyBuilder.append("\",");
            }
            requestBodyBuilder.deleteCharAt(requestBodyBuilder.length() - 1);
            requestBodyBuilder.append("}");

            String requestBody = requestBodyBuilder.toString();

            Response response = RestAssured.given()
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer 91b3e2b169578cfdf231ba8926d23da5e10f9aeb2e44e4450021ae703b390580")
                    .body(requestBody)
                    .post("/users");

            // Print the response body
            System.out.println("Status:" + response.getStatusCode());
            System.out.println("Body:" + response.getBody().asString());

            // Get and print the user ID from the response
            String userId = response.jsonPath().getString("id");
            System.out.println(userId);

            return response.getStatusCode();
        }


}
