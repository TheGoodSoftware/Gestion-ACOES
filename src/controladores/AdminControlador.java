package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import vistas.*;
import modelos.*;
import principal.App;
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
    	InicialVista vista = new InicialVista(usuario);
    	vista.addControlador(new InicialControlador(vistaAdmin));
    	vistaAdmin.setPanelContenido(vista);
        if (usuario.getRole().getNombre().equalsIgnoreCase("ACADEMICO")) {
            vistaAdmin.setOnlyAcademico();
        } else if (usuario.getRole().getNombre().equalsIgnoreCase("ECONOMIA")) {
            vistaAdmin.setOnlyEconomia();
        }else if (usuario.getRole().getNombre().equalsIgnoreCase("AGENTE")) {
            vistaAdmin.setOnlySocios();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()) {
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
    		break;
    	case "APADRINAR":
    		System.out.println("Changed content");
    		ApadrinarVista apadrinarVista = new ApadrinarVista();
    		ApadrinarModelo apadrinarModelo = new ApadrinarModelo(this.usuario.getAsociacion());
    		ApadrinarControlador apadrinarControlador = new ApadrinarControlador(apadrinarVista, apadrinarModelo, usuario);
    		apadrinarVista.controlador(apadrinarControlador);
    		apadrinarControlador.iniciarVista();
    		vistaAdmin.setPanelContenido(apadrinarVista);
    		break;
    		/*
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
    	case "CERRAR_SESION":
    	   	vistaAdmin.dispose();
    	   	LoginVista loginVista = new LoginVista();
    	   	LoginControlador controladorLogin = new LoginControlador(loginVista, new LoginModelo());
    	   	loginVista.controlador(controladorLogin);
    	   	controladorLogin.iniciarVista();
    	   	break;
       }
    }
}
