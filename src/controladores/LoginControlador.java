package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import modelos.LoginModelo;
import modelos.Nino;
import modelos.Rol;
import modelos.Usuario;
import vistas.AdminVista;
import vistas.LoginVista;

public class LoginControlador implements ActionListener {
	
	private LoginVista vistaLogin;
	private LoginModelo modelo;
	
	public LoginControlador(LoginVista vista, LoginModelo modelo) {
		this.vistaLogin = vista;
		this.modelo = modelo;
	}
	
	public void iniciarVista() {
		vistaLogin.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("INICIAR_SESION")) {
			vistaLogin.borrarMensajeErrorAutenticacion();
			//cambia al panel de administrador
			Usuario loggedUser = modelo.autenticar(vistaLogin.getUsuario(), vistaLogin.getPassword(), vistaLogin);
			if(loggedUser != null) {
			    AdminControlador ctrAdmin = new AdminControlador(loggedUser);
			    
			    vistaLogin.setVisible(false);
			    ctrAdmin.iniciarVista();
			}
		}
		
	}

}
