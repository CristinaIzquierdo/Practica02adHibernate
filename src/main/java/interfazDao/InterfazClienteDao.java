package interfazDao;

import java.util.List;

import exceptions.ClientNotFound;
import exceptions.DuplicateException;
import model.Cliente;
import model.DetallePedido;

public interface InterfazClienteDao {
	
	public boolean anadeCliente(Cliente c) throws DuplicateException;
	public Cliente MostrarCliente(int id) throws ClientNotFound;
	public List<Cliente> findAllClients();
	public List<Cliente> buscarPorTexto(String texto);
	public void actualizar(Cliente cliente, String[] params);
	public void eliminar(Cliente cliente);
	public List<DetallePedido> obtenerDetallesPedidos(int id);
}
