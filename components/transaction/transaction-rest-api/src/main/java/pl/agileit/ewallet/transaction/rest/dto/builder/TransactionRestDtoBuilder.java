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
    private long categoryId;
    private long costCenterId;
    private String description;

    private TransactionRestDtoBuilder() {
    }

    public static TransactionRestDtoBuilder aTransactionRestDto() {
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

    public TransactionRestDtoBuilder withCategoryId(final long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public TransactionRestDtoBuilder withCostCenterId(final long costCenterId) {
        this.costCenterId = costCenterId;
        return this;
    }

    public TransactionRestDtoBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public TransactionRestDto build() {
        TransactionRestDto transactionRestDto = new TransactionRestDto();
        transactionRestDto.setId(id);
        transactionRestDto.setUserId(userId);
        transactionRestDto.setValue(value);
        transactionRestDto.setCategoryId(categoryId);
        transactionRestDto.setCostCenterId(costCenterId);
        transactionRestDto.setDescription(description);
        return transactionRestDto;
    }
}
