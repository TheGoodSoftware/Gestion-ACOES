package modelos;

import java.sql.SQLException;
import java.util.ArrayList;

import principal.BD;

public class ApadrinarModelo {
	private String[] socios;
	private String[] ninos;
	
	public ApadrinarModelo() {
		socios = this.getSocios();
		ninos = this.getNinos();
	}

	//Devuelve true si la operación se ha realizado con éxito
	public boolean Apadrinar(int socioID, int ninoID) {
		//TODO
		try {
			BD miBD = new BD();
			miBD.getSocio(socioID);
			miBD.getNino(ninoID);
		} catch (SQLException e) {
			return false;
		}
		return false;
	}
	// Devuelve true si la operación se ha realizado con éxito
	public boolean Desapadrinar(int socioID, int ninoID) {
		//TODO
		return false;
	}
	
	public String[] filtrarSocios(String nombre) {
		//TODO
		return socios;
	}
	
	public String[] filtrarNinos(String nombre) {
		//TODO
		return ninos;
	}
	
	public static String[] getSocios() {
		ArrayList<String> socios = new ArrayList<String>();
		//TODO
		return (String[]) socios.toArray();
	}
	public static String[] getNinos() {
		ArrayList<String> ninos = new ArrayList<String>();
		//TODO
		return (String[]) ninos.toArray();
	}
}
