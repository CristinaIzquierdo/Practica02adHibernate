package com.connection;

import java.sql.SQLException;

import org.hibernate.Session;

import model.Cliente;

public class Main {
	public static void main (String[] args) throws SQLException {

			Session session = HibernateUtil.getSessionFactory().openSession();
			
			session.beginTransaction();
			Cliente c = new Cliente(666);
			
			c.setNombreCliente("cristina");
			c.setNombreContacto("cristina");
			c.setCiudad("Zaragoza");
			c.setTelefono("944865748");
			c.setFax("9448657487");
			c.setLineaDireccion1("casfdsfdsfdf");
			session.save(c);
			session.getTransaction().commit();		
	}
}
