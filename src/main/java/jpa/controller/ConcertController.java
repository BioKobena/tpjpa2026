package jpa.controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jpa.dao.ConcertDao;
import jpa.model.Concert;

@Path("/concert")
public class ConcertController {

    private final ConcertDao concertDao = new ConcertDao();
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Concert> getConcert() {
        // List<Concert> listConcert = new ArrayList<Concert>();
        // listConcert = concertDao.findAll();
        // Collection<Concert> c = concertDao.findAll();
        // for (Collection<Concert> c : listConcert) {
        //     // System.out.println(con);
        // }
        // for (Concert concert : c) {
        //     System.out.print(concert);
        // }
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
