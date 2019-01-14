package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelos.ApadrinarClase;
import modelos.ApadrinarModelo;
import modelos.LoginModelo;
import modelos.Nino;
import modelos.Usuario;
import principal.BD;
import vistas.AdminVista;
import vistas.ApadrinarPopUpVista;
import vistas.ApadrinarVista;
import vistas.CrearSocioVista;
import vistas.LoginVista;
import vistas.MostrarPersonasVista;
import vistas.MostrarSocioVista;

public class ApadrinarControlador implements ActionListener {
	
	private ApadrinarVista vistaApadrinar;
	private ApadrinarModelo modelo;
	private Usuario usuario;
	private Boolean clickado=false;
	
	public ApadrinarControlador(ApadrinarVista vista, ApadrinarModelo modelo, Usuario usuario) {
		this.vistaApadrinar = vista;
		this.modelo = modelo;
		this.usuario = usuario;
	}
	
	public void iniciarVista() {
		//cargar todos los socios y niños
		vistaApadrinar.setVisible(true);
		mostrarSocios();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 try {
		String evento = e.getActionCommand();
		switch(evento) {
			case "APADRINAR" : apadrinar();
			break;
			case "DESAPADRINAR" : desapadrinar();
			break;
			case "MOSTRARNINOS" : mostrarNinos();
			break;
			case "MOSTRARSOCIOS" : mostrarSocios();
			break;
			case "MOSTRAR" :
				mostrar();
			
			break;
			case "FILTRAR" : filtrar();
			break;
			default :;
			break;
		}
		 } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	

	public void mostrarSocios() {
		vistaApadrinar.actualizarLista(modelo.getSocios(this.usuario.getAsociacion()));
	}

	public void mostrarNinos() {
		vistaApadrinar.actualizarLista(modelo.getNinos());
	}

	public void apadrinar() throws SQLException {
		ApadrinarPopUpVista apadrinarPopUpVista = new ApadrinarPopUpVista();
		ApadrinarPopUpControlador apadrinarPopUpControlador = new ApadrinarPopUpControlador(apadrinarPopUpVista, modelo, vistaApadrinar);
		apadrinarPopUpVista.setApadrinarDesapadrinar("Apadrinar");
		BD miBD = new BD();
		Usuario u = miBD.getSocio(vistaApadrinar.getSeleccionado()); // Arreglar esto
		apadrinarPopUpVista.setLista(modelo.getNinos());
		apadrinarPopUpVista.setUsuario(u.getID()+" "+u.getNombreCompleto(), vistaApadrinar.getBotonSeleccionado().substring(7, vistaApadrinar.getBotonSeleccionado().length()));
		apadrinarPopUpVista.controlador(apadrinarPopUpControlador);
		apadrinarPopUpVista.setVisible(true);
		
	}
	
	public void desapadrinar() {

	}
	
	public void filtrar() {
		if(vistaApadrinar.getBotonSeleccionado().equals("MOSTRARSOCIOS")) {
			vistaApadrinar.actualizarLista(modelo.filtrarSocios(vistaApadrinar.getFiltro()));
		} else {
			vistaApadrinar.actualizarLista(modelo.filtrarNinos(vistaApadrinar.getFiltro()));
		}
	}
	
	public void mostrar() throws SQLException {
		// TODO Auto-generated method stub
		if(vistaApadrinar.getBotonSeleccionado().equals("MOSTRARSOCIOS")) {
			mostrarApadrinados();
		} else {
			mostrarPadrino();
		}
	}
	
	public void mostrarPadrino() throws SQLException {
		BD miBD = new BD();
		MostrarSocioVista padrino = new MostrarSocioVista();
		int usuario = modelo.getPadrino(vistaApadrinar.getSeleccionado());
		Usuario u = miBD.getSocio(usuario);
		padrino.setParametros(u.getNombre(), u.getApellidos(), u.getE_mail(), u.getAsociacion());
		padrino.setVisible(true);
	}

	public void mostrarApadrinados() throws SQLException {
		BD miBD = new BD();
		MostrarPersonasVista apadrinadosVista = new MostrarPersonasVista();
		Usuario u = miBD.getSocio(vistaApadrinar.getSeleccionado());
		List<ApadrinarClase> apadrinamientos = miBD.getApadrinamientosPadrino(u.getID());
		List<String> apadrinadosLista = new ArrayList<String>();
		for(ApadrinarClase apadrinar : apadrinamientos) {
			
				Nino n = miBD.getNino(apadrinar.getNino());
				apadrinadosLista.add(n.getID()+" "+n.getNombreCompleto());
				//apadrinadosLista.add(Integer.toString(apadrinar.getNino()));
		
		}
		apadrinadosVista.setList(apadrinadosLista.toArray(new String[apadrinadosLista.size()]));
		apadrinadosVista.setVisible(true);
	}


}
