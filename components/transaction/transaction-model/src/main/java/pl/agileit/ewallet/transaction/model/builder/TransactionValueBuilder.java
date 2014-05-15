package pl.agileit.ewallet.transaction.model.builder;

import pl.agileit.ewallet.transaction.model.TransactionValue;

import java.math.BigDecimal;

/**
 * @author lukasz barc
 */
public class TransactionValueBuilder {
    private BigDecimal value;

    private TransactionValueBuilder() {
    }

    public static TransactionValueBuilder aTransactionValue() {
        return new TransactionValueBuilder();
    }

    public TransactionValueBuilder withValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public TransactionValue build() {
        TransactionValue transactionValue = new TransactionValue(value);
        return transactionValue;
    }
}
