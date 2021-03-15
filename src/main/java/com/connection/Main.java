package com.connection;

import java.sql.SQLException;

import org.hibernate.Session;

import model.Cliente;

public class Main {
	public static void main (String[] args) throws SQLException {
//		Conexion.conectar();
//		System.exit(0);
//		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			session.beginTransaction();
			Cliente c = new Cliente(666);
			
			c.setNombreCliente("daniel");
			c.setNombreContacto("Daniel");
			c.setCiudad("Zaragoza");
			c.setTelefono("657464532");
			c.setFax("989548874");
			c.setLineaDireccion1("sadasd");
			session.save(c);
			session.getTransaction().commit();
//		} catch (ExceptionInInitializerError e) {
//			System.out.println(" ====> ERROR: " + e.getMessage());
//		}
		 
       
 
		
	}
}
