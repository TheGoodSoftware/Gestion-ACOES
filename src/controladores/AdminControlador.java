package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.Usuario;
import vistas.AdminVista;

public class AdminControlador implements ActionListener{

	private AdminVista vistaAdmin;
	private Usuario usuario;
	//private AdminModelo modelo;
	
	public AdminControlador(AdminVista vista, Usuario usuario) {
		this.vistaAdmin = vista;
		this.usuario = usuario;
		//this.modelo = modelo;
	}
	
	public void iniciarVista() {
		if(usuario.getRole().getNombre().equalsIgnoreCase("Agente")) {
	          vistaAdmin.agenteOff();
	        }else if(usuario.getRole().getNombre().equalsIgnoreCase("ResponsableAcademico")) {
	          vistaAdmin.academicoOff();
	        }else if(usuario.getRole().getNombre().equalsIgnoreCase("ResponsableEconomico")) {
	          vistaAdmin.economicoOff();
	        }else if(usuario.getRole().getNombre().equalsIgnoreCase("Socio")) {
	          vistaAdmin.socioOff();
	        }
		vistaAdmin.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
