package modelos;

public class Economia {
	private int id;
	private double cantidad;
	private String moneda;
	private String descripcion;
	private Usuario usuario;
	private GestionEconomica gestion;
	private String tipo;
	
	public Economia(int id, double cantidad, String moneda, String descripcion, Usuario usuario, GestionEconomica gestion, String tipo)
	{
		this.id = id;
		this.cantidad = cantidad;
		this.moneda = moneda;
		this.descripcion = descripcion;
		this.gestion = gestion;
		this.usuario = usuario;
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
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
	
	public double getCantidad() {
		return cantidad;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
}
