package pl.agileit.ewallet.transaction.rest.impl;

import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;

import static pl.agileit.ewallet.transaction.model.builder.TransactionBuilder.aTransaction;
import static pl.agileit.ewallet.transaction.model.builder.TransactionOwnerBuilder.aTransactionOwner;
import static pl.agileit.ewallet.transaction.model.builder.TransactionValueBuilder.aTransactionValue;
import static pl.agileit.ewallet.transaction.rest.dto.builder.TransactionRestDtoBuilder.aTransactionRestDto;

/**
 * @author lukasz barc
 */
public class TransactionRestAssembler {
    public Transaction toTransaction(final TransactionRestDto transactionRestDto) {
        return aTransaction()
                .withId(transactionRestDto.getId())
                .withUser(aTransactionOwner()
                        .withId(transactionRestDto.getUserId())
                        .build())
                .withValue(aTransactionValue()
                        .withValue(transactionRestDto.getValue())
                        .build())
                .build();
    }

    public TransactionRestDto toTransactionRestDto(final Transaction transaction) {
        return aTransactionRestDto()
                .withId(transaction.getId())
                .withUserId(transaction.getUser().getId())
                .withValue(transaction.getValue().getValue())
                .build();
    }
}
