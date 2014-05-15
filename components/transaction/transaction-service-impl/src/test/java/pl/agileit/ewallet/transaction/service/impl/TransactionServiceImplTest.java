package pl.agileit.ewallet.transaction.service.impl;

import org.junit.Before;
import org.junit.Test;
import pl.agileit.ewallet.transaction.dao.ITransactionDao;
import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;
import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.service.TransactionAssembler;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static pl.agileit.ewallet.transaction.model.builder.TransactionBuilder.aTransaction;

/**
 * @author lukasz barc
 */
public class TransactionServiceImplTest {

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
        Transaction transaction = aTransaction()
                .build();

        objectUnderTest.registerTransaction(1L, transaction);

        verify(transactionAssembler, times(1)).toDto(transaction);
        verify(transactionDao, times(1)).save(any(TransactionDto.class));
    }
}
