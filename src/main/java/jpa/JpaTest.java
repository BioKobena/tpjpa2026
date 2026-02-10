package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.dao.ConcertDao;
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

		JpaTest test = new JpaTest(manager);

		Concert c = new Concert();
		ConcertDao concertDao = new ConcertDao();
		EntityTransaction tx = manager.getTransaction();
		// tx.begin();

		try {
			c.setLieu("lieu");
			c.setDate("15/2/2000");
			c.setGenreMusicale("Gospel");
			c.setDescription("Description");
			c.setPopularite(5);
			c.setNombrePlace(200);
			concertDao.save(c);
			manager.persist(c);
			// TODO create and persist entity
		} catch (Exception e) {
			e.printStackTrace();
		}
		// tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
