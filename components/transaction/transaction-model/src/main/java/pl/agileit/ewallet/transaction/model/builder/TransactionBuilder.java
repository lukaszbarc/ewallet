package pl.agileit.ewallet.transaction.model.builder;

import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.model.TransactionOwner;
import pl.agileit.ewallet.transaction.model.TransactionValue;

/**
 * @author lukasz barc
 */
public class TransactionBuilder {

    private long id;
    private TransactionOwner user;
    private TransactionValue value;

    private TransactionBuilder() {
    }

    public static TransactionBuilder aTransaction() {
        return new TransactionBuilder();
    }

    public TransactionBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public TransactionBuilder withUser(TransactionOwner user) {
        this.user = user;
        return this;
    }

    public TransactionBuilder withValue(TransactionValue value) {
        this.value = value;
        return this;
    }

    public Transaction build() {
        Transaction transaction = new Transaction(id, user, value);
        return transaction;
    }
}
