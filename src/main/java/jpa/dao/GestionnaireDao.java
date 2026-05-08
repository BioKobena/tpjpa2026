package jpa.dao;

import java.io.Serializable;

import jakarta.persistence.NoResultException;
import jpa.dao.generic.src.main.java.fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jpa.model.Gestionnaire;

public class GestionnaireDao extends AbstractJpaDao<Serializable, Gestionnaire> {
    public GestionnaireDao() {
        this.setClazz(Gestionnaire.class);
    }

    public Gestionnaire getByEmail(String email) {
        try {
            return this.entityManager
                    .createQuery("SELECT g FROM Gestionnaire g WHERE g.email = :email", Gestionnaire.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }
    }
}
