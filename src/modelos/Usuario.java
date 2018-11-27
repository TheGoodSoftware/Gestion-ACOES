package modelos;

import java.util.ArrayList;

public class Usuario extends Persona {

    private String e_mail;
    private Rol role;
    private ArrayList<Nino> apadrinados;

    public Usuario(String nombre, String apellidos, String direccion, String pueblo, String e_mail,  ArrayList<Nino> apadrinados, Rol role) {
        super(nombre, apellidos, direccion, pueblo);
        this.e_mail = e_mail;
        this.role = role;
        this.apadrinados = apadrinados;
    }

    public Rol getRole() {
        return role;
    }

    public String getE_mail() {
        return e_mail;
    }

    public ArrayList<Nino> getApadrinados() {
        return apadrinados;
    }
}
