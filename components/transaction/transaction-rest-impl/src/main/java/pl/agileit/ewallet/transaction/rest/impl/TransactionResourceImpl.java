package pl.agileit.ewallet.transaction.rest.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.agileit.ewallet.transaction.model.Transaction;
import pl.agileit.ewallet.transaction.rest.ITransactionResource;
import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;
import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDtoList;
import pl.agileit.ewallet.transaction.service.ITransactionService;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

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

    @Override
    public TransactionRestDto getTransaction(final long txId) {
        LOGGER.trace(">>getTransaction({})", txId);
        return transactionRestAssembler.toTransactionRestDto(
                transactionService.getTransaction(txId)
        );
    }

    @Override
    public TransactionRestDtoList getTransactionByUser(final long userId) {
        LOGGER.trace(">>getTransactionByUser({})", userId);
        return new TransactionRestDtoList(
                transform(transactionService.getTransactionByUser(userId), new Function<Transaction, TransactionRestDto>() {
                    @Override
                    public TransactionRestDto apply(final Transaction transaction) {
                        return transactionRestAssembler.toTransactionRestDto(transaction);
                    }
                }));
    }

    public void setTransactionService(final ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void setTransactionRestAssembler(final TransactionRestAssembler transactionRestAssembler) {
        this.transactionRestAssembler = transactionRestAssembler;
    }
}
