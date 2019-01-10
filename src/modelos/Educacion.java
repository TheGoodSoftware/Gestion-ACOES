package modelos;

import principal.BD;

public class Educacion {
    private int id;
    private String nombre;
    private String apellidos;
    private double notaMedia;
    private String curso;
    private Nino nino;
    private int edad;
    private GestionAcademica gestion;
    

    public Educacion(int id, int edad, double notaMedia, String nombre, String apellidos, Nino nino, GestionAcademica gestion, String curso)
    {
        this.id = id;
        this.nombre = nombre;
        this.notaMedia = notaMedia;
        this.apellidos = apellidos;
        this.gestion = gestion;
        this.nino = nino;
        this.curso = curso;
        this.edad = edad;

    }

    public Nino getNino() {
        return nino;
    }

    public GestionAcademica getGestion() {
        return gestion;
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

    public int getEdad(){
        return edad;
    }

    public int getId() {
        return id;
    }

}