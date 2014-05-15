package pl.agileit.ewallet.transaction.service;

import pl.agileit.ewallet.transaction.model.Transaction;

import java.util.List;

/**
 * @author lukasz barc
 */
public interface ITransactionService {

    void registerTransaction(long userId, Transaction transaction);

    Transaction getTransaction(long txId);

    List<Transaction> getTransactionByUser(long userId);
}
