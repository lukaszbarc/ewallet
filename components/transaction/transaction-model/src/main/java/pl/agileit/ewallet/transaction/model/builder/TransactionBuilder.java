package pl.agileit.ewallet.transaction.model.builder;

import pl.agileit.ewallet.transaction.model.*;

/**
 * @author lukasz barc
 */
public final class TransactionBuilder {

    private long id;
    private TransactionOwner user;
    private TransactionValue value;
    private TransactionCostCenter costCenter;
    private TransactionCategory category;
    private String description;

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

    public TransactionBuilder withCostCenter(final TransactionCostCenter costCenter) {
        this.costCenter = costCenter;
        return this;
    }

    public TransactionBuilder withCategory(final TransactionCategory category) {
        this.category = category;
        return this;
    }

    public TransactionBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }


    public Transaction build() {
        return new Transaction(id, user, value, description, costCenter, category);
    }
}
