package pl.agileit.ewallet.transaction.model;

import java.math.BigDecimal;

import static com.google.common.base.Objects.toStringHelper;

/**
 * @author lukasz barc
 */
public final class TransactionValue {

    private final BigDecimal value;

    public TransactionValue(final BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("value", value)
                .toString();
    }
}
