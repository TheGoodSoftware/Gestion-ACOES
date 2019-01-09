package controladores;

import modelos.*;
import vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EconomiaControlador implements ActionListener {
	
	private GestionEconomicaVista vistaGestion;
	private GestionEconomica gestion;
	private AdminVista vistaAdmin;
	
	public EconomiaControlador(GestionEconomicaVista vistaGestion, AdminVista vistaAdmin, GestionEconomica gestion) {
		this.vistaGestion = vistaGestion;
		this.vistaAdmin = vistaAdmin;
		this.gestion = gestion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}