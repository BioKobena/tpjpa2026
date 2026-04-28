package jpa.controller;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jpa.dao.ClientDao;
import jpa.dao.TicketDao;
import jpa.model.Client;
import jpa.model.Ticket;

@Path("/tickets")
@Produces({ "application/json", "application/xml" })
public class TicketController {

    private final TicketDao ticketDao = new TicketDao();
    private final ClientDao clientDao = new ClientDao();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getAllTickets() {
        return ticketDao.findAll();
    }

    @GET
    @Path("/client/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getTicketsByClient(@PathParam("clientId") int clientId) {
        return ticketDao.findAll().stream()
                .filter(ticket -> ticket.getClient() != null && ticket.getClient().getId() == clientId)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/concert/{concertId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getTicketsByConcert(@PathParam("concertId") int concertId) {
        return ticketDao.findByConcertId(concertId);
    }

    @PUT
    @Path("/buy/{ticketId}/client/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response acheterTicket(
            @PathParam("ticketId") int ticketId,
            @PathParam("clientId") int clientId) {
        Ticket ticket = ticketDao.findOne(ticketId);
        Client client = clientDao.findOne(clientId);

        if (ticket == null) {
            return Response.status(404).entity("Ticket non trouvé").build();
        }
        if (client == null) {
            return Response.status(404).entity("Client non trouvé").build();
        }

        if (ticket.getClient() != null) {
            return Response.status(409)
                    .entity("Ticket déjà acheté par un client")
                    .build();
        }

        ticket.setClient(client);
        ticketDao.update(ticket);

        return Response.ok()
                .status(200)
                .entity(ticket)
                .build();
    }

    @DELETE
    @Path("/delete/{ticketId}")
    public Response deleteTicket(@PathParam("ticketId") int ticketId) {
        Ticket ticket = ticketDao.findOne(ticketId);
        if (ticket == null) {
            return Response.status(404).entity("Ticket non trouvé").build();
        }
        ticketDao.delete(ticket);
        return Response.ok().status(200).build();
    }
}
