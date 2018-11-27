package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.LoginModelo;
import vistas.LoginVista;

public class ControladorLogin implements ActionListener {
	
	private LoginVista vista;
	private LoginModelo modelo;
	
	public ControladorLogin(LoginVista vista, LoginModelo modelo) {
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
			//IMPLEMENTAR: cambiar a otra ventana
			System.out.println(modelo.autenticar(vista.getUsuario(), vista.getPassword(), vista));
		}
		
	}

}
