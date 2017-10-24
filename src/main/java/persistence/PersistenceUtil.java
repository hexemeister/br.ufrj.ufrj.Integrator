package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.hibernate.Session;

@Stateless
public class PersistenceUtil {
	
	final static private String PERSISTENCE_UNIT = "mssql";
	
	@PersistenceUnit(unitName = PERSISTENCE_UNIT)
	private static EntityManagerFactory factory;
	private static EntityManager em;
	private static Session session;
		
	public static EntityManagerFactory getEntityManagerFactory() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		return factory;
	}
	public static EntityManager getEntityManager() {
		em = factory.createEntityManager();
		return em;
	}
	
	public static Session getSession() {
		session = getEntityManager().unwrap(Session.class); 		
		return session;
	}
	
	public void shutdown() {
		em.close();
		factory.close();
	}
}
