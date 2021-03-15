package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.connection.Conexion;
import com.connection.HibernateUtil;

import interfazDao.InterfazProductoDao;
import model.Producto;

public class ProductoDaoImplementacion implements InterfazProductoDao {
	private List<Producto> productos = new ArrayList<>();
	
	private static Connection conecction;
	
	static {
        try {
			conecction = Conexion.conectar();
		} catch (SQLException e) {}
    }

	@Override
	public boolean anadeProducto(Producto producto) {
	
		return false;
	}

	@Override
	public Producto MostrarProducto(int id) {
		Statement statement;
		Producto p = null;
		
		try {
			statement = conecction.createStatement();
			String query = "select * from producto where codigo_producto = " + id;
			System.out.println("Query ejecutada: " + query);
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				p = obtenerProductoDeQuery(resultSet);
			}
		} catch (SQLException e) {
			System.out.println("**** DB Error (" + e.getErrorCode() + "): Fallo en la consulta ==> " + e.getMessage());
		}
		
		return p;
	}

	private Producto obtenerProductoDeQuery(ResultSet resultSet) {
		Producto p;
		try {
			p = new Producto(resultSet.getString("codigo_producto"));
			p.setNombre(resultSet.getString("nombre"));
			p.setGama(resultSet.getString("gama"));
			p.setDimensiones(resultSet.getString("dimensiones"));
			p.setProveedor(resultSet.getString("proveedor")); 
			p.setDescripcion(resultSet.getString("descripcion")); 
			p.setCantidadStock(resultSet.getInt("cantidad_en_stock"));
			p.setPrecioVenta(resultSet.getDouble("precio_venta"));
			p.setPrecioProveedor(resultSet.getDouble("precio_proveedor"));
		} catch (SQLException e) {
			System.out.println("**** DB Error (" + e.getErrorCode() + "): Fallo en la consulta ==> " + e.getMessage());
			p = null;
		}
		
		return p;
	}

	@Override
	public List<Producto> MostrarTodosProductos() {
		
		return null;
	}

	@Override
	public boolean editaProducto(Producto original, Producto nuevo) {
		    
		// Update BBDD
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(nuevo);
		
		try {
			session.getTransaction().commit();
		} catch (HibernateException e) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public void eliminar(Producto producto) {
		((List<Producto>) productos).remove(producto);
	}
	
	public void cerrarConexion()
	{
		try {
			if (conecction != null) {
				conecction.close();				
			}
		} catch (SQLException e) {
		}
	}
	
	private <T> String implode (List<T> object, String glue)
	{
		String AsImplodedString;
		if (object.size()==0) {
		    AsImplodedString = "";
		} else {
		    StringBuffer sb = new StringBuffer();
		    sb.append(object.get(0));
		    for (int i=1;i < object.size();i++) {
		        sb.append(glue);
		        sb.append(object.get(i));
		    }
		    AsImplodedString = sb.toString();
		}
		
		return AsImplodedString;
	}

}
