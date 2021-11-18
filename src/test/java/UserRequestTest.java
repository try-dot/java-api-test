import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import request.UserRequest;

public class UserRequestTest {


    private UserRequest userRequest = new UserRequest();

    @Test
    void getCorrectUser(){
        assertThat(userRequest.getUser("user1").getUserName()).isEqualTo("user1");
        userRequest.getUserResponse("user1").then().statusCode(200);
    }

    @Test
    void logUserTest(){
        assert userRequest.logUser("user123", "abcd") != null;
    }
}
