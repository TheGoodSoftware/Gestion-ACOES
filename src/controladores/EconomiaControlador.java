package controladores;

import informes.EconomiaInforme;
import modelos.*;
import vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class EconomiaControlador implements ActionListener {
	
	private GestionEconomicaVista vistaGestion;
	private GestionEconomica gestion;
	private AdministradorVista vistaAdmin;
	
	public EconomiaControlador(GestionEconomicaVista vistaGestion, AdministradorVista vistaAdmin, GestionEconomica gestion) {
		this.vistaGestion = vistaGestion;
		this.vistaAdmin = vistaAdmin;
		this.gestion = gestion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "ANYADIR":
				AnyadirEconomiaVista anyadirEconomia = new AnyadirEconomiaVista();
				anyadirEconomia.addControlador(new AnyadirEconomiaControlador(this.vistaGestion, anyadirEconomia, gestion));
				break;
			case "MODIFICAR":
				AnyadirEconomiaVista modificarEconomia = new AnyadirEconomiaVista(vistaGestion.getEconomiaSeleccionada());
				modificarEconomia.addControlador(new ModificarEconomiaControlador(this.vistaGestion, modificarEconomia, vistaGestion.getEconomiaSeleccionada()));
				break;
			case "IMPRIMIR":
			try {
				new EconomiaInforme(new ArrayList<Economia>(Arrays.asList(vistaGestion.getEconomiasActual())), vistaGestion.getFechaActual());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				break;
		}
	}

}
