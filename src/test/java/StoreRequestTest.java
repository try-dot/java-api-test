import constant.StatusCode;
import io.restassured.response.Response;
import model.order.Order;
import model.order.Status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import request.StoreRequest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StoreRequestTest {

    StoreRequest storeRequest = new StoreRequest();

    // failed test - server return 500 code
    @ParameterizedTest
    @EnumSource(Status.class)
    void shouldCreateOrderWitTheSameFields(Status status) {
        Order requestOrder = Order.generateRandomOrder(status);
        Order responseOrder = storeRequest.createOrder(requestOrder);
        assertThat(requestOrder.getId()).isEqualTo(responseOrder.getId());
        assertThat(requestOrder.getQuantity()).isEqualTo(responseOrder.getQuantity());
        assertThat(requestOrder.getStatus()).isEqualTo(responseOrder.getStatus());

    }

    @Test
    void shouldReturnBadRequestWhenCreatingOrderWithEmptyRequestBody() {
        Response response = storeRequest.createOrderWithEmptyRequestBody();
        assert response.statusCode() == StatusCode.BAD_REQUEST;
    }

    @Test
    void shouldReturnOrderWithTheSameId() {
        int validPetId = 1;
        Order order = storeRequest.getOrder(validPetId);
        assert validPetId == order.getPetId();
    }

    @Test
    void shouldDeleteExistedOrder() {
        Order requestOrder = Order.generateRandomOrder(Status.PLACED);
        Order responseOrder = storeRequest.createOrder(requestOrder);
        Response successfulResponse = storeRequest.deleteOrder(responseOrder.getId());
        Response failedResponse = storeRequest.deleteOrder(responseOrder.getId());
        assert successfulResponse.statusCode() == StatusCode.OK;
        assert failedResponse.statusCode() == StatusCode.NOT_FOUND;
    }
}
