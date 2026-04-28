package jpa.dao;

import java.io.Serializable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jpa.EntityManagerHelper;
import jpa.dao.generic.src.main.java.fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jpa.model.Client;

public class ClientDao extends AbstractJpaDao<Serializable, Client> {

    protected EntityManager entityManager;

    public ClientDao() {
        this.entityManager = EntityManagerHelper.getEntityManager();
        this.setClazz(Client.class);
    }

    public Client getClientByEmail(String email) {
        try {
            return this.entityManager.createQuery(
                    "SELECT c FROM Client c WHERE c.email = :email",
                    Client.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
