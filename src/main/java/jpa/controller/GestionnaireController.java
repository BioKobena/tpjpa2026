package jpa.controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jpa.dao.GestionnaireDao;
import jpa.model.DTO.GestionnaireDTO;
import jpa.model.Gestionnaire;

@Path("gestionnaire")
@Produces({ "application/json", "application/xml" })
public class GestionnaireController {

    private final GestionnaireDao gestionnaireDao = new GestionnaireDao();

    @POST
    @Consumes("application/json")
    public Response createGestionnaire(GestionnaireDTO dto) {
        Gestionnaire g = new Gestionnaire();
        g.setNom(dto.nom);
        g.setPrenom(dto.prenom);
        g.setGenre(dto.genre);
        g.setAge(dto.age);
        g.setPermission(dto.permission);
        gestionnaireDao.save(g);
        List<Gestionnaire> listGesionnaire = this.gestionnaireDao.findAll();
        return Response.ok().entity(listGesionnaire).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/gestionnaires")
    @Consumes("application/json")
    public List<Gestionnaire> getGestionnaire() {
        List<Gestionnaire> gestionnaires = this.gestionnaireDao.findAll();
        return gestionnaires;
    }

    @GET
    @Path("/gestionnaireId")
    public Gestionnaire getGestionnaireById(int gestionnaireId) {
        Gestionnaire gId = this.gestionnaireDao.findOne(gestionnaireId);
        return gId;
    }

    @DELETE
    @Path("/gestionnaireId")
    public Response deleteGestionnaire(int gestionnaireId) {
        this.gestionnaireDao.deleteById(gestionnaireId);
        return Response.ok().status(200).build();
    }

    @PUT
    @Path("/gestionnaireId")
    public Response updateGestionnaire(Gestionnaire g) {

        if (g == null)
            return Response.ok().status(404).build();

        this.gestionnaireDao.update(g);

        return Response.ok().status(200).entity(g).build();
    }
}
