package pl.agileit.ewallet.transaction.service;

import org.junit.Before;
import org.junit.Test;
import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;
import pl.agileit.ewallet.transaction.model.Transaction;

import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;
import static pl.agileit.ewallet.transaction.dao.dto.builder.TransactionDtoBuilder.aTransactionDto;
import static pl.agileit.ewallet.transaction.model.builder.TransactionBuilder.aTransaction;
import static pl.agileit.ewallet.transaction.model.builder.TransactionOwnerBuilder.aTransactionOwner;
import static pl.agileit.ewallet.transaction.model.builder.TransactionValueBuilder.aTransactionValue;

/**
 * @author lukasz barc
 */
public class TransactionAssemblerTest {

    public static final long TX_ID = 1L;
    public static final long TX_OWNER_ID = 100L;
    public static final BigDecimal TX_VALUE = BigDecimal.valueOf(50L);
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
                        .withValue(TX_VALUE)
                        .build())
                .build());

        assertThat(transactionDto.getId()).isEqualTo(TX_ID);
        assertThat(transactionDto.getUserId()).isEqualTo(TX_OWNER_ID);
        assertThat(transactionDto.getValue()).isEqualTo(TX_VALUE);
    }

    @Test
    public void testToTransaction() {
        Transaction transaction = objectUnderTest.toTransaction(aTransactionDto()
                .withId(TX_ID)
                .withUserId(TX_OWNER_ID)
                .withValue(TX_VALUE)
                .build());

        assertThat(transaction.getId()).isEqualTo(TX_ID);
        assertThat(transaction.getUser().getId()).isEqualTo(TX_OWNER_ID);
        assertThat(transaction.getValue().getValue()).isEqualTo(TX_VALUE);
    }


}
