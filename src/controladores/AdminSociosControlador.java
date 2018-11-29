package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.AdminSociosModelo;
import vistas.AdminSociosVista;

public class AdminSociosControlador implements ActionListener{
	
	private AdminSociosVista vista;
	private AdminSociosModelo modelo;
	
	public AdminSociosControlador(AdminSociosVista vista, AdminSociosModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void iniciarVista() {
		vista.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
