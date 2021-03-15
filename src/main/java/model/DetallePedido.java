package model;

import java.io.Serializable;

public class DetallePedido implements Serializable {

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
		return "DetallePedido [pedido=" + pedido + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precioUnidad=" + precioUnidad + ", numeroLinea=" + numeroLinea + "]";
	}
	
	public String imprimirAbreviado() {
		return "DetallePedido [codigo_pedido=" + pedido.getCodigoPedido() + ", fecha_pedido=" + pedido.getFechaPedido().toString() + ", codigo_producto=" + producto.getCodigoProducto() + ", cantidad=" + cantidad
				+ ", nombreProducto=" + producto.getNombre() + ", gamaProduto=" + producto.getGama() + ", descripciónProducto=" + producto.getDescripcion() + ", precioUnidad=" + precioUnidad + ", numeroLinea=" + numeroLinea + "]";
	}
}
