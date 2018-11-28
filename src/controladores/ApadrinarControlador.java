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
		// TODO Auto-generated method stub
		
	}

}
