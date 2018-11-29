package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.CrearSocioModelo;
import principal.BD;
import vistas.CrearSocioVista;

public class CrearSocioControlador implements ActionListener{
	private CrearSocioVista vista;
	private CrearSocioModelo modelo;
	
	
	public CrearSocioControlador(CrearSocioVista vista, CrearSocioModelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void iniciarVista() {
		vista.setVisible(true);
		//se cargan los roles de la base de datos
		BD bd = new BD();
		vista.insertarRoles(bd.getAllRoles());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("ANADIR")) {
		
	}else if(e.getActionCommand().equals("ATRAS")) {
		
	}
	}

}
