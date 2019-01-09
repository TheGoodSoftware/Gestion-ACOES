package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.*;
import modelos.*;
import principal.BD;

import java.util.*;

public class AdminControlador implements ActionListener {

    private AdminVista vistaAdmin;
    private Usuario usuario;
    private SocioVista vistaSocio;
    //private AdminModelo modelo;

    public AdminControlador(Usuario usuario) {
        this.usuario = usuario;
        //this.modelo = modelo;
    }

    public void iniciarVista() {
        vistaAdmin = new AdminVista();
        if (usuario.getRole().getNombre().equalsIgnoreCase("ResponsableAcademico")) {
            vistaAdmin.academicoOff();
        } else if (usuario.getRole().getNombre().equalsIgnoreCase("ResponsableEconomico")) {
            vistaAdmin.economicoOff();
        } else if (usuario.getRole().getNombre().equalsIgnoreCase("Agente")) {
            vistaAdmin.agenteOff();
        }
        vistaAdmin.controlador(this);
        vistaAdmin.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()) {
       case "APADRINAR":
    	   ApadrinarVista vistaApadrinar = new ApadrinarVista();
    	   ApadrinarModelo modeloApadrinar = new ApadrinarModelo();
    	   ApadrinarControlador ctr = new ApadrinarControlador(vistaApadrinar, modeloApadrinar, this.usuario);
    	   ctr.iniciarVista();
    	   vistaAdmin.setVisible(false);
    	   break;
    	case "VISTA_SOCIO":
            vistaAdmin.setVisible(false);
    	    vistaSocio = new SocioVista(usuario);
    	    vistaSocio.setVisible(true);
    	    break;
    	case "GESTION_SOCIOS":
    		AdministrarSociosModelo adminSocioModelo = new AdministrarSociosModelo();
    		AdministrarSociosVista adminSocioVista = new AdministrarSociosVista();
    		AdministrarSociosControlador adminSocioCtr = new AdministrarSociosControlador(adminSocioVista, adminSocioModelo);
    		vistaAdmin.setVisible(false);
    		adminSocioVista.controlador(adminSocioCtr);
    		adminSocioCtr.iniciarVista();
    		break;
    	case "GESTION_ECONOMICA":
    		vistaAdmin.setVisible(false);
    		BD bd = new BD();
    		GestionEconomica gestionEconomica = bd.getEconomia();
    		Object[][] valores = new Object[gestionEconomica.getEconomias().size()][7];
    		for(int i = 0; i < gestionEconomica.getEconomias().size(); i++) {
    			Object[] values = new Object[5];
    			values[0] = gestionEconomica.getEconomias().get(i).getId();
    			values[1] = gestionEconomica.getEconomias().get(i).getCantidad();
    			values[2] = gestionEconomica.getEconomias().get(i).getTipo();
    			values[3] = gestionEconomica.getEconomias().get(i).getDescripcion();
    			values[4] = gestionEconomica.getEconomias().get(i).getUsuario().getNombreCompleto();
    			valores[i] = values;
    		}
    		GestionEconomicaVista economiaVista = new GestionEconomicaVista(valores);
    		economiaVista.setVisible(true);
       }
    }
}
