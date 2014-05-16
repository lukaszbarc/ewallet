package pl.agileit.ewallet.transaction.service;

import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;
import pl.agileit.ewallet.transaction.model.Transaction;

import static pl.agileit.ewallet.transaction.dao.dto.builder.TransactionDtoBuilder.aTransactionDto;
import static pl.agileit.ewallet.transaction.model.builder.TransactionBuilder.aTransaction;
import static pl.agileit.ewallet.transaction.model.builder.TransactionCategoryBuilder.aTransactionCategory;
import static pl.agileit.ewallet.transaction.model.builder.TransactionCostCenterBuilder.aTransactionCostCenter;
import static pl.agileit.ewallet.transaction.model.builder.TransactionOwnerBuilder.aTransactionOwner;
import static pl.agileit.ewallet.transaction.model.builder.TransactionValueBuilder.aTransactionValue;

/**
 * @author lukasz barc
 */
public class TransactionAssembler {

    public TransactionDto toDto(final Transaction transaction) {
        return aTransactionDto()
                .withId(transaction.getId())
                .withUserId(transaction.getUser().getId())
                .withValue(transaction.getValue().getValue())
                .withDescription(transaction.getDescription())
                .withCategoryId(transaction.getCategory().getId())
                .withCostCenterId(transaction.getCostCenter().getId())
                .build();
    }

    public Transaction toTransaction(final TransactionDto transactionId) {
        return aTransaction()
                .withId(transactionId.getId())
                .withUser(aTransactionOwner()
                        .withId(transactionId.getUserId())
                        .build())
                .withValue(aTransactionValue()
                        .withValue(transactionId.getValue())
                        .build())
                .withCostCenter(aTransactionCostCenter()
                        .withId(transactionId.getCostCenterId())
                        .build())
                .withCategory(aTransactionCategory()
                        .withId(transactionId.getCategoryId())
                        .build())
                .withDescription(transactionId.getDescription())
                .build();
    }
}
