import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReqResTests {

    UserService userService;

    @BeforeMethod
    public void initiateUserService() {
        userService = new UserService();
    }

    @Test
    public void shouldGetAllUsers() {
        User user = userService.getUsers(2);
        Assert.assertEquals(user.getStatusCode(), 200);
    }

    @Test
    public void shouldCreateAUser() {
        CreateUserRequest createUserRequest = CreateUserRequest.builder().name("morph").job("team member").build();

        CreateUserResponse response = userService.createUser(createUserRequest);

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.getName(), createUserRequest.getName());
        Assert.assertEquals(response.getJob(), createUserRequest.getJob());

    }

    @Test
    public void shouldUpdateAUser() {

    }

    @Test
    public void shouldDeleteAUser() {

    }
}
