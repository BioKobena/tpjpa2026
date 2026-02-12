package jpa.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;
import jpa.dao.ConcertDao;
import jpa.model.Concert;

public class ClientController {
    
    private final ConcertDao concertDao = new ConcertDao();

    @POST
    @Consumes("application/json")
    public Response createConcert(
            // @Parameter(description = "Concert object that needs to be added to the store", required = true)
             Concert concert) {
        Concert c= new Concert();
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
