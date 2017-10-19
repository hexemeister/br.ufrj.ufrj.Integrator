package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class PersistenceUtil {
	
	final static private String PERSISTENCE_UNIT = "mssql";
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	EntityManager em;
	Session session;
		
	public EntityManager getEntityManager() {
		em = emf.createEntityManager();
		return em;
	}
	
	public Session getSession() {
		session = getEntityManager().unwrap(Session.class); 		
		return session;
	}
	
	public void shutdown() {
		em.close();
		emf.close();
	}
}
