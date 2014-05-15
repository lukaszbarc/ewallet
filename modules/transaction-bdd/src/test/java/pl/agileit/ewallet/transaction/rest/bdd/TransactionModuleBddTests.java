package pl.agileit.ewallet.transaction.rest.bdd;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.Test;
import pl.agileit.ewallet.transaction.rest.dto.builder.TransactionRestDtoBuilder;

import java.math.BigDecimal;

import static com.jayway.restassured.RestAssured.given;

/**
 * @author lukasz barc
 */
public class TransactionModuleBddTests {

    @Test
    public void test() {
        ValidatableResponse validatableResponse = given()

                .contentType(ContentType.JSON)
                .log()
                .everything(true)
                .body(TransactionRestDtoBuilder
                        .aTransactionDto()
                        .withUserId(100L)
                        .withValue(BigDecimal.valueOf(50L))
                        .build())

                .when()
                .post("http://localhost:8080/tx/transactions/register")
                .then()
                .log()
                .everything(true)
                .statusCode(204);



    }
}
