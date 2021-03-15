package model;

import java.util.Set;

public class Cliente {

	private Integer codigoCliente;
	private Set<Pedido> pedidos;
	private String nombreCliente;
	private String nombreContacto;
	private String apellidoContacto;
	private String telefono;
	private String fax;
	private String lineaDireccion1;
	private String lineaDireccion2;
	private String ciudad;
	private String region;
	private String pais;
	private String codigoPostal;
	private Integer codigoEmpleadoRepVentas;
	private Float limiteCredito;
	

	public Cliente() {
		super();
	}
	
	public Cliente(Integer codigoCliente) {
		super();
		this.codigoCliente = codigoCliente;
	}

	public Cliente(Integer codigoCliente, String nombreCliente, String telefono, String fax, String ciudad, String lineaDireccion1) {
		super();
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.telefono = telefono;
		this.fax = fax;
		this.lineaDireccion1 = lineaDireccion1;
		this.ciudad = ciudad;
	}

	public Cliente(Integer codigoCliente, String nombreCliente, String nombreContacto, String apellidoContacto, String telefono,
			String fax, String lineaDireccion1, String lineaDireccion2, String ciudad, String region, String pais,
			String codigoPostal, Integer codigoEmpleadoRepVentas, Float limiteCredito) {
		super();
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.nombreContacto = nombreContacto;
		this.apellidoContacto = apellidoContacto;
		this.telefono = telefono;
		this.fax = fax;
		this.lineaDireccion1 = lineaDireccion1;
		this.lineaDireccion2 = lineaDireccion2;
		this.ciudad = ciudad;
		this.region = region;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
		this.codigoEmpleadoRepVentas = codigoEmpleadoRepVentas;
		this.limiteCredito = limiteCredito;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getApellidoContacto() {
		return apellidoContacto;
	}

	public void setApellidoContacto(String apellidoContacto) {
		this.apellidoContacto = apellidoContacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLineaDireccion1() {
		return lineaDireccion1;
	}

	public void setLineaDireccion1(String lineaDireccion1) {
		this.lineaDireccion1 = lineaDireccion1;
	}

	public String getLineaDireccion2() {
		return lineaDireccion2;
	}

	public void setLineaDireccion2(String lineaDireccion2) {
		this.lineaDireccion2 = lineaDireccion2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Integer getCodigoEmpleadoRepVentas() {
		return codigoEmpleadoRepVentas;
	}

	public void setCodigoEmpleadoRepVentas(Integer codigoEmpleadoRepVentas) {
		this.codigoEmpleadoRepVentas = codigoEmpleadoRepVentas;
	}

	public Float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}



	@Override
	public String toString() {
		return   "CODIGO CLIENTE: " +this.codigoCliente + " NOMBRE: " + this.nombreCliente + " NOMBRE CONTACTO: " + this.nombreContacto + " APELLIDO: " + this.apellidoContacto + " TELEFONO: " + this.telefono + " FAX: " + this.fax + " LINEA DIRECCION: " + this.lineaDireccion1 + " DIRECCION: " + this.lineaDireccion2 + " CIUDAD: " + this.ciudad + " REGION: " + this.region + " PAIS: " + this.pais + " CODIGO POSTAL: " + this.codigoPostal + " REP VENTAS: " + this.codigoEmpleadoRepVentas + " LIMITE CREDITO: " + this.limiteCredito;
	}

	
}