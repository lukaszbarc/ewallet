package pl.agileit.ewallet.transaction.model.builder;

import pl.agileit.ewallet.transaction.model.TransactionOwner;

/**
 * @author lukasz barc
 */
public class TransactionOwnerBuilder {
    private long id;

    private TransactionOwnerBuilder() {
    }

    public static TransactionOwnerBuilder aTransactionOwner() {
        return new TransactionOwnerBuilder();
    }

    public TransactionOwnerBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public TransactionOwner build() {
        TransactionOwner transactionOwner = new TransactionOwner(id);
        return transactionOwner;
    }
}
