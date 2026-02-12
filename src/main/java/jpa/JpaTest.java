package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.controller.ArtisteController;
import jpa.controller.ConcertController;
import jpa.dao.ConcertDao;
import jpa.model.Artiste;
import jpa.model.Concert;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();

		// JpaTest test = new JpaTest(manager);

		Concert c = new Concert();
		Artiste a = new Artiste();
		// ConcertDao concertDao = new ConcertDao();
		// EntityTransaction tx = manager.getTransaction();

		ArtisteController artisteController = new ArtisteController();
		ConcertController concertController = new ConcertController();
		try {

			// a.setAge(25);
			// a.setGenre("m");
			// a.setNationalite("Ivoirienne");
			// a.setNom("Blle");
			// a.setPrenom("Junior");
			// artisteController.createArtiste(a);
			c.setLieu("lieu");
		c.setDate("15/10/2000");
			c.setGenreMusicale("Gospel");
			c.setDescription("Description");
			c.setPopularite(5);
			c.setNombrePlace(200);
			concertController.createConcert(c);
			// concertDao.save(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
