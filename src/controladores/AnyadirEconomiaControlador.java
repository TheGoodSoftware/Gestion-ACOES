package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.GestionEconomica;
import vistas.GestionEconomicaVista;

public class AnyadirEconomiaControlador implements ActionListener {

	private GestionEconomica modelo;
	private GestionEconomicaVista vista;
	
	public AnyadirEconomiaControlador(GestionEconomicaVista vista, GestionEconomica modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.vista.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("CANCELAR"))
		{
			this.vista.dispose();
		}		
	}
	
}
