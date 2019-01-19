package modelos;

import principal.BD;

public class Educacion {
    private int id;
    private String nombre;
    private String apellidos;
    private double notaMedia;
    private String curso;
    private String fecha;
    private String observaciones;

    

    public Educacion(int id, String fecha, double notaMedia, String nombre, String apellidos, String curso, String observaciones)
    {
        this.id = id;
        this.nombre = nombre;
        this.notaMedia = notaMedia;
        this.apellidos = apellidos;
        this.curso = curso;
        this.fecha = fecha;
        this.observaciones = observaciones;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    public String getNotaMedia() {
        return Double.toString(notaMedia);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    public String getFechaNacimiento(){
        return fecha;
    }

    public String getObservaciones(){
        return observaciones;
    }

    public int getId() {
        return id;
    }

}