package request;

import constant.StatusCode;
import io.restassured.response.Response;
import model.ApiResponse;
import model.order.Order;

import static io.restassured.RestAssured.given;

public class StoreRequest extends BaseRequest {

    static final String ORDER_ENDPOINT = "/store/order";
    static final String ORDER_PARAM_ENDPOINT = "/store/order/{orderId}";

    public Order createOrder(Order order) {
        Response response = given(requestSpec)
                .body(order)
                .post(ORDER_ENDPOINT);
        response.then().statusCode(StatusCode.OK);
        return response.as(Order.class);
    }

    public Response createOrderWithEmptyRequestBody() {
        return given(requestSpec).post(ORDER_ENDPOINT);
    }

    public Order getOrder(int orderId) {
        Response response = given(requestSpec)
                .pathParams("orderId", String.valueOf(orderId))
                .get(ORDER_PARAM_ENDPOINT);
        response.then().statusCode(StatusCode.OK);
        return response.as(Order.class);
    }

    public Response deleteOrder(int orderId) {
        return given(requestSpec)
                .pathParams("orderId", String.valueOf(orderId))
                .delete(ORDER_PARAM_ENDPOINT);


    }


}
