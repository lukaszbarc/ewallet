package pl.agileit.ewallet.transaction.rest.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.agileit.ewallet.transaction.rest.ITransactionResource;
import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;
import pl.agileit.ewallet.transaction.service.ITransactionService;

/**
 * @author lukasz barc
 */
public final class TransactionResourceImpl implements ITransactionResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionResourceImpl.class);
    private ITransactionService transactionService;
    private TransactionRestAssembler transactionRestAssembler;

    @Override
    public void registerTransaction(final TransactionRestDto transactionRestDto) {
        LOGGER.trace(">>registerTransaction({})", transactionRestDto);
        transactionService.registerTransaction(transactionRestDto.getUserId(),
                transactionRestAssembler.toTransaction(transactionRestDto)
        );

    }

    public void setTransactionService(final ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void setTransactionRestAssembler(final TransactionRestAssembler transactionRestAssembler) {
        this.transactionRestAssembler = transactionRestAssembler;
    }
}
