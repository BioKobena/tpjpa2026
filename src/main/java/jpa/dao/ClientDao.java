package jpa.dao;

import java.io.Serializable;

import jakarta.persistence.EntityManager;
import jpa.EntityManagerHelper;
import jpa.dao.generic.src.main.java.fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jpa.model.Client;

public class ClientDao extends AbstractJpaDao<Serializable, Client> {

    protected EntityManager entityManager;
    private Class<Client> clientClazz;

    public ClientDao() {
        this.entityManager = EntityManagerHelper.getEntityManager();
        this.setClazz(Client.class);
    }

    public Client getClientByEmail(String email) {
        return this.entityManager.find(clientClazz, email);
    }
}
