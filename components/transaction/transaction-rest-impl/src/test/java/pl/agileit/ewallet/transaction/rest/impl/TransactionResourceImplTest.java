package pl.agileit.ewallet.transaction.rest.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.model.builder.TransactionBuilder;
import pl.agileit.ewallet.transaction.model.builder.TransactionOwnerBuilder;
import pl.agileit.ewallet.transaction.model.builder.TransactionValueBuilder;
import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;
import pl.agileit.ewallet.transaction.service.ITransactionService;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static pl.agileit.ewallet.transaction.rest.dto.builder.TransactionRestDtoBuilder.aTransactionRestDto;

/**
 * @author lukasz barc
 */
public class TransactionResourceImplTest {

    public static final long TX_ID = 1L;
    public static final long TX_OWNER_ID = 100L;
    public static final BigDecimal TX_VALUE = BigDecimal.valueOf(50L);
    private TransactionResourceImpl objectUnderTest;
    private ITransactionService transactionService;
    private TransactionRestAssembler transactionRestAssembler;

    @Before
    public void init() {
        objectUnderTest = new TransactionResourceImpl();
        transactionService = mock(ITransactionService.class);
        transactionRestAssembler = mock(TransactionRestAssembler.class);

        objectUnderTest.setTransactionRestAssembler(transactionRestAssembler);
        objectUnderTest.setTransactionService(transactionService);
    }

    @Test
    public void testRegisterTransaction() {
        // given
        TransactionRestDto transactionDto = aTransactionRestDto()
                .withId(TX_ID)
                .withUserId(TX_OWNER_ID)
                .withValue(TX_VALUE).build();
        Transaction transaction = TransactionBuilder.aTransaction()
                .withUser(TransactionOwnerBuilder.aTransactionOwner().withId(TX_OWNER_ID).build())
                .build();
        when(transactionRestAssembler.toTransaction(transactionDto)).thenReturn(transaction);

        // when
        objectUnderTest.registerTransaction(transactionDto);

        // then
        InOrder inOrder = inOrder(transactionRestAssembler, transactionService);
        inOrder.verify(transactionRestAssembler, times(1)).toTransaction(transactionDto);
        inOrder.verify(transactionService, times(1)).registerTransaction(TX_OWNER_ID, transaction);
    }

    @Test
    public void testGetTransactionWithParticularId() {
        // given
        Transaction answer = TransactionBuilder.aTransaction()
                .withId(TX_ID)
                .withUser(TransactionOwnerBuilder.aTransactionOwner().withId(TX_OWNER_ID).build())
                .withValue(TransactionValueBuilder.aTransactionValue().withValue(TX_VALUE).build())
                .build();
        when(transactionService.getTransaction(TX_ID)).thenReturn(answer);

        // when
        objectUnderTest.getTransaction(TX_ID);

        // then
        InOrder inOrder = inOrder(transactionRestAssembler, transactionService);
        inOrder.verify(transactionService, times(1)).getTransaction(TX_ID);
        inOrder.verify(transactionRestAssembler, times(1)).toTransactionRestDto(answer);
    }
}
