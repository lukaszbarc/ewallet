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
    private long costCenterId;
    private long categoryId;
    private String description;

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

    public TransactionDtoBuilder withCostCenterId(final long costCenterId) {
        this.costCenterId = costCenterId;
        return this;
    }

    public TransactionDtoBuilder withCategoryId(final long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public TransactionDtoBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public TransactionDto build() {
        return new TransactionDto(id, userId, value, costCenterId, categoryId, description);
    }
}
