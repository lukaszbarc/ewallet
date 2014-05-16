package pl.agileit.ewallet.transaction.rest.impl;

import org.junit.Before;
import org.junit.Test;
import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.model.builder.TransactionBuilder;
import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;
import pl.agileit.ewallet.transaction.rest.dto.builder.TransactionRestDtoBuilder;

import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;
import static pl.agileit.ewallet.transaction.model.builder.TransactionCategoryBuilder.aTransactionCategory;
import static pl.agileit.ewallet.transaction.model.builder.TransactionCostCenterBuilder.aTransactionCostCenter;
import static pl.agileit.ewallet.transaction.model.builder.TransactionOwnerBuilder.aTransactionOwner;
import static pl.agileit.ewallet.transaction.model.builder.TransactionValueBuilder.aTransactionValue;

/**
 * @author lukasz barc
 */
public class TransactionRestAssemblerTest {

    private static final long TX_ID = 1L;
    private static final BigDecimal TX_VALUE = BigDecimal.valueOf(100L);
    private static final long TX_OWNER_ID = 50L;
    private static final long TX_CATEGORY_ID = 200L;
    private static final long TX_COST_CENTER_ID = 300L;
    private static final String TX_DESCRIPTION = "description";
    private TransactionRestAssembler objectUnderTest;

    @Before
    public void init() {
        objectUnderTest = new TransactionRestAssembler();
    }

    @Test
    public void testToDto() {
        TransactionRestDto transactionRestDto = objectUnderTest.toTransactionRestDto(TransactionBuilder.aTransaction()
                .withId(TX_ID)
                .withValue(aTransactionValue()
                        .withValue(TX_VALUE)
                        .build())
                .withUser(aTransactionOwner()
                        .withId(TX_OWNER_ID)
                        .build())
                .withCategory(aTransactionCategory()
                        .withId(TX_CATEGORY_ID)
                        .build())
                .withCostCenter(aTransactionCostCenter()
                        .withId(TX_COST_CENTER_ID)
                        .build())
                .withDescription(TX_DESCRIPTION)
                .build());

        assertThat(transactionRestDto.getId()).isEqualTo(TX_ID);
        assertThat(transactionRestDto.getValue()).isEqualTo(TX_VALUE);
        assertThat(transactionRestDto.getUserId()).isEqualTo(TX_OWNER_ID);
        assertThat(transactionRestDto.getCategoryId()).isEqualTo(TX_CATEGORY_ID);
        assertThat(transactionRestDto.getCostCenterId()).isEqualTo(TX_COST_CENTER_ID);
        assertThat(transactionRestDto.getDescription()).isEqualTo(TX_DESCRIPTION);
    }

    @Test
    public void testToTransaction() {
        Transaction transaction = objectUnderTest.toTransaction(TransactionRestDtoBuilder.aTransactionRestDto()
                .withId(TX_ID)
                .withValue(TX_VALUE)
                .withUserId(TX_OWNER_ID)
                .withCategoryId(TX_CATEGORY_ID)
                .withCostCenterId(TX_COST_CENTER_ID)
                .withDescription(TX_DESCRIPTION)
                .build());

        assertThat(transaction.getId()).isEqualTo(TX_ID);
        assertThat(transaction.getValue().getValue()).isEqualTo(TX_VALUE);
        assertThat(transaction.getUser().getId()).isEqualTo(TX_OWNER_ID);
        assertThat(transaction.getCategory().getId()).isEqualTo(TX_CATEGORY_ID);
        assertThat(transaction.getCostCenter().getId()).isEqualTo(TX_COST_CENTER_ID);
        assertThat(transaction.getDescription()).isEqualTo(TX_DESCRIPTION);



    }
}
