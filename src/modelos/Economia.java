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
