package jpa.controller;

import java.util.Collection;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jpa.dao.ArtisteDao;
import jpa.model.Artiste;

@Path("artiste")
@Produces({ "application/json", "application/xml" })
public class ArtisteController {

    private ArtisteDao artisteDao;

    @GET
    @Path("/")
    public Collection<Artiste> getArtiste() {
        return artisteDao.findAll();
    }

    @GET
    @Path("/artisteId")
    public Artiste getPet(@PathParam("artisteId") Long artisteId) {
        return artisteDao.findOne(artisteId);
    }

    @POST
    @Consumes("application/json")
    public Response createArtiste(
            // @Parameter(description = "Artiste object that needs to be added to the store", required = true)
             Artiste artiste) {
        Artiste artiste1 = new Artiste();
        artiste1.setAge(artiste.getAge());
        artiste1.setGenre(artiste.getGenre());
        artiste1.setNationalite(artiste.getNationalite());
        artiste1.setNom(artiste.getNom());
        artiste1.setPrenom(artiste.getPrenom());
        artisteDao.save(artiste1);
        return Response.ok().entity(artiste1).build();
        // return Response.ok().entity("SUCCESS").build();
    }

}
