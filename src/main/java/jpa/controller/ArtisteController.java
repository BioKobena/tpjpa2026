package jpa.controller;

import java.util.Collection;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jpa.dao.ArtisteDao;
import jpa.model.Artiste;
import jpa.model.DTO.ArtisteDTO;

@Path("artiste")
@Produces({ "application/json", "application/xml" })
public class ArtisteController {
    private final ArtisteDao artisteDao = new ArtisteDao();

    @POST
    @Consumes("application/json")
    public Response createArtiste(ArtisteDTO dto) {
        System.out.println("Début : Création de l'artiste");

        Artiste a = new Artiste();
        a.setAge(dto.age);
        a.setGenre(dto.genre);
        a.setNationalite(dto.nationalite);
        a.setNom(dto.nom);
        a.setPrenom(dto.prenom);

        artisteDao.save(a);

        List<Artiste> listArtist = this.artisteDao.findAll();
        System.out.println("Fin : Création de l'artiste");
        return Response.ok().entity(listArtist).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/tous")
    public Collection<Artiste> getArtiste() {
        return artisteDao.findAll();
    }

    // @GET
    // @Path("/artisteId")
    // public Artiste getPet(@PathParam("artisteId") Long artisteId) {
    // return artisteDao.findOne(artisteId);
    // }

    // @PUT
    // @Path("/artisteId")
    // public Response updateArtiste(@PathParam("id") Artiste artiste) {

    // if (artiste == null)
    // return Response.status(404).build();
    // Artiste a = this.artisteDao.update(artiste);

    // return Response.ok().status(200).entity(a).build();
    // }

    // @DELETE
    // @Path("/artisteId")
    // public Response deleteArtiste(@PathParam("artisteId") Artiste a) {

    // if (a == null)
    // return Response.status(404).build();
    // this.artisteDao.delete(a);
    // return Response.ok().status(200).build();
    // }

    public ArtisteDao getArtisteDao() {
        return artisteDao;
    }
}
