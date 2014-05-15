package pl.agileit.ewallet.transaction.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pl.agileit.ewallet.transaction.dao.ITransactionDao;
import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;

import java.sql.ResultSet;
import java.sql.SQLException;

import static pl.agileit.ewallet.transaction.dao.dto.builder.TransactionDtoBuilder.aTransactionDto;

/**
 * @author lukasz barc
 */
public class TransactionDaoImpl implements ITransactionDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionDaoImpl.class);
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TRANSACTION_VALUE = "TRANSACTION_VALUE";
    public static final String COLUMN_ID_USER = "ID_USER";
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final TransactionDto transactionDto) {
        LOGGER.trace(">>save({})", transactionDto);
        jdbcTemplate.update("INSERT INTO TX_TRANSACTION (ID_USER, TRANSACTION_VALUE) VALUES (?, ?)",
                transactionDto.getUserId(), transactionDto.getValue());
    }

    @Override
    public TransactionDto getById(final long txId) {
        LOGGER.trace(">>getById({})", txId);
        return jdbcTemplate.queryForObject("SELECT ID, ID_USER, TRANSACTION_VALUE FROM TX_TRANSACTION WHERE ID = ?",
                new Object[]{txId}, new RowMapper<TransactionDto>() {
            @Override
            public TransactionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                return aTransactionDto()
                        .withId(rs.getLong(COLUMN_ID))
                        .withValue(rs.getBigDecimal(COLUMN_TRANSACTION_VALUE))
                        .withUserId(rs.getLong(COLUMN_ID_USER))
                        .build();
            }
        });
    }

    public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
