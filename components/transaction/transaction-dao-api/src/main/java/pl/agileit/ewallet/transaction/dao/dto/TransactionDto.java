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

    public TransactionDto(final long id,
                          final long userId,
                          final BigDecimal value) {
        this.id = id;
        this.userId = userId;
        this.value = value;
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

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .add("userId", userId)
                .add("value", value)
                .toString();
    }
}
