package pl.agileit.ewallet.transaction.service;

import pl.agileit.ewallet.transaction.dao.dto.TransactionDto;
import pl.agileit.ewallet.transaction.model.Transaction;

import static pl.agileit.ewallet.transaction.dao.dto.builder.TransactionDtoBuilder.aTransactionDto;

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
}
