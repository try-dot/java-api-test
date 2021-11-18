package request;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import util.SystemProperties;

public abstract class BaseRequest {

    RequestSpecification specification = given()
                .baseUri(SystemProperties.APPLICATION_URL)
                .contentType(ContentType.JSON);

}
