package modelos;

import java.util.ArrayList;
import java.util.List;

import principal.BD;

public class ApadrinarClase {
	private int codigoPadrino;
	private int codigoNino;
	private boolean activo;
	private int cuota=0;
	
	public ApadrinarClase(int codigoPadrino, int codigoNino, boolean activo, int cuota) {
		this.codigoPadrino = codigoPadrino;
		this.codigoNino = codigoNino;
		this.activo = activo;
		this.cuota = cuota;
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
	
	public static List<ApadrinarClase> getApadrinamientos(){
		BD miBD = new BD();
		return miBD.getApadrinamientos();
	}
	public static int getPadrino(int nino)
	{
		List<Integer> lista = new ArrayList<Integer>();
		for(ApadrinarClase apa : getApadrinamientos()) {
			if(apa.getNino()==nino && apa.getEstado()) {
				return apa.getPadrino();
			}
		}
		return 0;
	}
	
	public static List<Integer> getApadrinados(int socio){
		List<Integer> lista = new ArrayList<Integer>();
		for(ApadrinarClase apa : getApadrinamientos()) {
			if(apa.getPadrino()==socio && apa.getEstado()) {
				lista.add(apa.getNino());
			}
		}
		return lista;	}


}
