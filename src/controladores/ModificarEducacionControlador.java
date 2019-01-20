package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Collections;

import modelos.*;
import vistas.*;
import principal.BD;

public class ModificarEducacionControlador implements ActionListener {

    private Educacion modelo;
    private AnyadirEducacionVista vistaEducacionModificar;
    private GestionAcademicaVista vistaGestionAcademica;


    public ModificarEducacionControlador(GestionAcademicaVista vistaGestionAcademica, AnyadirEducacionVista vistaEducacion, Educacion modelo) {
        this.vistaGestionAcademica = vistaGestionAcademica;
        this.vistaEducacionModificar = vistaEducacion;
        this.modelo = modelo;
        this.vistaEducacionModificar.setVisible(true);
        this.vistaEducacionModificar.ocultarInecesario();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CANCELAR"))
        {
            this.vistaEducacionModificar.dispose();
        } else if(e.getActionCommand().equals("CONFIRMAR")) {
            int idEd = modelo.getId();
            int idNota = modelo.getIdNota();
            modelo = vistaEducacionModificar.getData();
            modelo.setId(idEd);
            modelo.setIdNota(idNota);
            new BD().modificarEducacion(modelo);
            vistaGestionAcademica.updateTable();
            this.vistaEducacionModificar.dispose();
        }
    }
}
