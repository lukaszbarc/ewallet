package pl.agileit.ewallet.transaction.service;

import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;
import pl.agileit.ewallet.transaction.model.Transaction;

import static pl.agileit.ewallet.transaction.dao.dto.builder.TransactionDtoBuilder.aTransactionDto;
import static pl.agileit.ewallet.transaction.model.builder.TransactionBuilder.aTransaction;
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
                .build();
    }

    public Transaction toTransaction(final TransactionDto byId) {
        return aTransaction()
                .withId(byId.getId())
                .withUser(aTransactionOwner()
                        .withId(byId.getUserId())
                        .build())
                .withValue(aTransactionValue()
                        .withValue(byId.getValue())
                        .build())
                .build();
    }
}
