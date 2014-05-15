package pl.agileit.ewallet.transaction.dao;

import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;

import java.util.List;

/**
 * @author lukasz barc
 */
public interface ITransactionDao {
    void save(TransactionDto transactionDto);

    TransactionDto getById(long txId);

    List<TransactionDto> getByUser(long userId);
}
