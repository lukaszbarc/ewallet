package pl.agileit.ewallet.transaction.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import pl.agileit.ewallet.transaction.dao.ITransactionDao;
import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;

/**
 * @author lukasz barc
 */
public class TransactionDaoImpl implements ITransactionDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final TransactionDto transactionDto) {
        jdbcTemplate.update("INSERT INTO TX_TRANSACTION (ID, ID_USER, TRANSACTION_VALUE) VALUES (?, ?, ?)",
                transactionDto.getId(), transactionDto.getUserId(), transactionDto.getValue());
    }

    public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
