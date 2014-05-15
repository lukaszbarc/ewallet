package pl.agileit.ewallet.transaction.rest;

import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDto;
import pl.agileit.ewallet.transaction.rest.dto.TransactionRestDtoList;

import javax.ws.rs.*;
import java.util.List;

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

    @GET
    @Path("/{identity}/list")
    @Consumes(JSON)
    @Produces(JSON)
    TransactionRestDtoList getTransactionByUser(@PathParam("identity")long userId);
}
