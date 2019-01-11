package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.Apadrinar;
import modelos.LoginModelo;
import modelos.Usuario;
import vistas.AdminVista;
import vistas.ApadrinarVista;
import vistas.LoginVista;

public class ApadrinarControlador implements ActionListener {
	
	private ApadrinarVista vistaApadrinar;
	private Apadrinar modelo;
	private Usuario usuario;
	// Como hay que confirmar si ya se ha seleccionado antes apadrinar o desapadrinar
	// he decidido guardar en la variable state el evento que ha sido pulsado antes
	// otra opción es que si se ha pulsado por ejemplo el botón apadrinar se deshabilite el botón desapadrinar
	// o se cambie a denegar apadrinamiento por ejemplo
	private Boolean clickado=false;
	
	public ApadrinarControlador(ApadrinarVista vista, Apadrinar modelo, Usuario usuario) {
		this.vistaApadrinar = vista;
		this.modelo = modelo;
		this.usuario = usuario;
	}
	
	public void iniciarVista() {
		//cargar todos los socios y niños
		vistaApadrinar.setVisible(true);
		//vistaApadrinar.actualizarSocio(modelo.getSocios());
		//vistaApadrinar.actualizarNino(modelo.getNinos());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		String evento = e.getActionCommand();
		switch(evento) {
			case "APADRINAR" : apadrinar();
			break;
			case "DESAPADRINAR" : desapadrinar();
			break;
			case "FILTRARNINO" : filtrarNino();
			break;
			case "FILTRARSOCIO" : filtrarSocio();
			break;
			case "ATRAS" : atras();
			break;
			case "MOSTRARAPADRINADOS" : mostrarApadrinados();
			break;
			case "MOSTRARPADRINOS" : mostrarPadrinos();
			break;
			default :;
			break;
		}
	}
	

	public void apadrinar() {
		if(clickado) {
			boolean exito = modelo.Apadrinar(vistaApadrinar.getSocioSeleccionado(), vistaApadrinar.getNinoSeleccionado());
			clickado = false;
			if(exito) {
				vistaApadrinar.setMensajeExito("Se apadrino con exito");
			} else {
				vistaApadrinar.setMensajeError("No se pudo apadrinar correctamente");
			};
			vistaApadrinar.habilitarCamposTexto();
			vistaApadrinar.habilitarApadrinar();
			vistaApadrinar.habilitarDesapadrinar();
			vistaApadrinar.actualizarBotonDesapadrinar("Desapadrinar");
			vistaApadrinar.actualizarBotonApadrinar("Apadrinar");
			vistaApadrinar.actualizarSocio(modelo.getSocios());
			vistaApadrinar.actualizarNino(modelo.getNinos());
			vistaApadrinar.habilitarMostrar();
			clickado = false;
		} else {
			vistaApadrinar.actualizarBotonApadrinar("Confirmar apadrinamiento");
			vistaApadrinar.deshabilitarDesapadrinar();
			vistaApadrinar.deshabilitarCamposTexto();
			vistaApadrinar.deshabilitarMostrar();
			clickado = true;
		}
	}
	
	public void desapadrinar() {
		if(clickado) {
			boolean exito = modelo.Desapadrinar(vistaApadrinar.getSocioSeleccionado(), vistaApadrinar.getNinoSeleccionado());
			clickado = false;
			if(exito) {
				vistaApadrinar.setMensajeExito("Se desapadrino con exito");
			} else {
				vistaApadrinar.setMensajeError("No se pudo desapadrinar correctamente");
			};
			vistaApadrinar.habilitarCamposTexto();
			vistaApadrinar.habilitarApadrinar();
			vistaApadrinar.habilitarDesapadrinar();
			vistaApadrinar.actualizarBotonDesapadrinar("Desapadrinar");
			vistaApadrinar.actualizarBotonApadrinar("Apadrinar");
			vistaApadrinar.actualizarSocio(modelo.getSocios());
			vistaApadrinar.actualizarNino(modelo.getNinos());
			vistaApadrinar.habilitarMostrar();

		} else {
			vistaApadrinar.actualizarBotonDesapadrinar("Confirmar desapadrinamiento");
			vistaApadrinar.deshabilitarApadrinar();
			vistaApadrinar.deshabilitarCamposTexto();
			vistaApadrinar.deshabilitarMostrar();
			clickado = true;
		}
	}
	
	public void filtrarNino() {
		vistaApadrinar.actualizarNino(modelo.filtrarNinos(vistaApadrinar.getFiltroNino()));;
	}
	
	public void filtrarSocio() {
		vistaApadrinar.actualizarSocio(modelo.filtrarSocios(vistaApadrinar.getFiltroSocio()));
	}
	
	public void atras() {
		if(clickado) {
			vistaApadrinar.habilitarCamposTexto();
			vistaApadrinar.habilitarApadrinar();
			vistaApadrinar.habilitarDesapadrinar();
			vistaApadrinar.actualizarBotonDesapadrinar("Desapadrinar");
			vistaApadrinar.actualizarBotonApadrinar("Apadrinar");
			vistaApadrinar.actualizarSocio(modelo.getSocios());
			vistaApadrinar.actualizarNino(modelo.getNinos());
			vistaApadrinar.habilitarMostrar();
			clickado = false;
		} else {
			AdminVista admVista = new AdminVista();
			AdminControlador ctr = new AdminControlador(this.usuario);
			admVista.controlador(ctr);
			ctr.iniciarVista();
			vistaApadrinar.setVisible(false);	
		}
	}
	
	public void mostrarPadrinos() {
		vistaApadrinar.deshabilitarApadrinar();
		vistaApadrinar.deshabilitarCamposTexto();
		vistaApadrinar.deshabilitarDesapadrinar();
		vistaApadrinar.deshabilitarMostrar();
		clickado = true;
		vistaApadrinar.actualizarSocio(modelo.getPadrinos(vistaApadrinar.getNinoSeleccionado()));
		
	}

	public void mostrarApadrinados() {
		vistaApadrinar.deshabilitarApadrinar();
		vistaApadrinar.deshabilitarCamposTexto();
		vistaApadrinar.deshabilitarDesapadrinar();
		vistaApadrinar.deshabilitarMostrar();
		clickado = true;
		vistaApadrinar.actualizarNino(modelo.getApadrinados(vistaApadrinar.getSocioSeleccionado()));
*/	}


}
