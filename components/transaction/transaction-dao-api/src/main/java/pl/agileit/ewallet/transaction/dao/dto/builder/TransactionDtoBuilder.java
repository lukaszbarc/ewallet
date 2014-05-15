package pl.agileit.ewallet.transaction.dao.dto.builder;

import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;

import java.math.BigDecimal;

/**
 * @author lukasz barc
 */
public class TransactionDtoBuilder {
    private long id;
    private long userId;
    private BigDecimal value;

    private TransactionDtoBuilder() {
    }

    public static TransactionDtoBuilder aTransactionDto() {
        return new TransactionDtoBuilder();
    }

    public TransactionDtoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public TransactionDtoBuilder withUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public TransactionDtoBuilder withValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public TransactionDto build() {
        TransactionDto transactionDto = new TransactionDto(id, userId, value);
        return transactionDto;
    }
}
