package pl.agileit.ewallet.transaction.model;

import static com.google.common.base.Objects.toStringHelper;

/**
 * @author lukasz barc
 */
public final  class Transaction {

    private final long id;
    private final TransactionOwner user;
    private final TransactionValue value;

    public Transaction(final long id,
                       final TransactionOwner user,
                       final TransactionValue value) {
        this.id = id;
        this.user = user;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public TransactionOwner getUser() {
        return user;
    }

    public TransactionValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .add("user", user)
                .add("value", value)
                .toString();
    }
}
