package modelos;

import java.util.Map;
import java.util.Random;

import principal.BD;

public class GestionNinosModelo {

	public void insertarNino(String nombre, String apellido, String direccion, String pueblo, String fechaNacimiento, String sexo, int proyecto, String fechaAlta, String fechaAltaACOES, String fechaSalidaACOES, String fechaAltaProyecto, String fechaSalidaProyecto, String observaciones, String NIF
	  ) {
		BD bd = new BD();
		
		Nino ninio = new Nino(0, nombre, apellido, direccion, pueblo,fechaNacimiento,null, sexo, proyecto, fechaAlta, fechaAltaACOES, fechaSalidaACOES, fechaAltaProyecto, fechaSalidaProyecto, observaciones, NIF);
		bd.insertarNinoBaseDeDatos(ninio);
		
	}

	public void modificarNino(String nombre, String apellido, String direccion, String pueblo, String fechaNacimiento, String sexo, int proyecto, String fechaAlta, String fechaAltaACOES, String fechaSalidaACOES, String fechaAltaProyecto, String fechaSalidaProyecto, String observaciones, String NIF
			  ) {
				BD bd = new BD();
				
				Nino ninio = new Nino(0, nombre, apellido, direccion, pueblo,fechaNacimiento,null, sexo, proyecto, fechaAlta, fechaAltaACOES, fechaSalidaACOES, fechaAltaProyecto, fechaSalidaProyecto, observaciones, NIF);
				bd.modificarNinoBaseDeDatos(ninio);
				
			}

}
