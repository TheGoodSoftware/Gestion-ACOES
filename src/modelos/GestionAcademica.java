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
            Object[] values = new Object[7];
            values[0] = this.getEducacions().get(i).getId();
            values[1] = this.getEducacions().get(i).getNombre();
            values[2] = this.getEducacions().get(i).getApellidos();
            values[3] = this.getEducacions().get(i).getFechaNacimiento();
            values[4] = this.getEducacions().get(i).getCurso();
            values[5] = this.getEducacions().get(i).getNotaMedia();
            values[6] = this.getEducacions().get(i).getObservaciones();
            valores[i] = values;
        }
        return valores;
    }

    public static Object[][] EducacionArraytoObjectArray(Educacion[] Educacion) {
        Object[][] valores = new Object[Educacion.length][7];
        for(int i = 0; i < Educacion.length; i++) {
            Object[] values = new Object[7];
            values[0] = Educacion[i].getId();
            values[1] = Educacion[i].getNombre();
            values[2] = Educacion[i].getApellidos();
            values[3] = Educacion[i].getFechaNacimiento();
            values[4] = Educacion[i].getCurso();
            values[5] = Educacion[i].getNotaMedia();
            values[6] = Educacion[i].getObservaciones();
            valores[i] = values;
        }
        return valores;
    }

    public String[] getAllFechas() {
        ArrayList<String> fechas = new ArrayList<>();
        fechas.add("-");

        for(int i = 0; i < academica.size(); i++)
        {
            String[] dateValues = academica.get(i).getFechaNacimiento().split("/");
            String fechaTemp = dateValues[1] + "/" + dateValues[2];
            if(!fechas.contains(fechaTemp))
                fechas.add(fechaTemp);
        }

        return fechas.toArray(new String[fechas.size()]);
    }
}