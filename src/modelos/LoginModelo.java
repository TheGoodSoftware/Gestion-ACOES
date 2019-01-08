
package modelos;

import principal.BD;
import vistas.LoginVista;



public class LoginModelo {
	public Usuario autenticar(String email, String password) {
		
		Usuario usuario = null;
		try {

			BD bd = new BD();
			Object[] tupla = bd.Select("SELECT * FROM usuario U JOIN rol R ON U.rol_idRol = R.idRol WHERE U.Correo='" + email + "';").get(0);
			if (tupla[1].equals(password)) {
				usuario = bd.getSocio(email);
				
			} else
				System.err.println("Contrasena no valida");
		} catch(Exception e) {
			
		}
		
		return usuario;
	}
}

