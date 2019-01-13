package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import informes.NinoInforme;
import modelos.GestionNinosModelo;
import modelos.Nino;
import principal.BD;
import vistas.AdministradorVista;
import vistas.GestionNinosVista;

public class GestionNinosControlador implements ActionListener {

	private GestionNinosVista vistaGestionNinos;
	private BD bd = new BD();

	public GestionNinosControlador(AdministradorVista vistaAdmin) {
		vistaGestionNinos = new GestionNinosVista();
	}

	public GestionNinosVista iniciarVista() throws SQLException {
		vistaGestionNinos.controlador(this);
		this.cargarTabla();
		// vistaGestionNinos.cargarTabla(bd.getAllNinos());
		vistaGestionNinos.setVisible(true);
		return vistaGestionNinos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "INSERTAR":
			AnyadirNinoControlador anyadirNinoCtr = new AnyadirNinoControlador(this);
			anyadirNinoCtr.iniciarVista();
			break;
		case "ACTUALIZAR":
			AnyadirNinoControlador modificarNinoCtr = new AnyadirNinoControlador(this,
					Integer.parseInt(vistaGestionNinos.getIDSeleccionado()));
			modificarNinoCtr.preCargarDatos(vistaGestionNinos.getNombreSeleccionado(),
					vistaGestionNinos.getApellidosSeleccionado(), vistaGestionNinos.getFechaNacSeleccionado(),
					vistaGestionNinos.getNIFSeleccionado(), vistaGestionNinos.getDireccionSeleccionado(),
					vistaGestionNinos.getPoblacionSeleccionado(), vistaGestionNinos.getSexoSeleccionado(),
					vistaGestionNinos.getProyectoSeleccionado(), vistaGestionNinos.getFechaAltaSeleccionado(),
					vistaGestionNinos.getFechaAltaACOESSeleccionado(),
					vistaGestionNinos.getFechaSalidaACOESSeleccionado(),
					vistaGestionNinos.getAltaProyectoSeleccionado(), vistaGestionNinos.getSalidaProyectoSeleccionado(),
					vistaGestionNinos.getObservacionSeleccionado());
			modificarNinoCtr.iniciarVista();
			break;
		case "ELIMINAR":
			try {
				new BD().eliminarNinoBaseDeDatos(Integer.parseInt(vistaGestionNinos.getIDSeleccionado()));
				vistaGestionNinos.eliminarNinoSeleccionado();
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "GENERAR_INFORME":
			try {
				new NinoInforme(new Nino(Integer.parseInt(vistaGestionNinos.getIDSeleccionado()),
						vistaGestionNinos.getNombreSeleccionado(), vistaGestionNinos.getApellidosSeleccionado(),
						vistaGestionNinos.getDireccionSeleccionado(), vistaGestionNinos.getPoblacionSeleccionado(),
						vistaGestionNinos.getFechaNacSeleccionado(), null, vistaGestionNinos.getSexoSeleccionado(), -1,
						vistaGestionNinos.getFechaAltaSeleccionado(), vistaGestionNinos.getFechaAltaACOESSeleccionado(),
						vistaGestionNinos.getFechaSalidaACOESSeleccionado(),
						vistaGestionNinos.getAltaProyectoSeleccionado(),
						vistaGestionNinos.getSalidaProyectoSeleccionado(),
						vistaGestionNinos.getObservacionSeleccionado(), vistaGestionNinos.getNIFSeleccionado()), vistaGestionNinos.getProyectoSeleccionado());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		}
	}

	public void cargarTabla() throws SQLException {
		this.vistaGestionNinos.cargarTabla(bd.getAllNinos(), bd.getAllProyectos());
	}

}
