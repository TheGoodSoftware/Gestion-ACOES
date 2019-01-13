package modelos;

import principal.BD;

public class GestionNinosModelo {

	public void insertarNino(String nombre, String apellido, String direccion, String pueblo, String fechaNacimiento, String sexo, int proyecto, String fechaAlta, String fechaAltaACOES, String fechaSalidaACOES, String fechaAltaProyecto, String fechaSalidaProyecto, String observaciones, String NIF
	  ) {
		BD bd = new BD();
		Nino ninio = new Nino(bd.getMaxIDNino(), nombre, apellido, direccion, pueblo,fechaNacimiento,null, sexo, proyecto, fechaAlta, fechaAltaACOES, fechaSalidaACOES, fechaAltaProyecto, fechaSalidaProyecto, observaciones, NIF);
		bd.insertarNinoBaseDeDatos(ninio);
		
	}

	public void modificarNino(int id,String nombre, String apellido, String direccion, String pueblo, String fechaNacimiento, String sexo, int proyecto, String fechaAlta, String fechaAltaACOES, String fechaSalidaACOES, String fechaAltaProyecto, String fechaSalidaProyecto, String observaciones, String NIF
			  ) {
				BD bd = new BD();
				
				Nino ninio = new Nino(id, nombre, apellido, direccion, pueblo,fechaNacimiento,null, sexo, proyecto, fechaAlta, fechaAltaACOES, fechaSalidaACOES, fechaAltaProyecto, fechaSalidaProyecto, observaciones, NIF);
				bd.modificarNinoBaseDeDatos(ninio);
				
			}

}
