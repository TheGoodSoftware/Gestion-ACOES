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
			if(modelo.autenticar(vistaLogin.getUsuario(), vistaLogin.getPassword(), vistaLogin)) {
				//crea el usuario (hasta tener bbdd)
				Rol rol = new Rol("Admin", "Honduras", "Descripcion");
				Map<String, Integer> notasApadrinado = new TreeMap<>();
				notasApadrinado.put("1Primaria", 8);
				notasApadrinado.put("2Primaria", 7);
				ArrayList<Nino> apadrinados = new ArrayList<>();
				apadrinados.add(new Nino("Juan", "Perez", "AVDA 18", "Bogota", 17, notasApadrinado));
			    Usuario usuario = new Usuario("nombre","apellidos","direccion","pueblo","e_mail",apadrinados, rol);
			    AdminControlador ctrAdmin = new AdminControlador(usuario);
			    
			    vistaLogin.setVisible(false);
			    ctrAdmin.iniciarVista();
			}
		}
		
	}

}
