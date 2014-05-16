package pl.agileit.ewallet.transaction.model.builder;

import pl.agileit.ewallet.transaction.model.TransactionCategory;

/**
 * @author lukasz barc
 */
public final class TransactionCategoryBuilder {
    private long id;

    private TransactionCategoryBuilder() {
    }

    public static TransactionCategoryBuilder aTransactionCategory() {
        return new TransactionCategoryBuilder();
    }

    public TransactionCategoryBuilder withId(final long id) {
        this.id = id;
        return this;
    }

    public TransactionCategory build() {
        return new TransactionCategory(id);
    }
}
