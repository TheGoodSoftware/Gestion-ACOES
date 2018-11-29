package principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import modelos.*;

public class BD {

    private final String CONNECTION_URL = "jdbc:mysql://localhost:3306/mydb";
    private final String CONNECTION_Usuario = "ACOES";
    private final String CONNECTION_PASSWD = "GESTIONACOES";
    private Connection con;
	
	public BD()
	{
		 try {
	            con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_Usuario, CONNECTION_PASSWD);
	        } catch (SQLException e) {
	            System.err.println("ERROR. Trying to create database connection" + e.getMessage());
	        }
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
	
	public Object SelectEscalar(String sel)
	{
		ResultSet rset;
		Object res = null;
		try
		{
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(sel);
			rset.next();
			res = rset.getObject(1);
			rset.close();
			stmt.close();
		}
		catch (SQLException ex)
		{
			throw new Error("Error en el SELECT: " + sel + ". " + ex.getMessage());
		}		
		
		return res;
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
	
	public void Insert(String ins)
	{
		try
		{
			Statement stmt = con.createStatement();
			stmt.execute(ins);
			stmt.close();
		}
		catch (SQLException ex)
		{
			throw new Error("Error en el INSERT: " + ins+ ". " + ex.getMessage());
		}
	}

	public void Delete(String del)
	{
		try
		{
			Statement stmt = con.createStatement();
			stmt.execute(del);
			stmt.close();
		}
		catch (SQLException ex)
		{
			throw new Error("Error en el DELETE: " + del+ ". " + ex.getMessage());
		}
	}

	public void Update(String up)
	{
		try
		{
			Statement stmt = con.createStatement();
			stmt.execute(up);
			stmt.close();
		}
		catch (SQLException ex)
		{
			throw new Error("Error en el UPDATE: " + up+ ". " + ex.getMessage());
		}
	}

	public Usuario getSocio(String e_mail) {
		try
		{
			Usuario u = null;
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM USUARIO JOIN PERSONA ON USUARIO.idUsuario = PERSONA.idPersona");
			if(result.next()) {
				u = new Usuario(
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

	public Rol getRol(String e_mail) {
		try
		{
			Rol r = null;
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM USUARIO JOIN ROL ON USUARIO.ROL_idRol = ROL.idRol WHERE Correo = '" + e_mail + "'");
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
			ResultSet result = stmt.executeQuery("SELECT * FROM APADRINAR JOIN NINO ON APADRINAR.NINO_idNen = NINO.idNen JOIN USUARIO ON APADRINAR.USUARIO_idUsuario = USUARIO.idUsuario JOIN PERSONA P on NINO.idNen = P.idPersona WHERE Correo = '" + e_mail + "'");

			Map<String, Integer> notas = new TreeMap<>();
			Random rnd = new Random();
			notas.put("1Primaria", rnd.nextInt(10) + 1);
			notas.put("2Primaria", rnd.nextInt(10) + 1);

			while(result.next()) {
				apadrinados.add(new Nino(
						result.getString("Nombre"),
						result.getString("Apellidos"),
						result.getString("Direccion"),
						result.getString("Pueblo"),
						result.getInt("Edad"),
						notas
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
			ResultSet result = stmt.executeQuery("SELECT * FROM ROL");

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
	
	public void endConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
			System.err.println("ERROR. Trying to close database connection");
		}
	}
}
