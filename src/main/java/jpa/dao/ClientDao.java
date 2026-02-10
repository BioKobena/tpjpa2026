package jpa.dao;

import java.io.Serializable;

import jpa.dao.generic.src.main.java.fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jpa.model.Client;

public class ClientDao extends AbstractJpaDao<Serializable, Client> {
    public ClientDao() {
        this.setClazz(Client.class);
    }
}
