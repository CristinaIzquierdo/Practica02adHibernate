package model;

import java.io.Serializable;

public class DetallePedido implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Pedido pedido;
	private Producto producto;
	
	int cantidad;
	double precioUnidad;
	int numeroLinea;
	
	public DetallePedido() {
		super();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(int numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "PEDIDO: " + pedido + " PRODUCTO: " + producto + " CANTIDAD: " + cantidad
				+ " PRECIO UNIDAD: " + precioUnidad + " NUMERO LINEA: " + numeroLinea;
	}
	
	public String imprimirAbreviado() {
		return "PEDIDO: " + pedido.getCodigoPedido() + " FECHA PEDIDO: " + pedido.getFechaPedido().toString() + " CODIGO: " + producto.getCodigoProducto() + " CANTIDAD: " + cantidad
				+ " NOMBRE: " + producto.getNombre() + " GAMA: " + producto.getGama() + " DESCRIPCION: " + producto.getDescripcion() + " PRECIO UNIDAD: " + precioUnidad + " NUMERO LINEA: " + numeroLinea;
	}
}
