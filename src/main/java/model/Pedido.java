package model;

import java.util.Date;
import java.util.Set;

public class Pedido {

	private int codigoPedido;
	private Cliente cliente;
	private Date fechaPedido;
	
	private Set<DetallePedido> detallesPedido;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido() {
		super();
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	@Override
	public String toString() {
		return "Pedido [codigoPedido=" + codigoPedido + ", cliente=" + cliente + "]";
	}

	public Set<DetallePedido> getDetallesPedido() {
		return detallesPedido;
	}

	public void setDetallesPedido(Set<DetallePedido> detallesPedido) {
		this.detallesPedido = detallesPedido;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	
}
