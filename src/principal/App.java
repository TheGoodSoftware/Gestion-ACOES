package principal;
import controladores.LoginControlador;
import modelos.LoginModelo;
import vistas.AdministrarSociosVista;
import vistas.AdminVista;
import vistas.LoginVista;

public class App {

	public static void main(String[] args) {
		LoginVista vista = new LoginVista();
		LoginModelo modelo = new LoginModelo();
		LoginControlador ctr = new LoginControlador(vista,modelo);
		
		vista.controlador(ctr);
		ctr.iniciarVista();

	}
}
