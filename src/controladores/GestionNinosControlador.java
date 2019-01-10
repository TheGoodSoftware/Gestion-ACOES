package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import modelos.GestionNinosModelo;
import principal.BD;
import vistas.AdminVista;
import vistas.GestionNinosVista;

public class GestionNinosControlador implements ActionListener{
	
	private GestionNinosVista vistaGestionNinos;
	private GestionNinosModelo modeloGestionNinos;
	private AdminVista vistaAdmin;
	private boolean estadoActualizar;
	private BD bd = new BD();
	public GestionNinosControlador(AdminVista vistaAdmin) {
		vistaGestionNinos = new GestionNinosVista();
		modeloGestionNinos = new GestionNinosModelo();
		estadoActualizar = false;
		this.vistaAdmin = vistaAdmin;
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
			modeloGestionNinos.insertarNino(vistaGestionNinos.getNombre(), vistaGestionNinos.getEdad(), vistaGestionNinos.getSexo(), vistaGestionNinos.getIdentidad(), vistaGestionNinos.getCCJ(), vistaGestionNinos.getColegio(), vistaGestionNinos.getBecado());
			try {
				iniciarVista();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "ACTUALIZAR":
			if(!estadoActualizar) {
			vistaGestionNinos.setNombre(vistaGestionNinos.getNombreSeleccionado());
			vistaGestionNinos.setEdad(vistaGestionNinos.getEdadSeleccionada());
			vistaGestionNinos.setSexo(vistaGestionNinos.getSexoSeleccionado());
			vistaGestionNinos.setIdentidad(vistaGestionNinos.getIdentidadSeleccionado());
			//vistaGestionNinos.setCCJ(vistaGestionNinos.getCCJSeleccionado());
			vistaGestionNinos.setColegio(vistaGestionNinos.getColegioSeleccionado());
			vistaGestionNinos.setBecado(vistaGestionNinos.getBecadoSeleccionado());
			vistaGestionNinos.setConfirmacionActualizar();
			estadoActualizar=true;
			}
			else {
				modeloGestionNinos.modificarNino(vistaGestionNinos.getIDSeleccionado(), vistaGestionNinos.getNombre(), vistaGestionNinos.getEdad(), vistaGestionNinos.getSexo(), vistaGestionNinos.getIdentidad(), vistaGestionNinos.getCCJ(), vistaGestionNinos.getColegio(), vistaGestionNinos.getBecado());
				estadoActualizar=false;
				vistaGestionNinos.habilitarBotones();
				try {
					iniciarVista();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
			break;
		case "ELIMINAR":
			try {
				bd.eliminarNinoBaseDeDatos(Integer.parseInt(vistaGestionNinos.getIDSeleccionado()));
				vistaGestionNinos.eliminarNinoSeleccionado();
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "ATRAS":
			this.vistaGestionNinos.setVisible(false);
			this.vistaAdmin.setVisible(true);
			break;
		}
		
	}

}