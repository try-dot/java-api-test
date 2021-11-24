import constant.StatusCode;
import io.restassured.response.Response;
import model.ApiResponse;
import model.User;
import org.junit.jupiter.api.Test;
import request.UserRequest;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserRequestTest {

    private UserRequest userRequest = new UserRequest();
    private String successfulResponseMessage = "ok";
    private String notExistedUserName = "user12345bnmfjiddd";
    private String existedUserName = "user1";
    private String errorMessage = "error";
    private String notFoundMessage = "User not found";
    private String password = "123";
    private String successfulLogInMassage = "logged in user session";


    //failed test - server always return 405 code
    @Test
    void shouldCreateListOfUsers() {
        User firstUser = User.generateRandomUser();
        User secondUser = User.generateRandomUser();
        List<User> list = new ArrayList<>();
        list.add(firstUser);
        list.add(secondUser);
        ApiResponse response = userRequest.createUsersWithList(list);
        assert response.getCode() == StatusCode.OK;
        assert response.getMessage().equals(successfulResponseMessage);

    }

    @Test
    void shouldReturnUserWithTheSameUserName() {
        User user = userRequest.getUser(existedUserName);
        assertThat(user.getUserName()).isEqualTo(existedUserName);
    }

    @Test
    void shouldReturnNotFoundMessageWhenGetNotExistedUser() {
        ApiResponse response = userRequest.getNotExistedUser(notExistedUserName);
        assertThat(response.getType()).isEqualTo(errorMessage);
        assertThat(response.getMessage()).isEqualTo(notFoundMessage);
    }

    @Test
    void shouldUpdateExistedUser() {
        ApiResponse response = userRequest.updateUser(existedUserName);
        assertThat(response.getCode()).isEqualTo(StatusCode.OK);
    }

    //failed test - server always return 405 code
    @Test
    void shouldReturnOkCodeAfterDeletingExistedUser() {
        ApiResponse response = userRequest.deleteUser(existedUserName);
        assertThat(response.getCode()).isEqualTo(StatusCode.OK);
    }

    //failed test - server always return 405 code
    @Test
    void shouldReturnNotFoundCodeWhenTryToDeleteNotExistedUser() {
        Response response = userRequest.deleteNotExistedUser(notExistedUserName);
        response.then().statusCode(StatusCode.NOT_FOUND);
    }

    @Test
    void shouldShowSuccessfulMessageInResponseAfterLogIn() {
        ApiResponse response = userRequest.logInUser(existedUserName, password);
        assertThat(response.getCode()).isEqualTo(StatusCode.OK);
        assertThat(response.getMessage()).contains(successfulLogInMassage);
    }

    @Test
    void shouldShowOkCodeAfterLogOut() {
        Response response = userRequest.logOutUser();
        response.then().statusCode(StatusCode.OK);
    }

    @Test
    void shouldContainOkCodeInResponseAfterAddingNewUser() {
        User user = User.generateRandomUser();
        ApiResponse response = userRequest.createUser(user);
        assertThat(response.getCode()).isEqualTo(StatusCode.OK);
    }

}
