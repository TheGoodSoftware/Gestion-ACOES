package modelos;

public class Rol {

    private String nombre, pais, descripcion;

    public Rol(String nombre, String pais, String descripcion)
    {
        this.nombre = nombre;
        this.pais = pais;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }
}
