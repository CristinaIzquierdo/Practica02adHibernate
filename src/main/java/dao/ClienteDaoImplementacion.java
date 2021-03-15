package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.connection.Conexion;
import com.connection.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;

import exceptions.ClientNotFound;
import exceptions.DuplicateException;
import interfazDao.InterfazClienteDao;
import model.Cliente;
import model.DetallePedido;
import model.Pedido;

public class ClienteDaoImplementacion implements InterfazClienteDao {

	private static Connection conecction;
	
	static {
        try{
            conecction = Conexion.conectar();
        } catch (SQLException e){
            System.out.println("No hemos podido conectar a la base de datos");
        }
    }
	
	@Override
	public boolean anadeCliente(Cliente c) throws DuplicateException {
		Statement statement;
		

			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Serializable id = session.save(c);
			session.getTransaction().commit();
			
			return id != null; 
			

	}


	@Override
	public Cliente MostrarCliente(int id) throws ClientNotFound {
		Cliente c = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = (Cliente)session.get(Cliente.class,id);
		
		if (cliente != null) {
			return cliente;
		} else {
			throw new ClientNotFound();
		}
	}


	@SuppressWarnings("unchecked")
	public List<Cliente> findAllClients() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createQuery("from Cliente");
		List<Cliente> list = query.list();

		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarPorTexto(String cadenaTexto) {
		String hql = "from Cliente WHERE nombre_cliente like concat('%',:cadenaTexto,'%') OR apellido_contacto like concat('%',:cadenaTexto,'%')  OR nombre_contacto like concat('%',:cadenaTexto,'%') ";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setParameter("cadenaTexto", cadenaTexto);
				
		List<Cliente> resultsList = query.list();
		
		return resultsList;
				
	}

	@Override
	public void actualizar(Cliente cliente, String[] params) {
//		cliente.setNombreCliente(Objects.requireNonNull(params[0], "Nombre cannot be null"));
//		cliente.setApellidoContacto(Objects.requireNonNull(params[1], "Apellido cannot be null"));
//		    
//		clientes.add(cliente);
	}

	@Override
	public void eliminar(Cliente cliente) {
//		clientes.remove(cliente);
	}


	public boolean tienePosibleDuplicado(Cliente cliente) {
//		for (Cliente c : clientes) {
//			if (
//				cliente.getNombreCliente().equals(c.getNombreCliente())  
//				|| cliente.getApellidoContacto().equals(c.getApellidoContacto())
//				|| cliente.getTelefono() == c.getTelefono()
//			) {
//				return true;
//			}
//		}
//		
		return false;
		
	}
	
	public ResultSet obtenerEmpleadoDelMes(int mes, int ano)
	{
		Statement statement;
		ResultSet resultSet;
		try {
			statement = conecction.createStatement();
			String query = "SELECT c.codigo_empleado_rep_ventas, count(distinct p.codigo_pedido), sum(dp.cantidad * dp.precio_unidad) as total FROM detalle_pedido dp" + 
					" inner join pedido p ON dp.codigo_pedido = p.codigo_pedido" + 
					" inner join cliente c ON c.codigo_cliente = p.codigo_cliente" + 
					" where month(p.fecha_pedido) = " + mes + " AND year(p.fecha_pedido) = " + ano + 
					" group by c.codigo_empleado_rep_ventas" + 
					" order by total DESC" + 
					" limit 1;";
			System.out.println("Query ejecutada: " + query);
			resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				return resultSet;
			}
		} catch (SQLException e) {
			System.out.println("**** DB Error (" + e.getErrorCode() + "): Fallo en la consulta ==> " + e.getMessage());
		}
		
		return null;
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


	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePedido> obtenerDetallesPedidos(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "FROM DetallePedido dp WHERE dp.pedido.cliente.codigoCliente = :cod_cliente";
		Query query = session.createQuery(hql);
		
		
		query.setParameter("cod_cliente", id);
				
		List<DetallePedido> resultsList = query.list();
		
		return resultsList;
	}
	
	public List<Pedido> obtenerPedidos(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "FROM Pedido WHERE cliente.codigoCliente = :cod_cliente";
		Query query = session.createQuery(hql);
				
		query.setParameter("cod_cliente", id);
				
		List<Pedido> resultsList = query.list();
		
		return resultsList;
	}	
	
}