package modelos;

public class Paquete {
	private int numSeg;
	private String fechaEnvio;
	private String fechaRecepcion;
	private Boolean confirmado;
	private Usuario padrino;
	private Nino nino;
	private String descripcion;
	
	public Paquete(int numSeg, String fechaEnvio, String fechaRecepcion, Boolean confirmado, Usuario padrino, Nino nino, String descripcion) {
		this.fechaEnvio = fechaEnvio;
		this.fechaRecepcion = fechaRecepcion;
		this.confirmado = confirmado;
		this.padrino = padrino;
		this.nino = nino;
		this.descripcion = descripcion;
	}
	public Paquete(int numSeg,String fechaEnvio, Usuario padrino, Nino nino, String des) {
		new Paquete(numSeg, fechaEnvio, "", false, padrino, nino, des);
	}
	
	public String getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public String getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public Boolean getConfirmado() {
		return confirmado;
	}
	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}
	public Usuario getPadrino() {
		return padrino;
	}
	public void setPadrino(Usuario padrino) {
		this.padrino = padrino;
	}
	public Nino getNino() {
		return nino;
	}
	public void setNino(Nino nino) {
		this.nino = nino;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Paquete [fechaEnvio=" + fechaEnvio + ", fechaRecepcion=" + fechaRecepcion + ", confirmado=" + confirmado
				+ ", padrino=" + padrino + ", nino=" + nino + ", descripcion=" + descripcion + "]";
	}
	
	
}
