package jpa.dao;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.EntityManagerHelper;
import jpa.dao.generic.src.main.java.fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import jpa.model.Ticket;

public class TicketDao extends AbstractJpaDao<Serializable, Ticket> {
    protected EntityManager em;

    public TicketDao() {
        this.setClazz(Ticket.class);
        this.em = EntityManagerHelper.getEntityManager();
    }

    public List<Ticket> findByConcertId(int concertId) {
        return em.createQuery(
                "SELECT t FROM Ticket t WHERE t.concert.id = :concertId",
                Ticket.class)
                .setParameter("concertId", concertId)
                .getResultList();
    }
}
