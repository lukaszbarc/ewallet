package pl.agileit.ewallet.transaction.service.impl;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import pl.agileit.ewallet.transaction.dao.ITransactionDao;
import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;
import pl.agileit.ewallet.transaction.dao.dto.builder.TransactionDtoBuilder;
import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.service.TransactionAssembler;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static pl.agileit.ewallet.transaction.dao.dto.builder.TransactionDtoBuilder.aTransactionDto;
import static pl.agileit.ewallet.transaction.model.builder.TransactionBuilder.aTransaction;

/**
 * @author lukasz barc
 */
public class TransactionServiceImplTest {

    public static final long TX_ID = 1L;
    public static final long TX_OWNER_ID = 100L;
    private TransactionServiceImpl objectUnderTest;
    private ITransactionDao transactionDao = mock(ITransactionDao.class);
    private TransactionAssembler transactionAssembler = mock(TransactionAssembler.class);

    @Before
    public void init() {
        objectUnderTest = new TransactionServiceImpl();
        objectUnderTest.setTransactionDao(transactionDao);
        objectUnderTest.setTransactionAssembler(transactionAssembler);
    }

    @Test
    public void testRegisterTransaction() {
        // given
        Transaction transaction = aTransaction()
                .build();

        // when
        objectUnderTest.registerTransaction(1L, transaction);

        // then
        InOrder inOrder = inOrder(transactionAssembler, transactionDao);
        inOrder.verify(transactionAssembler, times(1)).toDto(transaction);
        inOrder.verify(transactionDao, times(1)).save(any(TransactionDto.class));
    }

    @Test
    public void testGetTransaction() {
        // given
        TransactionDto transactionDto = aTransactionDto()
                .build();
        when(transactionDao.getById(TX_ID)).thenReturn(transactionDto);

        // when
        objectUnderTest.getTransaction(TX_ID);

        // then
        InOrder inOrder = inOrder(transactionAssembler, transactionDao);
        inOrder.verify(transactionDao, times(1)).getById(TX_ID);
        inOrder.verify(transactionAssembler, times(1)).toTransaction(transactionDto);
    }

    @Test
    public void testGetTransactions() {
        // given
        TransactionDtoBuilder builder = aTransactionDto();
        TransactionDto t1 = builder.build();
        TransactionDto t2 = builder.build();
        TransactionDto t3 = builder.build();
        when(transactionDao.getByUser(TX_OWNER_ID)).thenReturn(Lists.newArrayList(t1, t2, t3));

        // when
        for (Transaction transaction : objectUnderTest.getTransactionByUser(TX_OWNER_ID)) {
            // have to iterate to enforce guava execute Function.apply method
        }

        // then
        InOrder inOrder = inOrder(transactionDao, transactionAssembler);
        inOrder.verify(transactionDao, times(1)).getByUser(TX_OWNER_ID);
        inOrder.verify(transactionAssembler, times(1)).toTransaction(t1);
        inOrder.verify(transactionAssembler, times(1)).toTransaction(t2);
        inOrder.verify(transactionAssembler, times(1)).toTransaction(t3);
    }
}
