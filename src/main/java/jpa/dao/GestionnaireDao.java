package jpa.dao;

import java.io.Serializable;

import jpa.dao.generic.src.main.java.fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jpa.model.Gestionnaire;

public class GestionnaireDao extends AbstractJpaDao<Serializable, Gestionnaire> {
    public GestionnaireDao() {
        this.setClazz(Gestionnaire.class);
    }
}
