import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserResponse {

    private String name;
    private String job;
    private int id;
    private String createdAt;

    @Setter
    private int statusCode;
}
