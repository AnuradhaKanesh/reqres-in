import lombok.Builder;

@Builder
public class CreateUserRequest {
    private String name;
    private String job;

}
