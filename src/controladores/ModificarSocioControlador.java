package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.CrearSocioModelo;
import modelos.Usuario;
import principal.BD;
import vistas.CrearSocioVista;

public class ModificarSocioControlador implements ActionListener{
	private CrearSocioVista vista;
	private CrearSocioModelo modelo;
	
	private String nombre;
	private String apellidos;
	private String correo;
	private String rol;
	private int id;
	
	public ModificarSocioControlador(CrearSocioVista vista, CrearSocioModelo modelo,int id, String nombre, String apellidos, String correo, String rol) {
		this.vista = vista;
		this.modelo = modelo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.rol = rol;
		this.id = id;
	}
	
	public void iniciarVista() {
		vista.setParametros(nombre, apellidos, correo);
		vista.setVisible(true);
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
				
			}/*
			else if(vista.getContrasenya().equals("")) {
				
			}
			*/
			else if(vista.getCorreo().equals("")){
				
			}
			else if(vista.getRol(bd.getAllRoles())==null) {
				
			}
			else {
				//consulta
				bd.modificarUsuarioBaseDeDatos(new Usuario(this.id, vista.getNombre(), vista.getApellidos(), "","",vista.getCorreo(), null, vista.getRol(bd.getAllRoles())),vista.getContrasenya());
			}
			
		}else if(e.getActionCommand().equals("ATRAS")) {
			
		}
	}

}
