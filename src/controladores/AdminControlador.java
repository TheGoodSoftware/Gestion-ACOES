package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.*;
import modelos.*;
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
        if (usuario.getRole().getNombre().equalsIgnoreCase("Socio")) {
            vistaSocio = new SocioVista(usuario);
            vistaSocio.setVisible(true);
        } else {
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
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()) {
       case "APADRINAR":
    	   ApadrinarVista vistaApadrinar = new ApadrinarVista();
    	   ApadrinarModelo modeloApadrinar = new ApadrinarModelo();
    	   ApadrinarControlador ctr = new ApadrinarControlador(vistaApadrinar, modeloApadrinar);
    	   ctr.iniciarVista();
    	   vistaAdmin.setVisible(false);
    	   vistaApadrinar.setVisible(true);
    	   
    	   break;
    	case "VISTA_SOCIO":
    	    if(usuario.getE_mail().equals("usuario@correo.es"))
            {
                Rol rol = new Rol("Admin", "Honduras", "Descripcion");
                Map<String, Integer> notasApadrinado = new TreeMap<>();
                notasApadrinado.put("1Primaria", 8);
                notasApadrinado.put("2Primaria", 7);
                ArrayList<Nino> apadrinados = new ArrayList<>();
                apadrinados.add(new Nino("Juan", "Perez", "AVDA 18", "Bogota", 17, notasApadrinado));
                Usuario usuario = new Usuario("nombre","apellidos","direccion","pueblo","e_mail",apadrinados, rol);
                vistaSocio = new SocioVista(usuario);
            } else
                vistaSocio = new SocioVista(usuario);
            vistaAdmin.setVisible(false);
    	    vistaSocio.setVisible(true);
       }
    }
}
