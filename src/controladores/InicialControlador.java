package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.AdministradorVista;
import principal.BD;
import vistas.AprobarEconomiaVista;

public class InicialControlador implements ActionListener {

	private AdministradorVista vista;
	
	public InicialControlador(AdministradorVista vista) {
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("MOSTRAR_ACCIONES")) {
			AprobarEconomiaVista vistaEconomia = new AprobarEconomiaVista(new BD().getEconomiaNoAprobada());
			vistaEconomia.addControlador(new AceptarEconomiaControlador(vistaEconomia));
			vista.setPanelContenido(vistaEconomia);
		}
	}

}
