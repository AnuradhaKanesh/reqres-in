import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public Response getALlUser(int pageNo) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("page", pageNo)
                .get("https://reqres.in/api/users?page={page}");
    }

    public Response createAUser(CreateUserRequest requestBody) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .post("https://reqres.in/api/users");
    }

}
