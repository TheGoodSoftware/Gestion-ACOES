package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.LoginModelo;
import vistas.LoginVista;

public class LoginControlador implements ActionListener {
	
	private LoginVista vista;
	private LoginModelo modelo;
	
	public LoginControlador(LoginVista vista, LoginModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void iniciarVista() {
		
		vista.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("IN")) {
			vista.borrarMensajeErrorAutenticacion();
			//cambia al panel de administrador
			if(modelo.autenticar(vista.getUsuario(), vista.getPassword(), vista)) {
				
			}
		}
		
	}

}
