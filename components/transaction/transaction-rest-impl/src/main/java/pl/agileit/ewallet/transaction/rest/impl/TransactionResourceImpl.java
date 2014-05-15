package pl.agileit.ewallet.transaction.rest.impl;

import pl.agileit.ewallet.transaction.rest.ITransactionResource;
import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;
import pl.agileit.ewallet.transaction.service.ITransactionService;

/**
 * @author lukasz barc
 */
public final class TransactionResourceImpl implements ITransactionResource {

    private ITransactionService transactionService;
    private TransactionRestAssembler transactionRestAssembler;

    @Override
    public void registerTransaction(final TransactionRestDto transactionRestDto) {
        transactionService.registerTransaction(transactionRestDto.getUserId(),
                transactionRestAssembler.toTransaction(transactionRestDto)
        );

    }
}
