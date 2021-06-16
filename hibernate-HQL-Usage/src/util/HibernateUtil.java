package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final String HIBERNATE_CFG_XML_PATH = "config/hibernate.cfg.xml";
	
	
	
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure(HIBERNATE_CFG_XML_PATH).buildSessionFactory();
			
		} catch (Throwable e) {
			throw new ExceptionInInitializerError();
		}
		
	}
	
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	
}
