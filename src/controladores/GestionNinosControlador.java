package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.GestionNinosModelo;
import vistas.GestionNinosVista;

public class GestionNinosControlador implements ActionListener{
	
	private GestionNinosVista vistaGestionNinos;
	private GestionNinosModelo modeloGestionNinos;
	public GestionNinosControlador() {
		vistaGestionNinos = new GestionNinosVista();
		modeloGestionNinos = new GestionNinosModelo();
	}
	
	public void iniciarVista() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
