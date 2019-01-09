package modelos;
import java.util.Map;

public class Nino extends Persona {

    private int edad;
    private Map<String, Integer> notas;

    public Nino(int id, String nombre, String apellido, String direccion, String pueblo, int edad, Map<String, Integer> notas)
    {
        super(id, nombre, apellido, direccion, pueblo);
        this.edad = edad;
        this.notas = notas;
    }

    public int getEdad() {
        return edad;
    }

    public Map<String, Integer> getNotas() {
        return notas;
    }
}
