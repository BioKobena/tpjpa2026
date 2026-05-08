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
        g.setEmail(dto.email);
        g.setPermission(dto.permission);
        gestionnaireDao.save(g);
        List<Gestionnaire> listGesionnaire = this.gestionnaireDao.findAll();
        return Response.ok().entity(listGesionnaire).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/gestionnaires")
    @Consumes("application/json")
    public Response getGestionnaire() {
        List<Gestionnaire> gestionnaires = this.gestionnaireDao.findAll();
        return Response.ok(gestionnaires).build();
    }

    @GET
    @Path("/getGestionnaire/{gestionnaireId}")
    public Response getGestionnaireById(@PathParam("gestionnaireId") int gestionnaireId) {
        Gestionnaire gId = this.gestionnaireDao.findOne(gestionnaireId);
        return Response.ok(gId).status(200).build();
    }

    @GET
    @Path("/email/{email}")
    public Response getGestionnaireByEmail(@PathParam("email") String email) {
        Gestionnaire gestionnaire = this.gestionnaireDao.getByEmail(email);
        if (gestionnaire == null) {
            return Response.status(404).build();
        }
        return Response.ok(gestionnaire).status(200).build();
    }

    @PUT
    @Path("/update/{gestionnaireId}")
    @Consumes("application/json")
    public Response updateGestionnaire(@PathParam("gestionnaireId") int gestionnaireId, GestionnaireDTO dto) {
        Gestionnaire gestionnaire = this.gestionnaireDao.findOne(gestionnaireId);
        if (gestionnaire == null) {
            return Response.status(404).build();
        }

        gestionnaire.setNom(dto.nom);
        gestionnaire.setPrenom(dto.prenom);
        gestionnaire.setGenre(dto.genre);
        gestionnaire.setAge(dto.age);
        gestionnaire.setEmail(dto.email);
        gestionnaire.setPermission(dto.permission);

        Gestionnaire updated = this.gestionnaireDao.update(gestionnaire);
        return Response.ok(updated).status(200).build();
    }

    @DELETE
    @Path("/{gestionnaireId}")
    public Response deleteGestionnaire(@PathParam("gestionnaireId") int gestionnaireId) {
        this.gestionnaireDao.deleteById(gestionnaireId);
        return Response.ok().status(200).build();
    }
}
