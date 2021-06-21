package com.era.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.era.hibernate.model.Customer;

public class HibernateUtil {
private static SessionFactory sessionFactory;

public static SessionFactory getSessionFactory(){
	if(sessionFactory == null){
		
		try{
			org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
			
			System.out.println("heree berfore propertioes");
			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/test?useSSL=false");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

			settings.put(Environment.SHOW_SQL, "true");

			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

			settings.put(Environment.HBM2DDL_AUTO, "create-drop");

			configuration.setProperties(settings);
			
			configuration.addAnnotatedClass(Customer.class);
			System.out.println("heree after config");

//			ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()
//					.applySettings(configuration.getProperties()).build();
//			System.out.println("Hibernate Java Config serviceRegistry created");
//			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			System.out.println("before returing session factory"+sessionFactory);
			return sessionFactory;

		
		}catch(Exception e){
			
		}

}
	return sessionFactory;	
}


}
