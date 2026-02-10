package jpa.dao;

import java.io.Serializable;

import jpa.dao.generic.src.main.java.fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jpa.model.Artiste;

public class ArtisteDao extends AbstractJpaDao<Serializable, Artiste> {
    public ArtisteDao() {
        this.setClazz(Artiste.class);
    }
}
