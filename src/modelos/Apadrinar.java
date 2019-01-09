package modelos;

import java.util.List;

import principal.BD;

public class Apadrinar {
	private int codigoPadrino;
	private int codigoNino;
	private boolean activo;
	
	public Apadrinar(int codigoPadrino, int codigoNino, boolean activo) {
		this.codigoPadrino = codigoPadrino;
		this.codigoNino = codigoNino;
		this.activo = activo;
	}
	
	public boolean getEstado() {
		return activo;
	}
	
	public int getPadrino() {
		return codigoPadrino;
	}
	
	public int getNino() {
		return codigoNino;
	}
	
	public void borrar() {
		activo = false;
	}
	
	public void activar() {
		activo = true;
	}
	
	public static List<Apadrinar> getApadrinamientos(){
		BD miBD = new BD();
		return miBD.getApadrinamientos();
	}


}
