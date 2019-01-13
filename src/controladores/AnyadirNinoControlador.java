package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelos.GestionNinosModelo;
import vistas.AnadirNinoFormularioVista;

public class AnyadirNinoControlador implements ActionListener {

	GestionNinosModelo gesNinosModelo;
	AnadirNinoFormularioVista vistaAnadirNinos;
	GestionNinosControlador gestionNinosCtr;
	Boolean tipo; // 0->añadir || 1->modificar
	int id;

	public AnyadirNinoControlador(GestionNinosControlador gestionNinosCtr) {
		this.gestionNinosCtr = gestionNinosCtr;
		this.gesNinosModelo = new GestionNinosModelo();
		this.vistaAnadirNinos = new AnadirNinoFormularioVista();
		this.tipo = false;
	}
	
	public AnyadirNinoControlador(GestionNinosControlador gestionNinosCtr, int id) {
		this.gestionNinosCtr = gestionNinosCtr;
		this.gesNinosModelo = new GestionNinosModelo();
		this.vistaAnadirNinos = new AnadirNinoFormularioVista();
		this.tipo = true;
		this.id = id;
	}

	public void iniciarVista() {
		this.vistaAnadirNinos.controlador(this);
		this.vistaAnadirNinos.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("CONFIRMAR")) {
			if (!tipo) { /* AÑADIR */
				gesNinosModelo.insertarNino(vistaAnadirNinos.getNombre(), vistaAnadirNinos.getApellidos(),
						vistaAnadirNinos.getDireccion(), vistaAnadirNinos.getPoblacion(),
						vistaAnadirNinos.getFechaNacimiento(), vistaAnadirNinos.getSexo(), 101,
						vistaAnadirNinos.getFechaAlta(), vistaAnadirNinos.getFechaAltaACOES(),
						vistaAnadirNinos.getFechaSalidaACOES(), vistaAnadirNinos.getFechaAltaProyecto(),
						vistaAnadirNinos.getFechaSalidaProyecto(), vistaAnadirNinos.getObservaciones(),
						vistaAnadirNinos.getNIF());
				try {
					this.gestionNinosCtr.cargarTabla();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.vistaAnadirNinos.setVisible(false);
			} else { /* MODIFICAR */
				gesNinosModelo.modificarNino(id, vistaAnadirNinos.getNombre(), vistaAnadirNinos.getApellidos(),
						vistaAnadirNinos.getDireccion(), vistaAnadirNinos.getPoblacion(),
						vistaAnadirNinos.getFechaNacimiento(), vistaAnadirNinos.getSexo(), vistaAnadirNinos.getProyecto(),
						vistaAnadirNinos.getFechaAlta(), vistaAnadirNinos.getFechaAltaACOES(),
						vistaAnadirNinos.getFechaSalidaACOES(), vistaAnadirNinos.getFechaAltaProyecto(),
						vistaAnadirNinos.getFechaSalidaProyecto(), vistaAnadirNinos.getObservaciones(),
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

	public void preCargarDatos(String nombreSeleccionado, String apellidosSeleccionado, String fechaNacSeleccionado,
			String nifSeleccionado, String direccionSeleccionado, String poblacionSeleccionado, String sexoSeleccionado,
			String proyectoSeleccionado, String fechaAltaSeleccionado, String fechaAltaACOESSeleccionado,
			String fechaSalidaACOESSeleccionado, String altaProyectoSeleccionado, String salidaProyectoSeleccionado,
			String observacionSeleccionado) {
		this.vistaAnadirNinos.setNombre(nombreSeleccionado);
		this.vistaAnadirNinos.setApellido(apellidosSeleccionado);
		this.vistaAnadirNinos.setFechaNacimiento(fechaNacSeleccionado);
		this.vistaAnadirNinos.setNIF(nifSeleccionado);
		this.vistaAnadirNinos.setDireccion(direccionSeleccionado);
		this.vistaAnadirNinos.setPoblacion(poblacionSeleccionado);
		this.vistaAnadirNinos.setSexo(sexoSeleccionado);
		this.vistaAnadirNinos.setProyecto(proyectoSeleccionado);
		this.vistaAnadirNinos.setFechaAlta(fechaAltaSeleccionado);
		this.vistaAnadirNinos.setFechaAltaACOES(fechaAltaACOESSeleccionado);
		this.vistaAnadirNinos.setFechaSalidaACOES(fechaSalidaACOESSeleccionado);
		this.vistaAnadirNinos.setFechaAltaProyecto(altaProyectoSeleccionado);
		this.vistaAnadirNinos.setFechaSalidaProyecto(salidaProyectoSeleccionado);
		this.vistaAnadirNinos.setObservacion(observacionSeleccionado);
		
	}

}
