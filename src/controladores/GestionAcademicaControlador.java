package controladores;

import informes.EducacionInforme;
import modelos.*;
import vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GestionAcademicaControlador implements ActionListener {

    private GestionAcademicaVista vistaGestion;
    private GestionAcademica gestion;
    private AdministradorVista vistaAdmin;

    public GestionAcademicaControlador(GestionAcademicaVista vistaGestion, AdministradorVista vistaAdmin, GestionAcademica gestion) {
        this.vistaGestion = vistaGestion;
        this.vistaAdmin = vistaAdmin;
        this.gestion = gestion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ANYADIR":

                AnyadirEducacionVista anyadirEducacion = new AnyadirEducacionVista();
                anyadirEducacion.addControlador(new AnyadirEducacionControlador(this.vistaGestion, anyadirEducacion, gestion));
                break;
            case "MODIFICAR":
                AnyadirEducacionVista modificarEducacion = new AnyadirEducacionVista(vistaGestion.getEducacionSeleccionada());
                modificarEducacion.addControlador(new ModificarEducacionControlador(this.vistaGestion, modificarEducacion, vistaGestion.getEducacionSeleccionada()));
                break;
            case "IMPRIMIR":
                try {
                    new EducacionInforme(new ArrayList<Educacion>(Arrays.asList(vistaGestion.getEducacionsActual())));
                    JOptionPane.showMessageDialog(null, "Se ha generado el informe academico correctamente en la carpeta informes", "Informe generado", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                break;

        }
    }
}
