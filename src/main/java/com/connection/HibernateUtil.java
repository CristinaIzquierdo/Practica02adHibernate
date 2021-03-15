package com.connection;
 
//import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

 
public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();
      
    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration configuration = new Configuration();
        	configuration.configure();
        	 
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//        	System.out.println(configuration.getProperty("hibernate.connection.url"));
        	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            // Create the SessionFactory from hibernate.cfg.xml
//            return new Configuration().configure(new File("hibernate.cgf.xml")).buildSessionFactory();

        	return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
