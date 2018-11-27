package modelos;

public class Usuario extends Persona {

    private String e_mail;
    private Rol role;

    public Usuario(String nombre, String apellidos, String direccion, String pueblo, String e_mail, Rol role) {
        super(nombre, apellidos, direccion, pueblo);
        this.e_mail = e_mail;
        this.role = role;
    }

    public Rol getRole() {
        return role;
    }

    public String getE_mail() {
        return e_mail;
    }
}
