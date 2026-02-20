package jpa.controller;

import java.util.Collection;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jpa.dao.ConcertDao;
import jpa.model.Concert;

@Path("/concert")
public class ConcertController {

    private final ConcertDao concertDao = new ConcertDao();
    @GET
    @Path("/concert")
    public Collection<Concert> getConcert() {
        return concertDao.findAll();
    }

    @POST
    @Consumes("application/json")
    public Response createConcert(
            // @Parameter(description = "Concert object that needs to be added to the
            // store", required = true)
            Concert concert) {
        Concert c = new Concert();
        c.setDate(concert.getDate());
        c.setDescription(concert.getDescription());
        c.setGenreMusicale(concert.getGenreMusicale());
        c.setLieu(concert.getLieu());
        c.setNombrePlace(concert.getNombrePlace());
        c.setPopularite(concert.getPopularite());
        concertDao.save(c);
        return Response.ok().entity(c).build();
        // return Response.ok().entity("SUCCESS").build();
    }
}
