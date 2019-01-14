package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Collections;

import modelos.*;
import vistas.*;
import principal.BD;

public class AnyadirEconomiaControlador implements ActionListener {

	private GestionEconomica modelo;
	private AnyadirEconomiaVista vistaEconomiaAnyadir;
	private GestionEconomicaVista vistaGestionEconomica;
	
	public AnyadirEconomiaControlador(GestionEconomicaVista vistaGestionEconomica, AnyadirEconomiaVista vistaEconomia, GestionEconomica modelo) {
		this.vistaGestionEconomica = vistaGestionEconomica;
		this.vistaEconomiaAnyadir = vistaEconomia;
		this.modelo = modelo;
		this.vistaEconomiaAnyadir.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("CANCELAR"))
		{
			this.vistaEconomiaAnyadir.dispose();
		} else if(e.getActionCommand().equals("CONFIRMAR")) {
			ArrayList<Object> values = vistaEconomiaAnyadir.getData();
			int economiaID = -1;
			
			for(int i = 0; i < modelo.getEconomias().size(); i++)
			{
				if(modelo.getEconomias().get(i).getId() > economiaID)
					economiaID = modelo.getEconomias().get(i).getId();
			}
			
			economiaID++;
			
			try {
				Economia economia = new Economia(economiaID, Double.parseDouble(values.get(0).toString()), (String)values.get(1), (String)values.get(2), 
						modelo, (String)values.get(3), (String)values.get(4), (String)values.get(5), false);
				modelo.getEconomias().add(economia);
				new BD().insertEconomia(economia);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vistaGestionEconomica.updateTable();
			this.vistaEconomiaAnyadir.dispose();
		}
	}
	
}
