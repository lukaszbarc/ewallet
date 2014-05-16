package pl.agileit.ewallet.transaction.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;

import java.sql.ResultSet;
import java.sql.SQLException;

import static pl.agileit.ewallet.transaction.dao.dto.builder.TransactionDtoBuilder.aTransactionDto;

/**
 * @author lukasz barc
 */
public class TransactionDtoRowMapper implements RowMapper<TransactionDto> {

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TRANSACTION_VALUE = "TRANSACTION_VALUE";
    public static final String COLUMN_ID_USER = "ID_USER";
    public static final String COLUMN_ID_CATEGORY = "ID_CATEGORY";
    public static final String COLUMN_ID_COST_CENTER = "ID_COST_CENTER";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";

    @Override
    public TransactionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return aTransactionDto()
                .withId(rs.getLong(COLUMN_ID))
                .withValue(rs.getBigDecimal(COLUMN_TRANSACTION_VALUE))
                .withUserId(rs.getLong(COLUMN_ID_USER))
                .withCostCenterId(rs.getLong(COLUMN_ID_COST_CENTER))
                .withCategoryId(rs.getLong(COLUMN_ID_CATEGORY))
                .withDescription(rs.getString(COLUMN_DESCRIPTION))
                .build();
    }
}
