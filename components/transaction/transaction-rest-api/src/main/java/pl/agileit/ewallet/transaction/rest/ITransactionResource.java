package pl.agileit.ewallet.transaction.rest;

import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;

import javax.ws.rs.*;

/**
 * @author lukasz barc
 */
@Path("/transactions")
public interface ITransactionResource {

    String JSON = "application/json";

    @POST
    @Path("/register")
    @Consumes(JSON)
    @Produces(JSON)
    void registerTransaction(TransactionRestDto transactionRestDto);

    @GET
    @Path("/{identity}")
    @Consumes(JSON)
    @Produces(JSON)
    TransactionRestDto getTransaction(@PathParam("identity") long txId);
}
