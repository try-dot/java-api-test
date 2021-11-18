package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.ApiResponse;
import model.User;
import java.util.List;

public class UserRequest extends BaseRequest {

    private static final String USERS_LIST_ENDPOINT = "/user/createWithList";
    private static final String USER_ENDPOINT = "/user";
    private static final String LOGIN_ENDPOINT = "/user/login";
    private static final String LOGOUT_ENDPOINT = "/user/logout";

    public Response createUsersWithList(List<User> userList) {
        return RestAssured.given(specification).body(userList).get(USERS_LIST_ENDPOINT);
    }

    public Response getUserResponse(String userName) {
        return RestAssured.given(specification)
                .pathParams("username", userName)
                .get(USER_ENDPOINT +"/" + "{username}");
    }

    public User getUser(String userName) {
        return getUserResponse(userName).getBody().as(User.class);
    }

    public Response updateUser(String userName) {
        return RestAssured.given(specification)
                .pathParams("username", userName)
                .put(USER_ENDPOINT +"/" + "{username}");
    }

    public ApiResponse logUser(String userName, String password) {
        return RestAssured.given(specification)
                .queryParam("username", userName)
                .queryParam("password", password)
                .get(LOGIN_ENDPOINT)
                .as(ApiResponse.class);

    }

    public Response logOutUser() {
        return RestAssured.given(specification)
                .get(LOGOUT_ENDPOINT);
    }
}
