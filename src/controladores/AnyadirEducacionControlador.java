package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Collections;

import modelos.*;
import vistas.*;
import principal.BD;

public class AnyadirEducacionControlador implements ActionListener {

    private GestionAcademica modelo;
    private AnyadirEducacionVista vistaEducacionAnyadir;
    private GestionAcademicaVista vistaGestionAcademica;

    public AnyadirEducacionControlador(GestionAcademicaVista vistaGestionAcademica, AnyadirEducacionVista vistaEducacion, GestionAcademica modelo) {
        this.vistaGestionAcademica = vistaGestionAcademica;
        this.vistaEducacionAnyadir = vistaEducacion;
        this.modelo = modelo;
        this.vistaEducacionAnyadir.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CANCELAR"))
        {
            this.vistaEducacionAnyadir.dispose();
        } else if(e.getActionCommand().equals("ANYADIR")) {
            Educacion data = vistaEducacionAnyadir.getData();
            int educacionID = -1;


            data.setId(educacionID);

            try {
                modelo.getEducacions().add(data);
                new BD().insertarEducacion(data);
            } catch (NumberFormatException e1) {

                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            vistaGestionAcademica.updateTable();
            this.vistaEducacionAnyadir.dispose();
        }
    }

}
