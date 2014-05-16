package pl.agileit.ewallet.transaction.model.builder;

import pl.agileit.ewallet.transaction.model.TransactionCostCenter;

/**
 * @author lukasz barc
 */
public final class TransactionCostCenterBuilder {
    private long id;

    private TransactionCostCenterBuilder() {
    }

    public static TransactionCostCenterBuilder aTransactionCostCenter() {
        return new TransactionCostCenterBuilder();
    }

    public TransactionCostCenterBuilder withId(final long id) {
        this.id = id;
        return this;
    }

    public TransactionCostCenter build() {
        return new TransactionCostCenter(id);
    }
}
