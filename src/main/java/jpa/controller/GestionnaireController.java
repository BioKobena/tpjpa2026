package jpa.controller;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.Response;
import jpa.dao.GestionnaireDao;
import jpa.model.Gestionnaire;

public class GestionnaireController {

    private final GestionnaireDao gestionnaireDao = new GestionnaireDao();

    @POST
    @Consumes("application/json")
    public Response createConcert(
            @Parameter(description = "Concert object that needs to be added to the store", required = true) Gestionnaire gestionnaire) {
       
        Gestionnaire g = new Gestionnaire();
        g.setNom(gestionnaire.getNom());
        g.setPrenom(gestionnaire.getPrenom());
        g.setGenre(gestionnaire.getGenre());
        g.setAge(gestionnaire.getAge());
        g.setPermission(gestionnaire.getPermission());
        // c.setDate(concert.getDate());
        // c.setDescription(concert.getDescription());
        // c.setGenreMusicale(concert.getGenreMusicale());
        // c.setLieu(concert.getLieu());
        // c.setNombrePlace(concert.getNombrePlace());
        // c.setPopularite(concert.getPopularite());
        gestionnaireDao.save(g);
        return Response.ok().entity(g).build();
        // return Response.ok().entity("SUCCESS").build();
    }
}
