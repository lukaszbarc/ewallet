package pl.agileit.ewallet.transaction.rest.dto.builder;


import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;

import java.math.BigDecimal;

/**
 * @author lukasz barc
 */
public final class TransactionRestDtoBuilder {
    private long id;
    private long userId;
    private BigDecimal value;

    private TransactionRestDtoBuilder() {
    }

    public static TransactionRestDtoBuilder aTransactionDto() {
        return new TransactionRestDtoBuilder();
    }

    public TransactionRestDtoBuilder withId(final long id) {
        this.id = id;
        return this;
    }

    public TransactionRestDtoBuilder withUserId(final long userId) {
        this.userId = userId;
        return this;
    }

    public TransactionRestDtoBuilder withValue(final BigDecimal value) {
        this.value = value;
        return this;
    }

    public TransactionRestDto build() {
        return new TransactionRestDto(id, userId, value);
    }
}
