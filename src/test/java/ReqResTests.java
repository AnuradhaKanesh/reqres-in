import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReqResTests {

    UserService userService;
    int id = 0;

    @BeforeMethod
    public void initiateUserService() {
        userService = new UserService();
    }

    @Test
    public void TC001_ShouldGetAllUsers() {
        User user = userService.getUsers(2);
        Assert.assertEquals(user.getStatusCode(), 200);
    }

    @Test
    public void TC002_ShouldCreateAUser() {
        CreateUserRequest createUserRequest = CreateUserRequest.builder().name("morph").job("member").build();

        CreateUserResponse response = userService.createUser(createUserRequest);
        id = response.getId();
        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.getName(), createUserRequest.getName());
        Assert.assertEquals(response.getJob(), createUserRequest.getJob());

    }

    @Test
    public void TC003_ShouldUpdateAUser() {

        CreateUserRequest createUserRequest = CreateUserRequest.builder().name("morph").job("zion resident").build();

        Response response = userService.updateUser(createUserRequest, id);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().jsonPath().get("job").toString(), createUserRequest.getJob());
    }

    @Test
    public void TC004_ShouldDeleteAUser() {
        Response response = userService.deleteUser(id);
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
