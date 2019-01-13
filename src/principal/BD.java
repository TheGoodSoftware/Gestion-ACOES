package principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

// import com.sun.corba.se.spi.orbutil.fsm.State;

import modelos.*;

public class BD {

    private final String CONNECTION_URL = "jdbc:mysql://localhost:3306/mydb";
    private final String CONNECTION_Usuario = "ACOES";
    private final String CONNECTION_PASSWD = "GESTIONACOES";
    private static Connection con;
	
	public BD()
	{
		 try {
	            con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_Usuario, CONNECTION_PASSWD);
	        } catch (SQLException e) {
	            System.err.println("ERROR. Trying to create database connection" + e.getMessage());
	        }
	}

	public List<Object[]> Select(String sel)
	{
		ResultSet rset;
		List<Object[]> lista = new ArrayList<Object[]>();
		try
		{
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(sel);
			ResultSetMetaData meta = rset.getMetaData();
			int numCol = meta.getColumnCount();
			while (rset.next())
			{
				Object[] tupla = new Object[numCol];
				for(int i=0; i<numCol;++i)
				{
					tupla[i] = rset.getObject(i+1);
				}
				lista.add(tupla);
			}
			rset.close();
			stmt.close();
		}
		catch (SQLException ex)
		{
			throw new Error("Error en el SELECT: " + sel+ ". " + ex.getMessage());
		}

		return lista;
	}

	
	protected void finalize () 
	{
		try
		{
			if (con!=null)  con.close();
		}
		catch (SQLException ex)
		{
			throw new Error("Error al Cerrar la Conexión." + ex.getMessage());
		}
    }
	
	public void insertEconomia(Economia e) {
		try {
			Statement stmt = con.createStatement();
			String nombreTabla, nombreId;
			if(e.getTipo().equalsIgnoreCase("GASTO")) {
				nombreTabla = "gasto";
				nombreId = "idGasto";
			} else {
				nombreTabla = "donacion";
				nombreId = "idDon";
			}
				
			stmt.execute("INSERT INTO " + nombreTabla + " VALUES (" + e.getId() + "," + e.getCantidad() + ",'" + e.getMoneda() + "','" + e.getDescripcion() + "','" + e.getFecha() + "','" + e.getBeneficiarioProcedencia() + "'," + e.getGestion().getID() + ")");
			stmt.close();
		} catch (SQLException sqlEx) {
			throw new Error("ERROR. Trying to insert economia -> " + sqlEx.getMessage());
		}
	}
	
	public void eliminarEconomia(int id, String tipo) {
		try {
			Statement stmt = con.createStatement();
			String nombreTabla, nombreId;
			if(tipo.equalsIgnoreCase("GASTO")) {
				nombreTabla = "gasto";
				nombreId = "idGasto";
			} else {
				nombreTabla = "donacion";
				nombreId = "idDon";
			}
				
			stmt.execute("DELETE FROM " + nombreTabla + " WHERE " + nombreId + " = " + id);
			stmt.close();
		} catch (SQLException sqlEx) {
			throw new Error("ERROR. Trying to delete economia -> " + sqlEx.getMessage());
		}
	}

	/*public void insertEducacion(Educacion e) {
		try {
			Statement stmt = con.createStatement();
			String nombreTabla = "Expediente";

			stmt.execute("INSERT INTO " + nombreTabla + " VALUES (" + e.getId() + "," + e.getEdad() + ",'" + e.getNotaMedia() + "','" + e.getNombre() + "'," + e.getApellidos() + "," + e.getNino().getID() + "," + e.getGestion().getID() + "," + e.getCurso() + ")");
			stmt.close();
		} catch (SQLException sqlEx) {
			throw new Error("ERROR. Trying to insert educacion -> " + sqlEx.getMessage());
		}
	}*/

	public Usuario getSocio(String e_mail) {
		try
		{
			Usuario u = null;
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM usuario JOIN persona ON usuario.idUsuario = persona.idPersona where Correo = '"+e_mail+"'");
			if(result.next()) {
				u = new Usuario(
						result.getInt("idUsuario"),
						result.getString("Nombre"),
						result.getString("Apellidos"),
						result.getString("Direccion"),
						result.getString("Pueblo"),
						e_mail,
						getApadrinados(e_mail),
						getRol(e_mail)
				);
			}
			result.close();
			stmt.close();
			return u;
		}
		catch (SQLException ex)
		{
			throw new Error("ERROR. Trying to getSocio -> " + ex.getMessage());
		}
	}
	
	public Usuario getSocio(int id) throws SQLException {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT Correo FROM usuario JOIN persona ON usuario.idUsuario = persona.idPersona where idUsuario = "+id);
			if(result.next()) {
				String e_mail = result.getString("Correo");
				result.close();
				return getSocio(e_mail);
			}
			stmt.close();
			return null;
	}
	
	public List<Nino> getAllNinos() {
		try {
		List<Nino> ninios = new ArrayList<>();
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("SELECT * FROM nino JOIN persona ON nino.idNen = persona.idPersona");
		Map<String, Integer> notas = new TreeMap<>();
		while(result.next()) {
		
				ninios.add(new Nino(
						result.getInt("idNen"),
						result.getString("Nombre"),
						result.getString("Apellidos"),
						result.getString("Direccion"),
						result.getString("Pueblo"),
						result.getString("fechaNacimiento"),
						notas,
						result.getString("sexo"),
						result.getInt("PROYECTO_idProy"),
						result.getString("fechaAlta"),
						result.getString("fechaAltaACOES"),
						result.getString("fechaSalidaACOES"),
						result.getString("fechaAltaProyecto"),
						result.getString("fechaSalidaProyecto"),
						result.getString("observaciones"),
						result.getString("NIF")
				));
		}
				stmt.close();
				result.close();
				return ninios;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		
		
		
	}
	
	public Nino getNino(int id) throws SQLException{
		try {
		Nino nino = null;
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("SELECT nino.idNen FROM nino JOIN persona ON nino.idNen = persona.idPersona where idNen = "+id);
		Map<String, Integer> notas = new TreeMap<>();
		nino = new Nino(
				result.getInt("idNen"),
				result.getString("Nombre"),
				result.getString("Apellidos"),
				result.getString("Direccion"),
				result.getString("Pueblo"),
				result.getString("fechaNacimiento"),
				notas,
				result.getString("sexo"),
				result.getInt("PROYECTO_idProy"),
				result.getString("fechaAlta"),
				result.getString("fechaAltaACOES"),
				result.getString("fechaSalidaACOES"),
				result.getString("fechaAltaProyecto"),
				result.getString("fechaSalidaProyecto"),
				result.getString("observaciones"),
				result.getString("NIF")
		);
		return nino;
		}
		catch (SQLException ex)
		{
			throw new Error("ERROR. Trying to get Ninos + -> Msg: "+ex);
		}
	}
	
	public int getMaxIDNino() {
		try {
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("SELECT MAX(idPersona) as id FROM persona");
		
		if(result.next()) {
		return result.getInt("id")+1;
		}
		stmt.close();
		result.close();
		}catch(SQLException ex) {
			throw new Error("ERROR. Trying to get max id from Ninos + -> Msg: "+ex);
		}
		return -1;
	}
	
	

	public Rol getRol(String e_mail) {
		try
		{
			Rol r = null;
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM usuario JOIN rol ON usuario.rol_idRol = rol.idRol WHERE Correo = '" + e_mail + "'");
			if(result.next()) {
				r = new Rol(
						result.getString("Nombre"),
						result.getString("Pais"),
						result.getString("Descripcion")
				);
			}
			stmt.close();
			return r;
		}
		catch (SQLException ex)
		{
			throw new Error("ERROR. Trying to get Apadrinados");
		}
	}

	public ArrayList<Nino> getApadrinados(String e_mail) {
		try
		{
			Statement stmt = con.createStatement();
			ArrayList<Nino> apadrinados = new ArrayList<>();
			ResultSet result = stmt.executeQuery("SELECT * FROM apadrinar JOIN nino ON apadrinar.nino_idNen = nino.idNen JOIN usuario ON apadrinar.usuario_idUsuario = usuario.idUsuario JOIN persona P on nino.idNen = P.idPersona WHERE Correo = '" + e_mail + "'");

			Map<String, Integer> notas = new TreeMap<>();
			Random rnd = new Random();
			notas.put("1Primaria", rnd.nextInt(10) + 1);
			notas.put("2Primaria", rnd.nextInt(10) + 1);

			while(result.next()) {
				apadrinados.add(new Nino(
						result.getInt("idNen"),
						result.getString("Nombre"),
						result.getString("Apellidos"),
						result.getString("Direccion"),
						result.getString("Pueblo"),
						result.getString("fechaNacimiento"),
						notas,
						result.getString("sexo"),
						result.getInt("PROYECTO_idProy"),
						result.getString("fechaAlta"),
						result.getString("fechaAltaACOES"),
						result.getString("fechaSalidaACOES"),
						result.getString("fechaAltaProyecto"),
						result.getString("fechaSalidaProyecto"),
						result.getString("observaciones"),
						result.getString("NIF")
				));
			}
			stmt.close();

			return apadrinados;
		}
		catch (SQLException ex)
		{
			throw new Error("ERROR. Trying to get Apadrinados -> " + ex.getMessage());
		}
	}
	
	public ArrayList<Rol> getAllRoles() {
		try
		{
			Statement stmt = con.createStatement();
			ArrayList<Rol> roles = new ArrayList<>();
			ResultSet result = stmt.executeQuery("SELECT * FROM rol");

			while(result.next()) {
				roles.add(new Rol(
						result.getString("Nombre"),
						result.getString("Pais"),
						result.getString("Descripcion")
						));
			}
			stmt.close();

			return roles;
		}
		catch (SQLException ex)
		{
			throw new Error("ERROR. Trying to get Roles -> " + ex.getMessage());
		}
	}
	
	public Map<Integer, String> getAllProyectos() {
		try
		{
			Statement stmt = con.createStatement();
			Map<Integer, String> proyectos = new TreeMap<>();
			ResultSet result = stmt.executeQuery("SELECT * FROM proyecto");

			while(result.next()) {
				proyectos.put(result.getInt("idProy"), result.getString("Descripcion"));
				
			}
			stmt.close();

			return proyectos;
		}
		catch (SQLException ex)
		{
			throw new Error("ERROR. Trying to get Proyectos -> " + ex.getMessage());
		}
	}

	public void insertarUsuarioBaseDeDatos(Usuario u, String password) {
		try {
			Statement stmt = con.createStatement();
			
			stmt.execute("INSERT INTO persona(Nombre, Apellidos) VALUES ('"
					+ u.getNombre() + "','" + u.getApellidos() + "')");
			stmt.execute("INSERT INTO usuario(Contrasenya, Correo, rol_idRol, idUsuario) VALUES ('"
					+ password + "','" + u.getE_mail() + "'," + getRolIdDesdeNombre(u.getRole().getNombre()) +"',"+u.getID() +")");
			stmt.close();
		} catch (SQLException ex) {
			throw new Error("ERROR. Trying to insert Usuario into database -> " + ex.getMessage());
		}
		
	}
	
	public void insertarNinoBaseDeDatos(Nino n) {
		try {
			Statement stmt = con.createStatement();
			
			stmt.execute("INSERT INTO persona VALUES ("+n.getID()+",'"
					+ n.getNombre() + "','" + n.getApellidos() + "','"+n.getDireccion()+"','"+n.getPueblo()+"','Karruka')");
			stmt.execute("INSERT INTO nino VALUES ("+n.getID()+",'"+
					n.getfechaNacimiento() + "','" + n.getSexo() + "','" + n.getFechaAlta() +"','" + n.getFechaAltaACOES() +"','" + n.getFechaSalidaACOES() +"','" + n.getFechaAltaProyecto() +
					"','" + n.getFechaSalidaProyecto() +"','" + n.getObservaciones() +"'," + n.getProyecto() + ",'"+ n.getNIF() +   "')");
			stmt.close();
		} catch (SQLException ex) {
			throw new Error("ERROR. Trying to insert Ninio into database -> " + ex.getMessage());
		}
		
	}
	
	public void modificarNinoBaseDeDatos(Nino n) {
		try {
			Statement stmt = con.createStatement();
			
			stmt.execute("UPDATE persona JOIN nino ON nino.idNen=persona.idPersona SET Nombre='"+n.getNombre()+"',Apellidos='" + n.getApellidos()+"', fechaNacimiento='"+
			n.getfechaNacimiento()+"', sexo='"+n.getSexo()+"', fechaAlta='"+n.getFechaAlta()+"',fechaAltaACOES='"+n.getFechaAltaACOES()+"',fechaSalidaACOES='"+
			n.getFechaSalidaACOES()+"',fechaAltaProyecto='"+n.getFechaAltaProyecto()+"',fechaSalidaProyecto='"+n.getFechaSalidaProyecto()+"',observaciones='"+
			n.getObservaciones()+"',PROYECTO_idProy="+n.getProyecto()+",NIF='"+n.getNIF()+"' WHERE idNen="+n.getID());
			
			stmt.close();
		} catch (SQLException ex) {
			throw new Error("ERROR. Trying to update Usuario into database -> " + ex.getMessage());
		}
	}
	
	public void eliminarNinoBaseDeDatos(Integer id) throws SQLException {
		try {
		Statement stmt = con.createStatement();
		stmt.execute("DELETE FROM nino WHERE idNen="+id);
		stmt.execute("DELETE FROM persona WHERE idPersona="+id);
		stmt.close();
		
		
		}
		catch(SQLException ex) {
			throw new Error("ERROR. Trying to delete ninio from database -> " + ex.getMessage());
		}
	}
	
	

	public void modificarUsuarioBaseDeDatos(Usuario u, String password) {
		try {
			Statement stmt = con.createStatement();
			stmt.execute("UPDATE usuario JOIN persona ON usuario.idPersona=persona.idPersona SET Contrasenya='" + password + "', Correo='" + u.getE_mail()  + "', rol_idRol=" + getRolIdDesdeNombre(u.getRole().getNombre()) + "" +
					", Nombre='" + u.getNombre() + "', Apellidos='" + u.getApellidos() + "') WHERE Correo='" + u.getE_mail() + "';");
		} catch (SQLException ex) {
			throw new Error("ERROR. Trying to update Usuario into database -> " + ex.getMessage());
		}
	}

	public int getRolIdDesdeNombre(String nombreRol) {
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM rol WHERE Nombre = '" + nombreRol + "'");
			if(result.next()) {
				return result.getInt("idRol");
			}
			stmt.close();
			return -1;
		} catch (SQLException ex) {
			throw new Error("ERROR. Trying to insert Usuario into database -> " + ex.getMessage());
		}
	}

	public ArrayList<Usuario> getAllUsuarios() {
		try
		{
			Statement stmt = con.createStatement();
			ArrayList<Usuario> usuarios = new ArrayList<>();
			ResultSet result = stmt.executeQuery("SELECT * FROM usuario JOIN persona ON usuario.idUsuario = persona.idPersona");

			while(result.next()) {
				usuarios.add(
						new Usuario(
							result.getInt("idUsuario"),
							result.getString("Nombre"),
							result.getString("Apellidos"),
							"",
							"",
							result.getString("Correo"),
								new ArrayList<>(),
								getRol(result.getString("Correo"))
						)
				);
			}
			stmt.close();

			return usuarios;
		}
		catch (SQLException ex)
		{
			throw new Error("ERROR. Trying to get Apadrinados -> " + ex.getMessage());
		}
	}
	

	
	public GestionEconomica getEconomia() {
		try
		{
			Statement stmt = con.createStatement();
			ArrayList<Economia> economia = new ArrayList<>();
			ResultSet result = stmt.executeQuery("SELECT * FROM donacion JOIN gestionEconomica ON donacion.GESTIONECONOMICA_idBalance = gestionEconomica.idBalance");
			GestionEconomica gestion = null;
			
			while(result.next()) {
				gestion = new GestionEconomica(result.getInt("GESTIONECONOMICA_idBalance"));
				economia.add(
						new Economia(
								result.getInt("idDon"),
								result.getDouble("Cantidad"),
								result.getString("Moneda"),
								result.getString("Descripcion"),
								gestion,
								"Ingreso",
								result.getString("ProcedenciaBeneficiario"),
								result.getString("Fecha"),
								result.getBoolean("Aprobado")
								)
				);
			}
			
			result = stmt.executeQuery("SELECT * FROM gasto JOIN gestionEconomica ON "
					+ "gasto.GESTIONECONOMICA_idBalance = gestionEconomica.idBalance");

			while(result.next()) {
				if(gestion == null)
					gestion = new GestionEconomica(result.getInt("GESTIONECONOMICA_idBalance"));
				economia.add(
						new Economia(
								result.getInt("idGasto"),
								result.getDouble("Cantidad"),
								result.getString("Moneda"),
								result.getString("Descripcion"),
								gestion,
								"Gasto",
								result.getString("ProcedenciaBeneficiario"),
								result.getString("Fecha"),
								result.getBoolean("Aprobado")
								)
				);
			}
			stmt.close();

			gestion.setEconomia(economia);
			
			return gestion;
		}
		catch (SQLException ex)
		{
			throw new Error("ERROR. Trying to get Economia -> " + ex.getMessage());
		}
	}
