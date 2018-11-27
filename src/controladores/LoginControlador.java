package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.LoginModelo;
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
		if(e.getActionCommand().equals("IN")) {
			vistaLogin.borrarMensajeErrorAutenticacion();
			//cambia al panel de administrador
			if(modelo.autenticar(vistaLogin.getUsuario(), vistaLogin.getPassword(), vistaLogin)) {
				//crea el usuario (hasta tener bbdd)
				Rol rol = new Rol("Agente", "Honduras", "Descripcion");
			    Usuario usuario = new Usuario("nombre","apellidos","direccion","pueblo","e_mail",rol);
			    
			    AdminVista vistaAdmin = new AdminVista();
			    AdminControlador ctrAdmin = new AdminControlador(vistaAdmin, usuario);
			    vistaLogin.setVisible(false);
			    ctrAdmin.iniciarVista();
			    
			    
				
			}
		}
		
	}

}
