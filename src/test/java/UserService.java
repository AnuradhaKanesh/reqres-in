import io.restassured.response.Response;

public class UserService {

    UserClient userClient;
    User users;

    public UserService() {
        userClient = new UserClient();
    }

    public User getUsers(int pageNo) {
        Response response = userClient.getALlUser(pageNo);
        users = response.as(User.class);
        users.setStatusCode(response.getStatusCode());
        response.then().log().body();
        return users;
    }

    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        Response response = userClient.createAUser(userRequest);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.getStatusCode());
        response.then().log().body();
        return createUserResponse;
    }

    public Response updateUser(CreateUserRequest createUserRequest,int id) {
        Response response = userClient.updateAUser(createUserRequest,id);
        response.then().log().body();
        return response;

    }
    public Response deleteUser(int id) {
        Response response = userClient.deleteAUser(id);
        response.then().log().body();
        return response;
    }


}
