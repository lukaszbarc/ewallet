package pl.agileit.ewallet.transaction.rest.dto;

import java.math.BigDecimal;

import static com.google.common.base.Objects.toStringHelper;

/**
 * @author lukasz barc
 */
public final class TransactionRestDto {

    private long id;
    private long userId;
    private BigDecimal value;
    private long categoryId;
    private long costCenterId;
    private String description;

    public TransactionRestDto() {
    }

    public TransactionRestDto(final long id,
                              final long userId,
                              final BigDecimal value,
                              final long categoryId,
                              final long costCenterId,
                              final String description) {
        this.id = id;
        this.userId = userId;
        this.value = value;
        this.categoryId = categoryId;
        this.costCenterId = costCenterId;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(final BigDecimal value) {
        this.value = value;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final long categoryId) {
        this.categoryId = categoryId;
    }

    public long getCostCenterId() {
        return costCenterId;
    }

    public void setCostCenterId(final long costCenterId) {
        this.costCenterId = costCenterId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .add("userId", userId)
                .add("value", value)
                .add("categoryId", categoryId)
                .add("costCenterId", costCenterId)
                .add("description", description)
                .toString();
    }
}
