package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.CrearSocioModelo;
import modelos.Usuario;
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
		BD bd = new BD();
		//mostrar mensaje error
		if(vista.getNombre().equals("")) {
			
		}
		else if(vista.getApellidos().equals("")) {
			
		}
		else if(vista.getContrasenya().equals("")) {
			
		}
		else if(vista.getCorreo().equals("")){
			
		}
		else if(vista.getRol(bd.getAllRoles())==null) {
			
		}
		else {
			//consulta
			bd.insertarUsuarioBaseDeDatos(new Usuario(vista.getNombre(), vista.getApellidos(), "","",vista.getCorreo(), null, vista.getRol(bd.getAllRoles())),vista.getContrasenya());
		}
		
	}else if(e.getActionCommand().equals("ATRAS")) {
		
	}
	}

}
