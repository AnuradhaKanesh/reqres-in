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

    public Response updateAUser(CreateUserRequest requestBody,int id) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .pathParam("id",id)
                .put("https://reqres.in/api/users/{id}");

    }

    public Response deleteAUser(int id) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("id",id)
                .delete("https://reqres.in/api/users/{id}");

    }


}
