package pl.agileit.ewallet.transaction.model.builder;

import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.model.TransactionOwner;
import pl.agileit.ewallet.transaction.model.TransactionValue;

/**
 * @author lukasz barc
 */
public final class TransactionBuilder {

    private long id;
    private TransactionOwner user;
    private TransactionValue value;

    private TransactionBuilder() {
    }

    public static TransactionBuilder aTransaction() {
        return new TransactionBuilder();
    }

    public TransactionBuilder withId(final long id) {
        this.id = id;
        return this;
    }

    public TransactionBuilder withUser(final TransactionOwner user) {
        this.user = user;
        return this;
    }

    public TransactionBuilder withValue(final TransactionValue value) {
        this.value = value;
        return this;
    }

    public Transaction build() {
        return  new Transaction(id, user, value);
    }
}
