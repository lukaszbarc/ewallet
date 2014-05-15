package pl.agileit.ewallet.transaction.service.impl;

import pl.agileit.ewallet.transaction.dao.ITransactionDao;
import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.service.ITransactionService;
import pl.agileit.ewallet.transaction.service.TransactionAssembler;

/**
 * @author lukasz barc
 */
public class TransactionServiceImpl implements ITransactionService {

    private ITransactionDao transactionDao;
    private TransactionAssembler transactionAssembler;

    @Override
    public void registerTransaction(final long userId, final Transaction transaction) {
        transactionDao.save(transactionAssembler.toDto(transaction));
    }

    public void setTransactionDao(final ITransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public void setTransactionAssembler(final TransactionAssembler transactionAssembler) {
        this.transactionAssembler = transactionAssembler;
    }
}
