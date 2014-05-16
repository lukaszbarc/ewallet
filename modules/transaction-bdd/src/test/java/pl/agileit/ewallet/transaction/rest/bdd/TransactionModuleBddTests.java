package pl.agileit.ewallet.transaction.rest.bdd;

import com.jayway.restassured.http.ContentType;
import org.junit.Test;

import java.math.BigDecimal;

import static com.jayway.restassured.RestAssured.given;
import static pl.agileit.ewallet.transaction.rest.dto.builder.TransactionRestDtoBuilder.aTransactionRestDto;

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
                .body(
                        aTransactionRestDto()
                                .withUserId(100L)
                                .withValue(BigDecimal.valueOf(50L))
                                .withCostCenterId(200L)
                                .withCategoryId(300L)
                                .withDescription("description of transaction")
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
                .pathParam("identity", 3L)
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
