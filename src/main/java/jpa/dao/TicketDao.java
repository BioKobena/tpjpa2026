package jpa.dao;

import java.io.Serializable;

import jpa.dao.generic.src.main.java.fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jpa.model.Ticket;

public class TicketDao extends AbstractJpaDao<Serializable, Ticket> {
    public TicketDao() {
        this.setClazz(Ticket.class);
    }
}
