package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.CrearSocioModelo;
import vistas.CrearSocioVista;

public class ModificarSocioControlador implements ActionListener{
	private CrearSocioVista vista;
	private CrearSocioModelo modelo;
	
	
	public ModificarSocioControlador(CrearSocioVista vista, CrearSocioModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void iniciarVista() {
		vista.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
				
	}

}