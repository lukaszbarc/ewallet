package pl.agileit.ewallet.transaction.rest;

import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author lukasz barc
 */
@Path("/")
public interface ITransactionResource {

    @POST
    @Path("/register")
    @Consumes("application/json")
    void registerTransaction(TransactionRestDto transactionRestDto);
}