/*
	public GestionAcademica getEducacion() {
		try
		{
			Statement stmt = con.createStatement();
			ArrayList<Educacion> educacion = new ArrayList<>();
			ResultSet result = stmt.executeQuery("SELECT * FROM nino JOIN persona  ON nino.idNen = persona.idPersona JOIN notas ON nino.idNen = notas.nino_idNen");
			GestionAcademica gestion = null;

			while(result.next()) {
				gestion = new GestionAcademica(result.getInt("GESTIONECONOMICA_idBalance"));
				educacion.add(
						new Educacion(
								result.getInt("idNen"),
								result.getInt("Edad"),
								result.getDouble("NotaMedia"),
								result.getString("Nombre"),
								result.getString("Apellidos"),
										null,
										null,
										result.getString("Curso"))

						);

			}

			result = stmt.executeQuery("SELECT * FROM nino JOIN persona  ON nino.idNen = persona.idPersona JOIN notas ON nino.idNen = notas.nino_idNen");


			stmt.close();

			gestion.setEducacion(educacion);

			return gestion;
		}
		catch (SQLException ex)
		{
			throw new Error("ERROR. Trying to get Economia -> " + ex.getMessage());
		}
	}
	*/
	public void endConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
			System.err.println("ERROR. Trying to close database connection");
		}
	}

	public List<Apadrinar> getApadrinamientos() {
		List<Apadrinar> lista = new ArrayList<Apadrinar>();
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM apadrinar");
			while(result.next()) {
				lista.add(new Apadrinar(
						result.getInt("USUARIO_idUsuario"),
						result.getInt("NINO_idNen"),
						result.getBoolean("Activo")
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR. Trying to get apadrinamientos");
		}
		
		return lista;
	}

	public void insertarApadrinamiento(int idPadrino, int idNino) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(idPadrino);
		System.out.println(idNino);

		Statement stmt = con.createStatement();
			
		stmt.execute("INSERT INTO apadrinar(NINO_idNen, USUARIO_idUsuario, Activo) VALUES("+
																							idNino+","+
																							idPadrino+","+
																							1+")");
		stmt.close();
	}

	public void activarApadrinamiento(int idPadrino, int idNino) {
		try {
			Statement stmt = con.createStatement();
			stmt.execute("UPDATE apadrinar SET Activo=1 where USUARIO_idUsuario="+idPadrino+" and NINO_idNen = "+idNino);
			stmt.close();
		} catch (SQLException e) {
			System.err.println("ERROR. Trying to activate apadrinamiento");
		}
	}
		
	
	public void borrarApadrinamiento(int idPadrino, int idNino) throws SQLException {
			Statement stmt = con.createStatement();
			stmt.execute("UPDATE apadrinar SET Activo=0 where USUARIO_idUsuario="+idPadrino+" and NINO_idNen = "+idNino);
			stmt.close();
	}
}
