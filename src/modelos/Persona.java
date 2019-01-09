package modelos;

public class Persona {

    private String nombre, apellidos, direccion, pueblo;
    private int id;

    public Persona(int id, String nombre, String apellidos, String direccion, String pueblo) {
    	this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.pueblo = pueblo;
    }
    
    public int getID() {
    	return id;
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
    
    public String getNombreCompleto() {
    	return nombre + " " + apellidos;
    }
}
