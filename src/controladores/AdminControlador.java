package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.Usuario;
import vistas.*;

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
            vistaAdmin.setVisible(true);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
