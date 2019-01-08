package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.ApadrinarModelo;
import modelos.LoginModelo;
import vistas.ApadrinarVista;
import vistas.LoginVista;

public class ApadrinarControlador implements ActionListener {
	
	private ApadrinarVista vistaApadrinar;
	private ApadrinarModelo modelo;
	// Como hay que confirmar si ya se ha seleccionado antes apadrinar o desapadrinar
	// he decidido guardar en la variable state el evento que ha sido pulsado antes
	// otra opción es que si se ha pulsado por ejemplo el botón apadrinar se deshabilite el botón desapadrinar
	// o se cambie a denegar apadrinamiento por ejemplo
	private String state;
	
	public ApadrinarControlador(ApadrinarVista vista, ApadrinarModelo modelo) {
		this.vistaApadrinar = vista;
		this.modelo = modelo;
	}
	
	public void iniciarVista() {
		//cargar todos los socios y niños
		vistaApadrinar.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		switch(evento) {
			case "APADRINAR" :;
			break;
			case "DESAPADRINAR" :;
			break;
			case "FILTRARNINO" :;
			break;
			case "FILTRARSOCIO" :;
			break;
			case "ATRAS" :;
			break;
			default :;
			break;
		}
	}

}
