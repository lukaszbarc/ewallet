package pl.agileit.ewallet.transaction.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.agileit.ewallet.transaction.dao.ITransactionDao;
import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;
import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.service.ITransactionService;
import pl.agileit.ewallet.transaction.service.TransactionAssembler;

import java.util.List;

import static com.google.common.collect.Lists.transform;

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

    @Override
    public List<Transaction> getTransactionByUser(final long userId) {
        LOGGER.trace(">>getTransactionByUser({})", userId);
        return transform(transactionDao.getByUser(userId), new Function<TransactionDto, Transaction>() {
            @Override
            public Transaction apply(final TransactionDto input) {
                return transactionAssembler.toTransaction(input);
            }
        });
    }

    public void setTransactionDao(final ITransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public void setTransactionAssembler(final TransactionAssembler transactionAssembler) {
        this.transactionAssembler = transactionAssembler;
    }
}
