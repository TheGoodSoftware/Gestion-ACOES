package controladores;

import modelos.GestionAcademica;
import vistas.AdminVista;
import vistas.GestionAcademicaVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionAcademicaControlador implements ActionListener {

    private GestionAcademicaVista vistaGestion;
    private GestionAcademica gestion;
    private AdminVista vistaAdmin;

    public GestionAcademicaControlador(GestionAcademicaVista vistaGestion, AdminVista vistaAdmin, GestionAcademica gestion) {
        this.vistaGestion = vistaGestion;
        this.vistaAdmin = vistaAdmin;
        this.gestion = gestion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ATRAS":
                vistaGestion.dispose();
                vistaAdmin.setVisible(true);
                break;
            case "ANYADIR":
                AnyadirEducacionVista anyadirEducacion = new AnyadirEducacionVista(this.gestion);
                anyadirEducacion.addControlador(new AnyadirEducacionControlador(this.vistaGestion, anyadirEducacion, gestion));
                break;
        }
    }
}
