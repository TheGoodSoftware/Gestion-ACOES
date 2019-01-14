package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	public ApadrinarVista vistaApadrinar;
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
		if(vistaApadrinar.getBotonSeleccionado().equals("MOSTRARSOCIOS")) {
			BD miBD = new BD();
			Usuario persona = miBD.getSocio(vistaApadrinar.getSeleccionado()); // Arreglar esto
			apadrinarPopUpVista.setLista(modelo.getNinos());
			apadrinarPopUpVista.setUsuario(persona.getID()+" "+persona.getNombreCompleto(), vistaApadrinar.getBotonSeleccionado().substring(7, vistaApadrinar.getBotonSeleccionado().length()));
			apadrinarPopUpVista.controlador(apadrinarPopUpControlador);
			apadrinarPopUpVista.setVisible(true);
		} else {
			BD miBD = new BD();
			Nino persona = miBD.getNino(vistaApadrinar.getSeleccionado()); // Arreglar esto
			apadrinarPopUpVista.setLista(modelo.getSocios());
			apadrinarPopUpVista.setUsuario(persona.getID()+" "+persona.getNombreCompleto(), vistaApadrinar.getBotonSeleccionado().substring(7, vistaApadrinar.getBotonSeleccionado().length()));
			apadrinarPopUpVista.controlador(apadrinarPopUpControlador);
			apadrinarPopUpVista.setVisible(true);
		}

		
	}
	
	public void desapadrinar() {
		try {
		ApadrinarPopUpVista apadrinarPopUpVista = new ApadrinarPopUpVista();
		ApadrinarPopUpControlador apadrinarPopUpControlador = new ApadrinarPopUpControlador(apadrinarPopUpVista, modelo, vistaApadrinar);
		apadrinarPopUpVista.setApadrinarDesapadrinar("Despadrinar");
		if(vistaApadrinar.getBotonSeleccionado().equals("MOSTRARSOCIOS")) {
			BD miBD = new BD();
			Usuario persona;
			persona = miBD.getSocio(vistaApadrinar.getSeleccionado());
			List<String> lista = modelo.getApadrinadosLista(vistaApadrinar.getSeleccionado());
			apadrinarPopUpVista.setLista(lista.toArray(new String[lista.size()]));
			apadrinarPopUpVista.setUsuario(persona.getID()+" "+persona.getNombreCompleto(), vistaApadrinar.getBotonSeleccionado().substring(7, vistaApadrinar.getBotonSeleccionado().length()));
			apadrinarPopUpVista.controlador(apadrinarPopUpControlador);
			apadrinarPopUpVista.setVisible(true);
		} else {
			BD miBD = new BD();
			Nino persona = miBD.getNino(vistaApadrinar.getSeleccionado()); // Arreglar esto
			Usuario u = miBD.getSocio(modelo.getPadrino(vistaApadrinar.getSeleccionado()));
			String[] lista = new String[1];
			if(u != null) {
				lista[0] = u.getID()+" "+ u.getNombreCompleto();
			} else {
				lista[0] = null;
			}
			
			apadrinarPopUpVista.setLista(lista);
			apadrinarPopUpVista.setUsuario(persona.getID()+" "+persona.getNombreCompleto(), vistaApadrinar.getBotonSeleccionado().substring(7, vistaApadrinar.getBotonSeleccionado().length()));
			apadrinarPopUpVista.controlador(apadrinarPopUpControlador);
			apadrinarPopUpVista.setVisible(true);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Arreglar esto
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
		if(u != null) {
			padrino.setParametros(u.getNombre(), u.getApellidos(), u.getE_mail(), u.getAsociacion());
		} else {
			padrino.setParametros("", "", "", "");
		}
		padrino.setVisible(true);
	}

	public String[] mostrarApadrinados() throws SQLException {
		
		MostrarPersonasVista apadrinadosVista = new MostrarPersonasVista();
		List<String> apadrinadosLista = modelo.getApadrinadosLista(vistaApadrinar.getSeleccionado());
		apadrinadosVista.setList(apadrinadosLista.toArray(new String[apadrinadosLista.size()]));
		apadrinadosVista.setVisible(true);
		return apadrinadosLista.toArray(new String[apadrinadosLista.size()]);
	}


}
