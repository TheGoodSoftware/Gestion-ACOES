package controladores;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;

import modelos.LoginModelo;
import modelos.Nino;
import modelos.Rol;
import modelos.Usuario;
import vistas.AdminVista;
import vistas.LoginVista;
import vistas.SocioVista;

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
			Usuario loggedUser = modelo.autenticar(vistaLogin.getUsuario(), vistaLogin.getPassword());
			if(loggedUser != null) {
				if(!loggedUser.getRole().getNombre().equalsIgnoreCase("USUARIO")) {
					AdminControlador ctrAdmin = new AdminControlador(loggedUser);
					vistaLogin.setVisible(false);
					ctrAdmin.iniciarVista();
				} else {
					SocioVista vistaSocio = new SocioVista(loggedUser);
					JFrame vista = new JFrame();
					vista.setContentPane(vistaSocio);
					vista.setTitle("GestionACOES");
					vista.setMinimumSize(new Dimension(820, 400));
					vista.setVisible(true);
					vistaLogin.setVisible(false);
				}
			}
			else {
				vistaLogin.mensajeErrorAutenticacion();
			}
		}
		
	}

}
