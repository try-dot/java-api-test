package request;

import constant.StatusCode;
import io.restassured.response.Response;
import model.ApiResponse;
import model.User;
import java.util.List;
import static io.restassured.RestAssured.given;

public class UserRequest extends BaseRequest {

    static final String USERS_LIST_ENDPOINT = "/user/createWithList";
    static final String USER_ENDPOINT = "/user";
    static final String USER_PARAM_ENDPOINT = "/user/{username}";
    static final String LOGIN_ENDPOINT = "/user/login";
    static final String LOGOUT_ENDPOINT = "/user/logout";


    public ApiResponse createUsersWithList(List<User> userList) {
        Response response = given(requestSpec).body(userList).get(USERS_LIST_ENDPOINT);
        response.then().statusCode(StatusCode.OK);
        return response.body().as(ApiResponse.class);
    }


    public ApiResponse createUsersWitEmptyList() {
        Response response = given(requestSpec).get(USERS_LIST_ENDPOINT);
        response.then().statusCode(StatusCode.INTERNAL_SERVER_ERROR);
        return response.body().as(ApiResponse.class);
    }

    public User getUser(String userName) {
        Response response = given(requestSpec)
                .pathParams("username", userName)
                .get(USER_PARAM_ENDPOINT);
        response.then().statusCode(StatusCode.OK);
        return response.body().as(User.class);
    }

    public ApiResponse getNotExistedUser(String userName) {
        Response response = given(requestSpec)
                .pathParams("username", userName)
                .get(USER_PARAM_ENDPOINT);
        response.then().statusCode(StatusCode.NOT_FOUND);
        return response.body().as(ApiResponse.class);
    }


    public ApiResponse updateUser(String userName) {
        User user = User.generateRandomUser();
        user.setUserName(userName);
        Response response = given(requestSpec)
                .pathParams("username", userName)
                .body(user)
                .put(USER_PARAM_ENDPOINT);
        response.then().statusCode(StatusCode.OK);
        return response.body().as(ApiResponse.class);
    }

    public ApiResponse deleteUser(String userName) {
        Response response = given(requestSpec)
                .pathParams("username", userName)
                .put(USER_PARAM_ENDPOINT);
        response.then().statusCode(StatusCode.OK);
        return response.body().as(ApiResponse.class);
    }

    public Response deleteNotExistedUser(String userName) {
        Response response = given(requestSpec)
                .pathParams("username", userName)
                .put(USER_PARAM_ENDPOINT);
        return response;
    }

    public ApiResponse logInUser(String userName, String password) {
        Response response = given(requestSpec)
                .queryParam("username", userName)
                .queryParam("password", password)
                .get(LOGIN_ENDPOINT);
        response.then().statusCode(StatusCode.OK);
        return  response.body().as(ApiResponse.class);

    }

    public Response logOutUser() {
        return given(requestSpec)
                .get(LOGOUT_ENDPOINT);
    }

    public ApiResponse createUser(User user) {
        Response response=  given(requestSpec)
                .body(user)
                .post(USER_ENDPOINT);
        response.then().statusCode(StatusCode.OK);
        return response.body().as(ApiResponse.class);

    }

}
