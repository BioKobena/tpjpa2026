package jpa.controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jpa.dao.ArtisteDao;
import jpa.dao.ConcertDao;
import jpa.model.Artiste;
import jpa.model.Concert;
import jpa.model.DTO.AddArtistesDTO;
import jpa.model.DTO.ConcertDTO;

@Path("/concert")
@Produces({ "application/json", "application/xml" })
public class ConcertController {

    private final ConcertDao concertDao = new ConcertDao();
    private final ArtisteDao artisteDao = new ArtisteDao();

    @POST
    @Consumes("application/json")
    public Response createConcert(ConcertDTO dto) {
        Concert concert = new Concert();
        concert.setLieu(dto.getLieu());
        concert.setDate(dto.getDate());
        concert.setGenreMusicale(dto.getGenreMusicale());
        concert.setDescription(dto.getDescription());
        concert.setPopularite(dto.getPopularite());
        concert.setNombrePlace(dto.getNombrePlace());
        concert.setPrixTicket(dto.getPrixTicket());

        concertDao.save(concert);
        concert.createTickets();
        concertDao.save(concert);

        List<Concert> listConcert = concertDao.findAll();
        return Response.ok().entity(listConcert).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConcert() {
        List<Concert> concerts = this.concertDao.findAll();
        return Response.ok().status(200).entity(concerts).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConcertById(@PathParam("id") Long id) {
        Concert concert = concertDao.findOne(id);
        if (concert == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(concert).build();
    }

    @POST
    @Path("/{id}/artistes")
    @Consumes("application/json")
    public Response addArtistes(@PathParam("id") Long concertId,
            AddArtistesDTO dto) {

        Concert concert = concertDao.findOne(concertId);
        if (concert == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        for (Long artisteId : dto.getArtisteIds()) {
            Artiste artiste = artisteDao.findOne(artisteId);
            concert.addArtiste(artiste);
        }

        concertDao.save(concert);

        List<Artiste> getAllArtistes = concert.getArtists();
        return Response.ok().entity(getAllArtistes).type(MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/update/{concertId}")
    @Consumes("application/json")
    public Response updateConcert(@PathParam("concertId") Long concertId, ConcertDTO dto) {
        Concert concert = concertDao.findOne(concertId);
        if (concert == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Ce concert n'existe pas").build();
        }

        concert.setLieu(dto.getLieu());
        concert.setDate(dto.getDate());
        concert.setGenreMusicale(dto.getGenreMusicale());
        concert.setDescription(dto.getDescription());
        concert.setPopularite(dto.getPopularite());
        concert.setNombrePlace(dto.getNombrePlace());
        concert.setPrixTicket(dto.getPrixTicket());

        Concert updated = this.concertDao.update(concert);
        return Response.ok().status(200).entity(updated).build();
    }

    @DELETE
    @Path("/delete/{concertId}")
    public Response deleteConcertById(@PathParam("concertId") int concertId) {
        this.concertDao.deleteById(concertId);
        return Response.ok().status(200).build();
    }
}
