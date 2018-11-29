
package modelos;

import principal.BD;
import vistas.LoginVista;



public class LoginModelo {
	public Usuario autenticar(String email, String password) {
		
		Usuario usuario = null;
		try {

		BD bd = new BD();
		Object[] tupla= bd.Select("SELECT * FROM USUARIO U JOIN ROL R ON U.ROL_idRol = R.idRol WHERE U.Correo='"+email+"';").get(0);
		if(tupla[1].equals(password)) {
			usuario = bd.getSocio(email);
		} else
			System.err.println("Contrasena no valida");
			Object[] tupla2 = bd.Select("SELECT * FROM USUARIO JOIN PERSONA ON idPersona=idUsuario WHERE idUsuario="+tupla[0]+";").get(0);
			Rol rol = new Rol((String)tupla[6],(String) tupla[7], (String)tupla[8]);
			System.out.println(rol.getNombre());
			usuario = new Usuario((String)tupla2[6],(String)tupla2[7],(String)tupla2[8],(String)tupla2[9],(String)tupla2[2],null, rol);
		}

		
		catch(Exception e) {
			
		}
		
		return usuario;
	}
}

