package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelos.GestionNinosModelo;
import vistas.AnadirNinoFormularioVista;

public class AnyadirNinoControlador implements ActionListener {
	
	GestionNinosModelo gesNinosModelo;
	AnadirNinoFormularioVista  vistaAnadirNinos;
	GestionNinosControlador gestionNinosCtr;
	public AnyadirNinoControlador(GestionNinosControlador gestionNinosCtr) {
		this.gestionNinosCtr = gestionNinosCtr;
		this.gesNinosModelo = new GestionNinosModelo();
		this.vistaAnadirNinos = new AnadirNinoFormularioVista();
	}
	
	public void iniciarVista() {
		this.vistaAnadirNinos.controlador(this);
		this.vistaAnadirNinos.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("CONFIRMAR")) {
			gesNinosModelo.insertarNino(vistaAnadirNinos.getNombre(), vistaAnadirNinos.getApellidos(), vistaAnadirNinos.getDireccion(), 
					vistaAnadirNinos.getPoblacion(), vistaAnadirNinos.getFechaNacimiento(), vistaAnadirNinos.getSexo(), 101,
					vistaAnadirNinos.getFechaAlta(), vistaAnadirNinos.getFechaAltaACOES(), vistaAnadirNinos.getFechaSalidaACOES(), 
					vistaAnadirNinos.getFechaAltaProyecto()	,vistaAnadirNinos.getFechaSalidaProyecto(), vistaAnadirNinos.getObservaciones(), 
					vistaAnadirNinos.getNIF());
			try {
				this.gestionNinosCtr.cargarTabla();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.vistaAnadirNinos.setVisible(false);
		}
		
	}

}
