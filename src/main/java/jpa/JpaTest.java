package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
		Concert concert = new Concert();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			concert.setDate("15/04/2026");
			concert.setDescription("Concert");
			concert.setGenreMusicale("Gospel");
			concert.setLieu("Rennes");
			concert.setNombrePlace(20);
			concert.setPopularite(5);
			manager.persist(concert);
			// TODO create and persist entity
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
