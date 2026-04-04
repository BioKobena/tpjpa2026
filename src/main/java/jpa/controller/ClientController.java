package jpa.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jpa.dao.ClientDao;
import jpa.model.Client;
import jpa.model.DTO.ClientDTO;

@Path("client")
@Produces({ "application/json", "application/xml" })
public class ClientController {

    private final ClientDao clientDao = new ClientDao();

    @POST
    @Consumes("application/json")
    public Response createClient(ClientDTO dto) {
        Client c = new Client();
        c.setAge(dto.age);
        c.setCompteBancaire(dto.compte_bancaire);
        c.setGenre(dto.genre);
        c.setNom(dto.nom);
        c.setPrenom(dto.prenom);
        clientDao.save(c);

        List<Client> listClient = this.clientDao.findAll();
        return Response.ok().entity(listClient).type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Consumes("application/json")
    public Response getAllClient() {
        List<Client> listClient = this.clientDao.findAll();
        return Response.ok(listClient, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Consumes("application/json")
    public Client getClientByEmail(@Parameter(description = "", required = true) String email) {
        Client cl = this.clientDao.getClientByEmail(email);
        return cl;
    }

    @PUT
    public Response updateClient(Client user) {
        Client cl = this.clientDao.update(user);
        return Response.ok().status(200).entity(cl).build();
    }

    @DELETE
    public Response deleteClient(String id) {
        if (id == null)
            return Response.ok().status(404).build();
        this.clientDao.deleteById(id);
        return Response.ok().status(200).build();
    }

}
