package pl.agileit.ewallet.transaction.rest;

import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author lukasz barc
 */
@Path("/transactions")
public interface ITransactionResource {

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    void registerTransaction(TransactionRestDto transactionRestDto);
}
