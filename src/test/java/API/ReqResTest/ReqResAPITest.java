package API.ReqResTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

public class ReqResAPITest {

    @Test
    public void testAPICall()
    {

        given().
                header("x-api-key", "reqres-free-v1")

            .when()
                .get("https://reqres.in/api/users/2")
            .then()
                .assertThat()
                    .statusCode(200)
                    .body("data.first_name", equalTo("Janet"));

    }


    // another format for the previous test using Response class
    @Test
    public void testAPICallWithResponse()
    {
        Response response =
            given().
                header("x-api-key", "reqres-free-v1")
            .when()
                .get("https://reqres.in/api/users/2");


        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body().asString());
        response.
                then().
                assertThat().
                statusCode(200).
                body("data.first_name", equalTo("Janet"));

    }

}
