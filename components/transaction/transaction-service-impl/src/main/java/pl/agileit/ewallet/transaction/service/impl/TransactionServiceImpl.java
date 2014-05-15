package pl.agileit.ewallet.transaction.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.agileit.ewallet.transaction.dao.ITransactionDao;
import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.service.ITransactionService;
import pl.agileit.ewallet.transaction.service.TransactionAssembler;

/**
 * @author lukasz barc
 */
public class TransactionServiceImpl implements ITransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private ITransactionDao transactionDao;
    private TransactionAssembler transactionAssembler;

    @Override
    public void registerTransaction(final long userId, final Transaction transaction) {
        LOGGER.trace(">>registerTransaction({}, {})", userId, transaction);
        transactionDao.save(transactionAssembler.toDto(transaction));
    }

    @Override
    public Transaction getTransaction(final long txId) {
        LOGGER.trace(">>getTransaction({})", txId);
        return transactionAssembler.toTransaction(transactionDao.getById(txId));
    }

    public void setTransactionDao(final ITransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public void setTransactionAssembler(final TransactionAssembler transactionAssembler) {
        this.transactionAssembler = transactionAssembler;
    }
}
