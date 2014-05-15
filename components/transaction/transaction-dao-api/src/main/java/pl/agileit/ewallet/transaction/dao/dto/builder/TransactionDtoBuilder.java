package pl.agileit.ewallet.transaction.dao.dto.builder;

import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;

import java.math.BigDecimal;

/**
 * @author lukasz barc
 */
public final class TransactionDtoBuilder {
    private long id;
    private long userId;
    private BigDecimal value;

    private TransactionDtoBuilder() {
    }

    public static TransactionDtoBuilder aTransactionDto() {
        return new TransactionDtoBuilder();
    }

    public TransactionDtoBuilder withId(final long id) {
        this.id = id;
        return this;
    }

    public TransactionDtoBuilder withUserId(final long userId) {
        this.userId = userId;
        return this;
    }

    public TransactionDtoBuilder withValue(final BigDecimal value) {
        this.value = value;
        return this;
    }

    public TransactionDto build() {
        return new TransactionDto(id, userId, value);
    }
}
