package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vistas.AprobarEconomiaVista;
import modelos.Economia;
import modelos.GestionEconomica;
import principal.BD;

public class AceptarEconomiaControlador implements ActionListener {

	private AprobarEconomiaVista vista;
	
	public AceptarEconomiaControlador(AprobarEconomiaVista vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GestionEconomica gestion = vista.getGestion();
		Economia seleccionado = vista.getGestion().getEconomias().get(vista.getSeleccionado());
		if(e.getActionCommand().equals("ACEPTAR")) {
			new BD().aceptarEconomia(seleccionado.getId(), seleccionado.getTipo());
			seleccionado.setAceptado(true);
		} else {
			int result = JOptionPane.showConfirmDialog(null, "¿Estás seguro de querer eliminar la fila seleccionada?", "Eliminación de economía", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				gestion.getEconomias().remove(vista.getSeleccionado());
				new BD().eliminarEconomia(seleccionado.getId(), seleccionado.getTipo());
			}
		}
		vista.updateTable();
	}
}
