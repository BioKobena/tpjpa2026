package jpa.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jpa.dao.TicketDao;
import jpa.model.Concert;
import jpa.model.Ticket;

@Path("/tickets")
@Produces({ "application/json", "application/xml" })
public class TicketController {

    private final TicketDao ticketDao = new TicketDao();

    @POST
    @Consumes
    public Response createTicket(Ticket ticket, Concert concert) {
        Ticket t = new Ticket();
        t.setConcert(ticket.getConcert());
        t.setPrix(ticket.getPrix());

        // concert.getNombrePlace()
        ticketDao.save(t);
        return Response.ok().status(200).entity(t).build();
    }

    @GET
    @Path("/ticketById")
    public Ticket getTicketByUserId(int ticketById) {
        Ticket tickId = this.ticketDao.findOne(ticketById);
        return tickId;
    }

    @DELETE
    @Path("/ticketId")
    public Response deleteTicketById(Long ticketId) {
        if (ticketId == null)
            return Response.ok().status(404).build();
        this.ticketDao.deleteById(ticketId);
        return Response.ok().status(200).build();
    }

    @PUT
    public Response updateTicket(Ticket t) {

        if (t == null)
            return Response.ok().status(404).build();
        Ticket ticket = this.ticketDao.update(t);

        return Response.ok().status(200).entity(ticket).build();
    }
}
