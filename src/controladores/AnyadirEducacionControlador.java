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
            ArrayList<Object> values = vistaEducacionAnyadir.getData();
            int educacionID = -1;

            for(int i = 0; i < modelo.getEducacions().size(); i++)
            {
                if(modelo.getEducacions().get(i).getId() > educacionID)
                    educacionID = modelo.getEducacions().get(i).getId();
            }

            educacionID++;

            try {
                Educacion educacion = new Educacion(educacionID, (String)values.get(0), Double.parseDouble(values.get(1).toString()), (String)values.get(2),
                        (String)values.get(3), (String)values.get(4),(String)values.get(5));
                modelo.getEducacions().add(educacion);
                new BD().insertarEducacion(educacion);
            } catch (NumberFormatException e1) {

                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            vistaGestionAcademica.updateTable();
            this.vistaEducacionAnyadir.dispose();
        }
    }

}
