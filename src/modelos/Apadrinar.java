package modelos;

import java.util.ArrayList;
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
	public static List<Integer> getPadrinos(int nino)
	{
		List<Integer> lista = new ArrayList<Integer>();
		for(Apadrinar apa : getApadrinamientos()) {
			if(apa.getNino()==nino && apa.getEstado()) {
				lista.add(apa.getPadrino());
			}
		}
		return lista;
	}
	
	public static List<Integer> getApadrinados(int socio){
		List<Integer> lista = new ArrayList<Integer>();
		for(Apadrinar apa : getApadrinamientos()) {
			if(apa.getPadrino()==socio && apa.getEstado()) {
				lista.add(apa.getNino());
			}
		}
		return lista;	}


}
