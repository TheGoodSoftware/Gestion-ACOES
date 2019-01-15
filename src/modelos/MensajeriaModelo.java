package modelos;

import java.sql.SQLException;

import principal.BD;

public class MensajeriaModelo {

	public boolean recepcion(int numSeg, String fecha) {
		// TODO Auto-generated method stub
		BD miBD = new BD();
		try {
			miBD.confirmarPaquete(numSeg, fecha);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean envio(int numSeg, String fecha, int idUsuario, int idNino, String descripcion) {
		BD miBD = new BD();
		System.out.println(idNino);
		try {
			miBD.insertarPaquete(numSeg, fecha, idUsuario, idNino, descripcion);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

}
