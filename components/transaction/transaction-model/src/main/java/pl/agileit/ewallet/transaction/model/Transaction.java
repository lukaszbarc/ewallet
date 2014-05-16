package pl.agileit.ewallet.transaction.model;

import static com.google.common.base.Objects.toStringHelper;

/**
 * @author lukasz barc
 */
public final class Transaction {

    private final long id;
    private final TransactionOwner user;
    private final TransactionValue value;
    private final String description;
    private final TransactionCostCenter costCenter;
    private final TransactionCategory category;

    public Transaction(final long id,
                       final TransactionOwner user,
                       final TransactionValue value,
                       final String description,
                       final TransactionCostCenter costCenter,
                       final TransactionCategory category) {
        this.id = id;
        this.user = user;
        this.value = value;
        this.description = description;
        this.costCenter = costCenter;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public TransactionCostCenter getCostCenter() {
        return costCenter;
    }

    public TransactionCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .add("user", user)
                .add("value", value)
                .add("description", description)
                .add("costCenter", costCenter)
                .add("category", category)
                .toString();
    }
}
