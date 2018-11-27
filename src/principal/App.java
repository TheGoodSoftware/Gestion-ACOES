package principal;
import controladores.ControladorLogin;
import modelos.LoginModelo;
import vistas.LoginVista;

public class App {

	public static void main(String[] args) {
		LoginVista vista = new LoginVista();
		LoginModelo modelo = new LoginModelo();
		ControladorLogin ctr = new ControladorLogin(vista,modelo);
		
		vista.controlador(ctr);
		ctr.iniciarVista();
		
	}

}
