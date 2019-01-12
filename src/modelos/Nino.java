package modelos;
import java.util.Map;

public class Nino extends Persona {

    private String fechaNacimiento;
   private String sexo;
   private int proyecto;
   private String fechaAlta;
   private String fechaAltaACOES;
   private String fechaSalidaACOES;
   private String fechaAltaProyecto;
   private String fechaSalidaProyecto;
   private String observaciones;
   private String NIF;
    private Map<String, Integer> notas;

    public Nino(int id, String nombre, String apellido, String direccion, String pueblo, String fechaNacimiento, Map<String, Integer> notas, String sexo, int proyecto, String fechaAlta, String fechaAltaACOES, String fechaSalidaACOES, String fechaAltaProyecto, String fechaSalidaProyecto, String observaciones, String NIF)
    {
        super(id, nombre, apellido, direccion, pueblo);
        this.fechaNacimiento = fechaNacimiento;
        this.notas = notas;
        this.sexo = sexo;
        this.proyecto = proyecto;
        this.fechaAlta = fechaAlta;
        this.fechaAltaACOES = fechaAltaACOES;
        this.fechaSalidaACOES = fechaSalidaACOES;
        this.fechaAltaProyecto = fechaAltaProyecto;
        this.fechaSalidaProyecto = fechaSalidaProyecto;
        this.observaciones = observaciones;
        this.NIF = NIF;
    }

    public String getSexo() {
		return sexo;
	}
    public String getObservaciones() {
  		return observaciones;
  	}
    
    public String getNIF() {
  		return NIF;
  	}

	public int getProyecto() {
		return proyecto;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public String getFechaAltaACOES() {
		return fechaAltaACOES;
	}

	public String getFechaSalidaACOES() {
		return fechaSalidaACOES;
	}

	public String getFechaAltaProyecto() {
		return fechaAltaProyecto;
	}

	public String getFechaSalidaProyecto() {
		return fechaSalidaProyecto;
	}

	public String getfechaNacimiento() {
        return fechaNacimiento;
    }

    public Map<String, Integer> getNotas() {
        return notas;
    }
}
