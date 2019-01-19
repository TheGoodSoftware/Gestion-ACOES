package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.MensajeriaModelo;
import vistas.ApadrinarVista;
import vistas.MensajeriaVista;

public class MensajeriaControlador implements ActionListener {
	
	private MensajeriaVista vista;
	private MensajeriaModelo modelo;
	private ApadrinarVista vistaApadrinar;
	
	public MensajeriaControlador(MensajeriaVista vista, MensajeriaModelo modelo, ApadrinarVista vistaApadrinar) {
		this.vista = vista;
		this.modelo = modelo;
		this.vistaApadrinar = vistaApadrinar;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String evento = event.getActionCommand();
		switch(evento) {
		case "ENVIO": envio();
			break;
		case "RECEPCION": recepcion();
			break;
		}
	}

	private void recepcion() {
		boolean exito =modelo.recepcion(vista.getNumSeg(),vista.getFecha());
		if(exito) {
			vistaApadrinar.setMensajeExito("Recepcion confirmada con exito");
		} else {
			vistaApadrinar.setMensajeError("Recepcion no confirmada, el mensaje no existia");
		}
	}

	private void envio() {
		boolean exito =modelo.envio(vista.getNumSeg(),vista.getFecha(), vista.getIDUsuario(), vista.getIDNino(), vista.getDescripcion());
		if(exito) {
			vistaApadrinar.setMensajeExito("Envio realizado con exito");
		} else {
			vistaApadrinar.setMensajeError("Falta informacion, envio no realizado con exito");
		}
		
	}

}
