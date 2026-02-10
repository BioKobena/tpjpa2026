package jpa.dao;

import java.io.Serializable;

import jpa.dao.generic.src.main.java.fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jpa.model.Concert;

public class ConcertDao extends AbstractJpaDao<Serializable, Concert> {
    public ConcertDao() {
        this.setClazz(Concert.class);
    }
}
