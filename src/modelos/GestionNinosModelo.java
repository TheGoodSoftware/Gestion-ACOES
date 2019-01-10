package modelos;

import java.util.Random;

import principal.BD;

public class GestionNinosModelo {

	public void insertarNino(String nombre, String edad, String sexo, String identidad, Boolean ccj, String colegio,
			Boolean becado) {
		BD bd = new BD();
		Random rnd = new Random();
		String[] nombreYApellidos = nombre.split(" ");
		String apellidos = "";
		for(int i = 1;i<nombreYApellidos.length;i++) {
			apellidos+= nombreYApellidos[i]+" ";
		}
		Nino ninio = new Nino(rnd.nextInt(2000), nombreYApellidos[0],apellidos, "Calle Bolin", "San Pedro", Integer.parseInt(edad), null);
		bd.insertarNinoBaseDeDatos(ninio);
		
	}

	public void modificarNino(String id, String nombre, String edad, String sexo, String identidad, Boolean ccj, String colegio,
			Boolean becado) {
		BD bd = new BD();
		Random rnd = new Random();
		String[] nombreYApellidos = nombre.split(" ");
		String apellidos = "";
		for(int i = 1;i<nombreYApellidos.length;i++) {
			apellidos+= nombreYApellidos[i]+" ";
		}
		Nino ninio = new Nino(Integer.parseInt(id), nombreYApellidos[0],apellidos, "Calle Bolin", "San Pedro", Integer.parseInt(edad), null);
		bd.modificarNinoBaseDeDatos(ninio);
		
	}

}
