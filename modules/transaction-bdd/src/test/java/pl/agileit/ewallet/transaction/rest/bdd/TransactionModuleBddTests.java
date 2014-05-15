package pl.agileit.ewallet.transaction.rest.bdd;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;
import pl.agileit.ewallet.transaction.rest.dto.builder.TransactionRestDtoBuilder;

import java.math.BigDecimal;

import static com.jayway.restassured.RestAssured.given;

/**
 * @author lukasz barc
 */
public class TransactionModuleBddTests {

    @Test
    public void testRegisterTransaction() {
        given()
                .contentType(ContentType.JSON)
                .log()
                .everything(true)
                .body(TransactionRestDtoBuilder
                        .aTransactionRestDto()
                        .withUserId(100L)
                        .withValue(BigDecimal.valueOf(50L))
                        .build())

                .when()
                .post("/tx/transactions/register")
                .then()
                .log()
                .everything(true)
                .statusCode(204);
    }

    @Test
    public void testGetTransaction() {
        given()
                .contentType(ContentType.JSON)
                .log().everything()
                .with()
                .pathParam("identity", 2L)
                .when()
                .get("/tx/transactions/{identity}")
                .then()
                .log().everything()
                .statusCode(200);
    }

    @Test
    public void testGetTransactions() {
        given()
                .contentType(ContentType.JSON)
                .log().everything()
                .with()
                .pathParam("identity", 100L)
                .when()
                .get("/tx/transactions/{identity}/list")
                .then()
                .log().everything()
                .statusCode(200);
    }
}
