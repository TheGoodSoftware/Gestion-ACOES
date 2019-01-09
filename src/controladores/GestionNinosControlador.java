package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelos.GestionNinosModelo;
import principal.BD;
import vistas.GestionNinosVista;

public class GestionNinosControlador implements ActionListener{
	
	private GestionNinosVista vistaGestionNinos;
	private GestionNinosModelo modeloGestionNinos;
	private BD bd = new BD();
	public GestionNinosControlador() {
		vistaGestionNinos = new GestionNinosVista();
		modeloGestionNinos = new GestionNinosModelo();
	}
	
	public void iniciarVista() throws SQLException {
		vistaGestionNinos.controlador(this);
		vistaGestionNinos.cargarTabla(bd.getAllNinos());
		vistaGestionNinos.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "INSERTAR":
			break;
		case "ACTUALIZAR":
			break;
		case "BORRAR":
			break;
		case "ATRAS":
			break;
		}
		
	}

}
