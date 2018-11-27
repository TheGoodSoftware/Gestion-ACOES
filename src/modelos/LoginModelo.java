
package modelos;

import principal.BD;
import vistas.LoginVista;



public class LoginModelo {
	public boolean autenticar(String usuario, String password, LoginVista vista) {
		Object[] tupla = null;
		boolean res = false;
		try {
		BD bd = new BD();
		tupla= bd.Select("SELECT * FROM usuario WHERE usuario='"+usuario+"';").get(0);
		res = tupla[1].equals(password);
		if(!res) vista.mensajeErrorAutenticacion();
		}
		catch(Exception e) {
			vista.mensajeErrorAutenticacion();
		}
		return res;
	}
}
