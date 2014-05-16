package pl.agileit.ewallet.transaction.dao.dto;

import java.math.BigDecimal;

import static com.google.common.base.Objects.toStringHelper;

/**
 * @author lukasz barc
 */
public final class TransactionDto {

    private final long id;
    private final long userId;
    private final BigDecimal value;
    private final long costCenterId;
    private final long categoryId;
    private final String description;

    public TransactionDto(final long id,
                          final long userId,
                          final BigDecimal value,
                          final long costCenterId,
                          final long categoryId,
                          final String description) {
        this.id = id;
        this.userId = userId;
        this.value = value;
        this.costCenterId = costCenterId;
        this.categoryId = categoryId;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public long getCostCenterId() {
        return costCenterId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .add("userId", userId)
                .add("value", value)
                .add("costCenterId", costCenterId)
                .add("categoryId", categoryId)
                .add("description", description)
                .toString();
    }
}
