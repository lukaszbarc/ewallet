package pl.agileit.ewallet.transaction.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pl.agileit.ewallet.transaction.dao.ITransactionDao;
import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static pl.agileit.ewallet.transaction.dao.dto.builder.TransactionDtoBuilder.aTransactionDto;

/**
 * @author lukasz barc
 */
public class TransactionDaoImpl implements ITransactionDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionDaoImpl.class);
    private static final TransactionDtoRowMapper TRANSACTION_DTO_ROW_MAPPER = new TransactionDtoRowMapper();
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final TransactionDto transactionDto) {
        LOGGER.trace(">>save({})", transactionDto);
        jdbcTemplate.update("INSERT INTO TX_TRANSACTION (ID_USER, TRANSACTION_VALUE, ID_CATEGORY, ID_COST_CENTER, DESCRIPTION) VALUES (?, ?, ?, ?, ?)",
                transactionDto.getUserId(),
                transactionDto.getValue(),
                transactionDto.getCategoryId(),
                transactionDto.getCostCenterId(),
                transactionDto.getDescription()
        );
    }

    @Override
    public TransactionDto getById(final long txId) {
        LOGGER.trace(">>getById({})", txId);
        return jdbcTemplate.queryForObject("SELECT ID, ID_USER, TRANSACTION_VALUE, ID_COST_CENTER, ID_CATEGORY, DESCRIPTION FROM TX_TRANSACTION WHERE ID = ?",
                new Object[]{txId},
                TRANSACTION_DTO_ROW_MAPPER
        );
    }

    @Override
    public List<TransactionDto> getByUser(final long userId) {
        LOGGER.trace(">>getByUser({})", userId);

        return jdbcTemplate.query("SELECT ID, ID_USER, TRANSACTION_VALUE, ID_COST_CENTER, ID_CATEGORY, DESCRIPTION FROM TX_TRANSACTION WHERE ID_USER = ?",
                new Object[]{userId},
                TRANSACTION_DTO_ROW_MAPPER
        );

    }

    public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
