package modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		BD miBD = new BD();
		List<Apadrinar> apadrinamientos = miBD.getApadrinamientos();
		boolean encontrado = false;
		boolean realizado = false;
		for(Apadrinar apa: apadrinamientos) {
			if(apa.getNino()==ninoID && apa.getPadrino()==socioID) {
				encontrado = true;
				if(apa.getEstado()==false) {
					realizado = true;
					miBD.activarApadrinamiento(apa.getPadrino(), apa.getNino());
					apa.activar();
				}
			}
		}
		if(!encontrado) {
			try {
				miBD.insertarApadrinamiento(socioID, ninoID);
			} catch (SQLException e) {
				return false;
			}
		}else if(encontrado && !realizado) {
			return false;
		}
		return true;
	}
	// Devuelve true si la operación se ha realizado con éxito
	public boolean Desapadrinar(int socioID, int ninoID) {
		BD miBD = new BD();
		List<Apadrinar> apadrinamientos = miBD.getApadrinamientos();
		boolean realizado = false;
		for(Apadrinar apa: apadrinamientos) {
			if(apa.getNino()==ninoID && apa.getPadrino()==socioID) {
				if(apa.getEstado()==true) {
					realizado = true;
					try {
						miBD.borrarApadrinamiento(socioID, ninoID);
						apa.borrar();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						realizado = false;
					}
					
				}
			}
		}
		return realizado;
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
		return socios.toArray(new String[socios.size()]);
	}
	public static String[] getNinos() {
		try {
			ArrayList<String> ninos = new ArrayList<String>();
			BD miBD = new BD();
			List<Nino> arr;
			arr = miBD.getAllNinos();
			StringBuilder sb = new StringBuilder();
			for(Nino us : arr) {

				sb.append(us.getID());
				sb.append(" ");
				sb.append(us.getNombreCompleto());
				ninos.add(sb.toString());
				sb = new StringBuilder();
			}
			return ninos.toArray(new String[ninos.size()]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String[] getApadrinados(int socioSeleccionado) {
		List<Integer> apadrinados = Apadrinar.getApadrinados(socioSeleccionado);
		List<String> resultado = new ArrayList<String>();
		BD miBD = new BD();
		StringBuilder sb = new StringBuilder();
		for(Integer apadrinado : apadrinados) {
			//chapucilla, arreglar
			boolean encontrado = false;
			int contador=0;
			String cadena = "";
				while(!encontrado) {
					if(ninos[contador].contains(apadrinado.toString())) {
						cadena = ninos[contador];
						encontrado = true;
					}
					contador++;
				}
		/*		Nino u = miBD.getNino(apadrinado);
				sb.append(apadrinado);
				sb.append(" ");
				sb.append(u.getNombreCompleto());
				*/
				sb.append(cadena);
				resultado.add(sb.toString());
				sb = new StringBuilder();
		}

		return resultado.toArray(new String[resultado.size()]);
	}

	public String[] getPadrinos(int ninoSeleccionado) {
		List<Integer> padrinos = Apadrinar.getPadrinos(ninoSeleccionado);
		List<String> resultado = new ArrayList<String>();
		BD miBD = new BD();
		StringBuilder sb = new StringBuilder();
		try {
		for(Integer padrino : padrinos) {
			
				Usuario u = miBD.getSocio(padrino);
				sb.append(padrino);
				sb.append(" ");
				sb.append(u.getNombreCompleto());
				resultado.add(sb.toString());
				sb = new StringBuilder();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado.toArray(new String[resultado.size()]);
		
	}
}
