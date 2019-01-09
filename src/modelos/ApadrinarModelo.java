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
		return true;
	}
	// Devuelve true si la operación se ha realizado con éxito
	public boolean Desapadrinar(int socioID, int ninoID) {
		//TODO
		return true;
	}
	
	public String[] filtrarSocios(String nombre) {
		ArrayList<String> filtroSocios = new ArrayList();
		for(String cadena : socios) {
			if(cadena.contains(nombre)) {
				filtroSocios.add(cadena);
			}
		}
		return filtroSocios.toArray(new String[filtroSocios.size()]);
	}
	
	public String[] filtrarNinos(String nombre) {
		ArrayList<String> filtroNinos = new ArrayList();
		for(String cadena : ninos) {
			if(cadena.contains(nombre)) {
				filtroNinos.add(cadena);
			}
		}
		return filtroNinos.toArray(new String[filtroNinos.size()]);
	}
	
	public static String[] getSocios() {
		ArrayList<String> socios = new ArrayList<String>();
		BD miBD = new BD();
		ArrayList<Usuario> arr = miBD.getAllUsuarios();
		StringBuilder sb = new StringBuilder();
		for(Usuario us : arr) {

			sb.append(us.getID());
			sb.append(" ");
			sb.append(us.getNombreCompleto());
			socios.add(sb.toString());
			sb = new StringBuilder();
		}
		System.out.println(socios.toString());
		return socios.toArray(new String[socios.size()]);
	}
	public static String[] getNinos() {
		ArrayList<String> ninos = new ArrayList<String>();
		BD miBD = new BD();
		ArrayList<Nino> arr = miBD.getAllNinos();
		StringBuilder sb = new StringBuilder();
		for(Nino us : arr) {

			sb.append(us.getID());
			sb.append(" ");
			sb.append(us.getNombreCompleto());
			ninos.add(sb.toString());
			sb = new StringBuilder();
		}
		System.out.println(ninos.toString());
		return ninos.toArray(new String[ninos.size()]);
	}
}
