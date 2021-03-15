package com.AD_Practica1.Practica1_AD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDaoImplementacion;
import dao.ProductoDaoImplementacion;
import exceptions.ClientNotFound;
import exceptions.DuplicateException;
import model.Cliente;
import model.DetallePedido;
import model.Producto;


public class App 
{
	private static Scanner sc = new Scanner(System.in);
	private static ClienteDaoImplementacion cDao = new ClienteDaoImplementacion();
	private static ProductoDaoImplementacion pDao = new ProductoDaoImplementacion();
    
	public static void main( String[] args )
    {
    	int opcion = 0;
		
    	do {
    		try {
    			opcion = getOpcionDeMenu();
    			ejecutarOpcion(opcion);
			} catch (Exception e) {
				opcion = 0;
				System.out.println("********* Error: " + e.getMessage());
				System.out.println("Introduce un número por favor. Saliendo...");
			}
    	} while (opcion != 0);
        
    	sc.close();
    	cDao.cerrarConexion();
    	pDao.cerrarConexion();
    
    }

	private static void ejecutarOpcion(int opcion) {
		Cliente c = null;
		List<Cliente> clientes = new ArrayList<>();
		@SuppressWarnings("unused")
		String input, input2;
		
		switch (opcion) {
		case 1:
			c = pedirDatosCliente();
			 try {
				if (cDao.anadeCliente(c)) {
					 System.out.println("*************** El cliente: '" + c.getNombreCliente() + "' se ha insertado en la base de datos. ***************");
				 }
			} catch (DuplicateException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			System.out.print("Codigo de cliente: "); String codigoCliente = sc.nextLine();
			try {
				c = cDao.MostrarCliente(Integer.parseInt(codigoCliente));
				System.out.println("Los datos del cliente (" + codigoCliente + ") son los siguientes:");
				System.out.println(c);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ClientNotFound e) {
				System.out.println(e.getMessage());
			}

			break;
		case 3:
			clientes = cDao.findAllClients();
			for (Cliente cliente : clientes) {
				System.out.println(cliente);
			}
			break;
		case 4:
			System.out.print("Buscar por cadena: "); String cadenaTexto = sc.nextLine();
			clientes = cDao.buscarPorTexto(cadenaTexto);
			
			if (clientes.size() > 0) {
				
				System.out.println("Hay estas coincidencias con " + cadenaTexto + " :");
				for (Cliente cliente : clientes) {
					System.out.println(cliente);
				}
			} else {
				System.out.println("No se encuentran coincidencias con " + cadenaTexto );
			}

			break;
		case 5:
			System.out.print("Introduce codigo producto a modificar: "); String codigoProducto = sc.nextLine();
			Producto p = pDao.MostrarProducto(Integer.parseInt(codigoProducto));
			if (p != null) {
				System.out.println("Los datos del producto (" + codigoProducto + ") son los siguientes:");
				System.out.println(p);
			} else {
				System.out.println("El producto con id (" + codigoProducto + ") no existe");
			}
			Producto productoAModificar = pedirDatosProducto(p);
			pDao.editaProducto(p, productoAModificar);
			
			break;
		case 6:
			System.out.print("Introduce codigo de cliente: "); input = sc.nextLine();

			List<DetallePedido> detallesPedido = cDao.obtenerDetallesPedidos(Integer.parseInt(input));
			double suma = 0;
			for (DetallePedido detalle: detallesPedido) {
				System.out.println(detalle.imprimirAbreviado());
				suma += detalle.getPrecioUnidad() * detalle.getPrecioUnidad();
			}

			System.out.println("Suma total de gasto es: " + suma);

			break;
		case 7:
			System.out.print("Introduce el mes que quieres saber: "); input = sc.nextLine();
			System.out.print("Introduce el año que quieres saber: "); input2 = sc.nextLine();
			System.out.println();
			
			try {
				ResultSet rs = cDao.obtenerEmpleadoDelMes(Integer.parseInt(input), Integer.parseInt(input2));
				if (rs != null) {
					System.out.println("ID Empleado del Mes: " + rs.getInt(1) + " Total Pedidos: " + rs.getInt(2) + ", Cantidad vendida = " + rs.getDouble("total"));
				} else {
					System.out.println("No hay pedidos este mes");
				}
			} catch (NumberFormatException | SQLException e) {
				System.out.println("********* Error: " + e.getMessage());
			}

			break;
		default:
			break;
		}
		
	}

	private static Cliente pedirDatosCliente() {
		System.out.print("Codigo de cliente: "); String codigoCliente = sc.nextLine();
		System.out.print("Nombre del cliente: "); String nombreCliente = sc.nextLine();
		System.out.print("Teléfono: "); String telefonoCliente = sc.nextLine();
		System.out.print("Fax: "); String faxCliente = sc.nextLine();
		System.out.print("Ciudad: "); String ciudadCliente = sc.nextLine();
		System.out.print("Direccion 1: "); String direccion1Cliente = sc.nextLine();
	
		// Hacer comprobaciones de que los datos recogidos están bien
		return new Cliente(Integer.parseInt(codigoCliente), nombreCliente, telefonoCliente, faxCliente, ciudadCliente, direccion1Cliente);
	}
	
	
	private static Producto pedirDatosProducto(Producto p) throws NumberFormatException{
 		
		System.out.print("Nombre del producto: "); String nombreProducto = sc.nextLine();
		System.out.print("Gama: "); String gama = sc.nextLine();
		System.out.print("Dimensiones: "); String dimensiones = sc.nextLine();
		System.out.print("Proveedor: "); String proveedor = sc.nextLine();
		System.out.print("Descripcion: "); String descripcion = sc.nextLine();
		System.out.print("Cantidad Stock: "); String cantidadStock = sc.nextLine();
		System.out.print("Precio venta: "); String precioVenta = sc.nextLine();
		System.out.print("Precio proveedor: "); String precioProveedor = sc.nextLine();
		
		if (!nombreProducto.contentEquals("")) { p.setNombre(nombreProducto);}
		if (!gama.contentEquals("")) { p.setGama(gama);}
		if (!dimensiones.contentEquals("")) { p.setDimensiones(dimensiones);}
		if (!proveedor.contentEquals("")) { p.setProveedor(proveedor);}
		if (!descripcion.contentEquals("")) { p.setDescripcion(descripcion);}
		if (!cantidadStock.contentEquals("")) { p.setCantidadStock(Integer.parseInt(cantidadStock));}
		if (!precioVenta.contentEquals("")) { p.setPrecioVenta(Double.parseDouble(precioVenta));}
		if (!precioProveedor.contentEquals("")) { p.setPrecioProveedor(Double.parseDouble(precioProveedor));}
	
		// Hacer comprobaciones de que los datos recogidos están bien
		return p;
	}

	private static int getOpcionDeMenu() {
		System.out.println("");
		System.out.println("******************************");
		System.out.println("------------ Menú principal ------------");
		System.out.println("******************************");
		System.out.println( "1.- Añade un cliente" );
		System.out.println( "2.- Muestra un cliente por id" );
		System.out.println( "3.- Muestra todos los clientes" );
		System.out.println( "4.- Busca cliente por nombre" );
		System.out.println( "5.- Edita producto" );
		System.out.println( "6.- Mostrar pedidos de un cliente por ID" );
		System.out.println( "7.- Mostrar empleado del mes" );
		System.out.print( "Selecciona una opcion (0 para salir): " );
		
		String s = sc.nextLine();

		return Integer.parseInt(s);
	}
}
