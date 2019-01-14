package modelos;

import principal.BD;

public class Economia {
	private int id;
	private double cantidad;
	private String moneda;
	private String descripcion;
	private GestionEconomica gestion;
	private String tipo;
	private String beneficiarioProcedencia;
	private String fecha;
	private Boolean aceptado;
	
	public Economia(int id, double cantidad, String moneda, String descripcion, GestionEconomica gestion, String tipo, String beneficiarioProcedencia, String fecha, Boolean aceptado)
	{
		this.id = id;
		this.cantidad = cantidad;
		this.moneda = moneda;
		this.descripcion = descripcion;
		this.gestion = gestion;
		this.tipo = tipo;
		this.fecha = fecha;
		this.beneficiarioProcedencia = beneficiarioProcedencia;
		this.aceptado = aceptado;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}



	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}



	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public void setGestion(GestionEconomica gestion) {
		this.gestion = gestion;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public void setBeneficiarioProcedencia(String beneficiarioProcedencia) {
		this.beneficiarioProcedencia = beneficiarioProcedencia;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public void setAceptado(Boolean aceptado) {
		this.aceptado = aceptado;
	}



	public String getAceptado() {
		return (aceptado) ? "Sí" : "No";
	}

	public String getBeneficiarioProcedencia()
	{
		return beneficiarioProcedencia;
	}
	
	public String getFecha()
	{
		return fecha;
	}
	
	public GestionEconomica getGestion() {
		return gestion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getMoneda() {
		return moneda;
	}
	
	public String getCantidad() {
		return Double.toString(cantidad);
	}
	
	public int getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
}
