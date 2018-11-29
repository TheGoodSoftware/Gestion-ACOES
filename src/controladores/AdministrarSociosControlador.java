package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.AdminSociosModelo;
import modelos.CrearSocioModelo;
import vistas.AdminSociosVista;
import vistas.CrearSocioVista;

public class AdministrarSociosControlador implements ActionListener{
	
	private AdminSociosVista vistaAdministrarSocios;
	private AdminSociosModelo modelo;
	
	public AdministrarSociosControlador(AdminSociosVista vista, AdminSociosModelo modelo) {
		this.vistaAdministrarSocios = vista;
		this.modelo = modelo;
	}
	
	public void iniciarVista() {
		vistaAdministrarSocios.setVisible(true);
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
	        break;
		}else if(e.getActionCommand().equals("MODIFICAR_SOCIO")) {
			
		} else if(e.getActionCommand().equals("ELIMINAR_SOCIO")) {
			
		}
	}

}
