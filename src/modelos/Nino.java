package modelos;

import java.util.ArrayList;

public class Nino extends Persona {

    private int edad;
    private ArrayList<Integer> notas;

    public Nino(String nombre, String apellido, String direccion, String pueblo, int edad, ArrayList<Integer> notas)
    {
        super(nombre, apellido, direccion, pueblo);
        this.edad = edad;
        this.notas = notas;
    }

    public int getEdad() {
        return edad;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }
}
