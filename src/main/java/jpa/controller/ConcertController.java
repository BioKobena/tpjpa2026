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
@Produces({ "application/json", "application/xml" })
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
        // // System.out.println(con);
        // }
        // for (Concert concert : c) {
        // System.out.print(concert);
        // }
        return concertDao.findAll();
    }

    @POST
    @Consumes("application/json")
    public Response createConcert(Concert concert) {
        Concert c = new Concert();
        c.setDate(concert.getDate());
        c.setDescription(concert.getDescription());
        c.setGenreMusicale(concert.getGenreMusicale());
        c.setLieu(concert.getLieu());
        c.setNombrePlace(concert.getNombrePlace());
        c.setPopularite(concert.getPopularite());
        concertDao.save(c);
        List<Concert> listConcert = this.concertDao.findAll();
        return Response.status(200).entity(listConcert).type(MediaType.APPLICATION_JSON).build();
    }

    // @PUT
    // @Path("/concertId")
    // public Response updateConcert(@PathParam("concertId") Concert c) {
    // Concert concert = this.concertDao.update(c);
    // return Response.ok().status(200).entity(concert).build();

    // }

    // @DELETE
    // @Path("/concertId")
    // public Response deleteConcertById(Long concertId) {

    // if (concertId == null)
    // return Response.status(404).build();
    // this.concertDao.deleteById(concertId);
    // return Response.ok().status(200).build();
    // }
}
