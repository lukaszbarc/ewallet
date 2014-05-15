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

    public TransactionRestDto() {
    }

    public TransactionRestDto(final long id,
                              final long userId,
                              final BigDecimal value) {
        this.id = id;
        this.userId = userId;
        this.value = value;
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

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .add("userId", userId)
                .add("value", value)
                .toString();
    }
}
