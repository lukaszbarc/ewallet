package pl.agileit.ewallet.transaction.service;

import org.junit.Before;
import org.junit.Test;
import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;

import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;
import static pl.agileit.ewallet.transaction.model.builder.TransactionBuilder.aTransaction;
import static pl.agileit.ewallet.transaction.model.builder.TransactionOwnerBuilder.aTransactionOwner;
import static pl.agileit.ewallet.transaction.model.builder.TransactionValueBuilder.aTransactionValue;

/**
 * @author lukasz barc
 */
public class TransactionAssemblerTest {

    public static final long TX_ID = 1L;
    public static final long TX_OWNER_ID = 100L;
    public static final long TX_VALUE = 50L;
    private TransactionAssembler objectUnderTest;

    @Before
    public void init() {
        objectUnderTest = new TransactionAssembler();
    }

    @Test
    public void testToDto() {
        TransactionDto transactionDto = objectUnderTest.toDto(aTransaction()
                .withId(TX_ID)
                .withUser(aTransactionOwner()
                        .withId(TX_OWNER_ID)
                        .build())
                .withValue(aTransactionValue()
                        .withValue(BigDecimal.valueOf(TX_VALUE))
                        .build())
                .build());

        assertThat(transactionDto.getId()).isEqualTo(TX_ID);
        assertThat(transactionDto.getUserId()).isEqualTo(TX_OWNER_ID);
        assertThat(transactionDto.getValue()).isEqualTo(BigDecimal.valueOf(TX_VALUE));

    }


}
