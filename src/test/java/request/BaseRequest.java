package request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import util.SystemProperties;

public class BaseRequest {

    public RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(SystemProperties.APPLICATION_URL)
            .setContentType(ContentType.JSON)
            .build();

}
