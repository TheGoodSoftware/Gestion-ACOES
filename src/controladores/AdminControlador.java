package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import vistas.*;
import modelos.*;
import principal.BD;

import java.util.*;

public class AdminControlador implements ActionListener {

    //private AdminVista vistaAdmin;
    private AdministradorVista vistaAdmin;
	private Usuario usuario;
    private SocioVista vistaSocio;
    //private AdminModelo modelo;

    public AdminControlador(Usuario usuario) {
        this.usuario = usuario;
        //this.modelo = modelo;
    }

    public void iniciarVista() {
    	vistaAdmin = new AdministradorVista();
    	vistaAdmin.addControlador(this);
    	vistaAdmin.setVisible(true);
    	/*
        vistaAdmin = new AdminVista();
        if (usuario.getRole().getNombre().equalsIgnoreCase("ResponsableAcademico")) {
            vistaAdmin.academicoOff();
        } else if (usuario.getRole().getNombre().equalsIgnoreCase("ResponsableEconomico")) {
            vistaAdmin.economicoOff();
        } else if (usuario.getRole().getNombre().equalsIgnoreCase("Agente")) {
            vistaAdmin.agenteOff();
        }
        vistaAdmin.controlador(this);
        vistaAdmin.setVisible(true);*/
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()) {
       /*case "APADRINAR":
    	   ApadrinarVista vistaApadrinar = new ApadrinarVista();
    	   Apadrinar modeloApadrinar = new Apadrinar();
    	   ApadrinarControlador ctr = new ApadrinarControlador(vistaApadrinar, modeloApadrinar, this.usuario);
    	   vistaApadrinar.controlador(ctr);
    	   ctr.iniciarVista();
    	   vistaAdmin.setVisible(false);
    	   break;*/
    	case "VISTA_SOCIO":
    	    vistaSocio = new SocioVista(usuario);
    	    vistaAdmin.setPanelContenido(vistaSocio);
    	    break;
    	case "GESTION_SOCIOS":
    		AdministrarSociosModelo adminSocioModelo = new AdministrarSociosModelo();
    		AdministrarSociosVista adminSocioVista = new AdministrarSociosVista();
    		AdministrarSociosControlador adminSocioCtr = new AdministrarSociosControlador(adminSocioVista, adminSocioModelo);
    		adminSocioVista.controlador(adminSocioCtr);
    		vistaAdmin.setPanelContenido(adminSocioCtr.iniciarVista());
    		break;
    	case "GESTION_ECONOMICA":
    		BD bd = new BD();
    		GestionEconomica gestionEconomica = bd.getEconomia();
    		GestionEconomicaVista economiaVista = new GestionEconomicaVista(gestionEconomica);
    		economiaVista.addControlador(new EconomiaControlador(economiaVista, vistaAdmin, gestionEconomica));
    		economiaVista.setVisible(true);
    		vistaAdmin.setPanelContenido(economiaVista); 		
    		break;/*
	   	case "GESTION_ACADEMICA":
		   	vistaAdmin.setVisible(false);
			bd = new BD();
		   	GestionAcademica gestionAcademica = bd.getEducacion();
		   	GestionAcademicaVista educacionVista = new GestionAcademicaVista(gestionAcademica);
		   	educacionVista.addControlador(new GestionAcademicaControlador(educacionVista, vistaAdmin, gestionAcademica));
		   	educacionVista.setVisible(true);
		   	break;*/
    	case "GESTION_NINOS":
    		GestionNinosControlador gesNinosCtr = new GestionNinosControlador(this.vistaAdmin);
		try {
			vistaAdmin.setPanelContenido(gesNinosCtr.iniciarVista());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
    		break;
    	case "CERRAR":
    	   	vistaAdmin.dispatchEvent(new WindowEvent(vistaAdmin, WindowEvent.WINDOW_CLOSING));
    	   	break;
       }
    }
}
