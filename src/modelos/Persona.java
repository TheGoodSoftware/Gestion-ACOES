package modelos;

public class Persona {

    private String nombre, apellidos, direccion, pueblo;

    public Persona(String nombre, String apellidos, String direccion, String pueblo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.pueblo = pueblo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPueblo() {
        return pueblo;
    }
}
