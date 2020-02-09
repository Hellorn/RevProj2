package dev.teamname.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf = null;
	


public static SessionFactory getSessionFactory() {
	
	if(sf == null) {
		Configuration cfg = new Configuration();
		sf = cfg.configure().buildSessionFactory();
	}
	//Make sure to only have one sessionfactory
	//It is not a lightweight object. In other words, takes a lot of memory
	return sf;
	
	
	
}
}
