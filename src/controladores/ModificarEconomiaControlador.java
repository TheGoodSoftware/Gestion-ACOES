package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Collections;

import modelos.*;
import vistas.*;
import principal.BD;

public class ModificarEconomiaControlador implements ActionListener {

	private Economia modelo;
	private AnyadirEconomiaVista vistaEconomiaModificar;
	private GestionEconomicaVista vistaGestionEconomica;
	
	public ModificarEconomiaControlador(GestionEconomicaVista vistaGestionEconomica, AnyadirEconomiaVista vistaEconomia, Economia modelo) {
		this.vistaGestionEconomica = vistaGestionEconomica;
		this.vistaEconomiaModificar = vistaEconomia;
		this.modelo = modelo;
		this.vistaEconomiaModificar.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("CANCELAR"))
		{
			this.vistaEconomiaModificar.dispose();
		} else if(e.getActionCommand().equals("CONFIRMAR")) {
			ArrayList<Object> data = vistaEconomiaModificar.getData();
			modelo.setCantidad(Double.parseDouble(data.get(0).toString()));
			modelo.setMoneda(data.get(1).toString());
			modelo.setDescripcion(data.get(2).toString());
			modelo.setTipo(data.get(3).toString());
			modelo.setBeneficiarioProcedencia(data.get(4).toString());
			modelo.setFecha(data.get(5).toString());
			vistaGestionEconomica.updateTable();
			this.vistaEconomiaModificar.dispose();
		}
	}
}
