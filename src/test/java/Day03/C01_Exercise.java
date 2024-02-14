package Day03;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_Exercise {

        // PATCH  https://restful-booker.herokuapp.com/booking/:id

    @Test
    public void exercise(){

        // baseURI         +
        // header - contentType accept     +
        // body    +
        // auth - Cookie header         +
        // path param     +

        String bodyString = "{\"firstname\" : \"abc\",\"lastname\" : \"xyz\"}";

        Response response = given().
                baseUri("https://restful-booker.herokuapp.com").
                header("Cookie", "token=d92aadb018edd24").
                contentType("application/json").
                accept("application/json").
                body(bodyString).
                pathParam("bookingId", 50).log().all().
                when().
                patch("/booking/{bookingId}");

        response.then().log().all();
        response.then().statusCode(200);

    }
}