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
    private AnyadirEducacionVista AnyadirEducacionVista;
    private GestionAcademicaVista vistaGestionAcademica;

    public AnyadirEducacionControlador(GestionAcademicaVista vistaGestionAcademica, AnyadirEducacionVista vistaEducacion, GestionAcademica modelo) {
        this.vistaGestionAcademica = vistaGestionAcademica;
        this.AnyadirEducacionVista = vistaEducacion;
        this.modelo = modelo;
        this.AnyadirEducacionVista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CANCELAR"))
        {
            this.AnyadirEducacionVista.dispose();
        } else if(e.getActionCommand().equals("ANYADIR")) {
            ArrayList<Object> values = AnyadirEducacionVista.getData();
            int educacionID = -1;

            for(int i = 0; i < modelo.getEducacions().size(); i++)
            {
                if(modelo.getEducacions().get(i).getId() > educacionID)
                    educacionID = modelo.getEducacions().get(i).getId();
            }

            educacionID++;
/*
            try {
                Educacion educacion = new Educacion(educacionID, Integer.parseInt(values.get(0).toString()), Double.parseDouble(values.get(1).toString()), (String)values.get(2),
                        (String)values.get(3), (Nino)values.get(4), modelo, (String)values.get(5));
                modelo.getEducacions().add(educacion);
                new BD().insertEducacion(educacion);
            } catch (NumberFormatException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            vistaGestionAcademica.updateTable();
            this.AnyadirEducacionVista.dispose();*/
        }
    }

}
