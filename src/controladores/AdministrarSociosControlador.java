package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.AdministrarSociosModelo;
import modelos.CrearSocioModelo;
import vistas.AdministrarSociosVista;
import vistas.CrearSocioVista;

public class AdministrarSociosControlador implements ActionListener{
	
	private AdministrarSociosVista vistaAdmin;
	private AdministrarSociosModelo modelo;
	
	public AdministrarSociosControlador(AdministrarSociosVista vista, AdministrarSociosModelo modelo) {
		this.vistaAdmin = vista;
		this.modelo = modelo;
	}
	
	public void iniciarVista() {
		vistaAdmin.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("CREAR_SOCIO")) {
			CrearSocioModelo creaSocioModelo = new CrearSocioModelo();
	        CrearSocioVista creaSocioVista = new CrearSocioVista();
	        CrearSocioControlador creaSocioCtr = new CrearSocioControlador(creaSocioVista, creaSocioModelo);
	        creaSocioVista.Controlador(creaSocioCtr);
	        vistaAdmin.setVisible(false);
	        creaSocioCtr.iniciarVista();
		}else if(e.getActionCommand().equals("MODIFICAR_SOCIO")) {
			
		} else if(e.getActionCommand().equals("ELIMINAR_SOCIO")) {
			
		}
	}

}
