package pl.agileit.ewallet.transaction.model;

import static com.google.common.base.Objects.toStringHelper;

/**
 * @author lukasz barc
 */
public class TransactionOwner {
    private final long id;

    public TransactionOwner(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .toString();
    }
}
