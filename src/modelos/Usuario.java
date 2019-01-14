package modelos;

import java.util.ArrayList;
import java.util.List;

import principal.BD;

public class Usuario extends Persona {
    private String e_mail;
    private String asociacion;
    private Rol role;
    private ArrayList<Nino> apadrinados;

    // Temporalmente creo los dos constructores hasta que las consultas de la BBDD etc. se adapten al constructor de abajo
    public Usuario(int id, String nombre, String apellidos, String direccion, String pueblo, String e_mail,  ArrayList<Nino> apadrinados, Rol role, String asociacion) {
        super(id, nombre, apellidos, direccion, pueblo);
        this.e_mail = e_mail;
        this.role = role;
        this.apadrinados = apadrinados;
        this.asociacion = asociacion;
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
    
    public String getAsociacion() {
    	return asociacion;
    }
}
