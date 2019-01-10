package modelos;

import java.util.ArrayList;

public class GestionAcademica {
    private int id;
    private double notaMedia;
    private ArrayList<Educacion> academica;

    public GestionAcademica(int id) {
        this.id = id;
        academica = new ArrayList<Educacion>();
    }

    public void setEducacion(ArrayList<Educacion> academica) {
        this.academica = academica;
    }

    public ArrayList<Educacion> getEducacions() {
        return this.academica;
    }

    public int getID() {
        return this.id;
    }

    public Object[][] toObjectArray() {
        Object[][] valores = new Object[this.getEducacions().size()][7];
        for(int i = 0; i < this.getEducacions().size(); i++) {
            Object[] values = new Object[6];
            values[0] = this.getEducacions().get(i).getId();
            values[1] = this.getEducacions().get(i).getNombre();
            values[2] = this.getEducacions().get(i).getApellidos();
            values[3] = this.getEducacions().get(i).getEdad();
            values[4] = this.getEducacions().get(i).getCurso();
            values[5] = this.getEducacions().get(i).getNotaMedia();
            valores[i] = values;
        }
        return valores;
    }

    public static Object[][] EducacionArraytoObjectArray(Educacion[] Educacion) {
        Object[][] valores = new Object[Educacion.length][7];
        for(int i = 0; i < Educacion.length; i++) {
            Object[] values = new Object[6];
            values[0] = Educacion[i].getId();
            values[1] = Educacion[i].getNombre();
            values[2] = Educacion[i].getApellidos();
            values[3] = Educacion[i].getEdad();
            values[4] = Educacion[i].getCurso();
            values[5] = Educacion[i].getNotaMedia();
            valores[i] = values;
        }
        return valores;
    }
}