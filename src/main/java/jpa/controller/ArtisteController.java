package jpa.controller;

import java.util.Collection;
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
        a.setAge(dto.getAge());
        a.setGenre(dto.getGenre());
        a.setEmail(dto.getEmail());
        a.setNationalite(dto.getNationalite());
        a.setNom(dto.getNom());
        a.setPrenom(dto.getPrenom());

        artisteDao.save(a);

        List<Artiste> listArtist = this.artisteDao.findAll();
        System.out.println("Fin : Création de l'artiste");
        return Response.ok().entity(listArtist).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/all")
    public Collection<Artiste> getArtiste() {
        Collection<Artiste> artistes = this.artisteDao.findAll();
        return artistes;
    }

    @GET
    @Path("/getArtist/{artisteId}")
    public Artiste getPet(@PathParam("artisteId") Long artisteId) {
        return artisteDao.findOne(artisteId);
    }

    @PUT
    @Path("/update/{artisteId}")
    @Consumes("application/json")
    public Response updateArtiste(@PathParam("artisteId") Long artisteId, Artiste dto) {
        Artiste artiste = artisteDao.findOne(artisteId);
        if (artiste == null) {
            return Response.status(404).build();
        }
        artiste.setNom(dto.getNom());
        artiste.setPrenom(dto.getPrenom());
        artiste.setGenre(dto.getGenre());
        artiste.setAge(dto.getAge());
        artiste.setNationalite(dto.getNationalite());

        Artiste updated = this.artisteDao.update(artiste);

        return Response.ok().status(200).entity(updated).build();
    }

    @DELETE
    @Path("/delete/{artisteId}")
    public Response deleteArtiste(@PathParam("artisteId") Long artisteId) {
        Artiste artiste = artisteDao.findOne(artisteId);
        if (artiste == null) {
            return Response.status(404).build();
        }
        this.artisteDao.delete(artiste);
        return Response.ok().status(200).build();
    }
}
