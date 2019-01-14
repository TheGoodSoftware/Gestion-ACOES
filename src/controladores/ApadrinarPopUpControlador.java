package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.ApadrinarModelo;
import vistas.ApadrinarPopUpVista;
import vistas.ApadrinarVista;

public class ApadrinarPopUpControlador implements ActionListener{
	
	ApadrinarPopUpVista vista;
	ApadrinarModelo modelo;
	ApadrinarVista apadrinarVista;
	
	public ApadrinarPopUpControlador(ApadrinarPopUpVista vista, ApadrinarModelo modelo, ApadrinarVista apadrinarVista) {
		this.vista = vista;
		this.modelo = modelo;
		this.apadrinarVista = apadrinarVista;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String evento = event.getActionCommand();
		
		switch(evento) {
			case "CONFIRMAR": confirmar();
				break;
			case "CANCELAR": cancelar();
			break;
			default: ;
			break;
		}
		
	}

	private void cancelar() {
		vista.setVisible(false);
	}

	private void confirmar() {
		if(vista.getEstado().toUpperCase().equals("APADRINAR")) {
			if(vista.getCargadoDesde().toUpperCase().contains("SOCIO")) {
				boolean exito = modelo.Apadrinar(vista.getPersonaPrecargada(), vista.getSeleccionado(), vista.getCuota());
				if(exito) {
					apadrinarVista.setMensajeExito("El apadrinamiento se realizó con éxito");
				} else {
					apadrinarVista.setMensajeError("El apadrinameinto no se realizó correctamente");
				}
			}
		} else {
			if(vista.getCargadoDesde().toUpperCase().contains("SOCIO")) {
				boolean exito = modelo.Desapadrinar(vista.getPersonaPrecargada(), vista.getSeleccionado());
				if(exito) {
					apadrinarVista.setMensajeExito("El desapadrinamiento se realizó con éxito");
				} else {
					apadrinarVista.setMensajeError("El desapadrinamiento no se realizó correctamente");
				}
				
			} else {
				boolean exito = modelo.Desapadrinar(vista.getSeleccionado(), vista.getPersonaPrecargada());
				if(exito) {
					apadrinarVista.setMensajeExito("El desapadrinamiento se realizó con éxito");
				} else {
					apadrinarVista.setMensajeError("El desapadrinamiento no se realizó correctamente");
				}
			}
		}
	}

}
