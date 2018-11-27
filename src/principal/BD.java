package principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.*;

public class BD {

	
	
    private final String CONNECTION_URL = "jdbc:mysql://localhost:3306/gestionacoes";
    private final String CONNECTION_Usuario = "ACOES";
    private final String CONNECTION_PASSWD = "GESTIONACOES";
    private Connection con;
	
	public BD()
	{
		 try {
	            con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_Usuario, CONNECTION_PASSWD);
	        } catch (SQLException e) {
	            System.err.println("ERROR. Trying to create database connection");
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
	 public ArrayList<Usuario> getSocios()
	    {
	        ArrayList<Usuario> socios = new ArrayList<>();
	        try {
	            Statement statement = con.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM USUARIO U JOIN ROL R ON U.rol = R.nombre");
	            while(rs.next()) {
	                socios.add(new Usuario(
	                        rs.getString("nombre"),
	                        rs.getString("apellidos"),
	                        rs.getString("direccion"),
	                        rs.getString("pueblo"),
	                        rs.getString("e_mail"),
	                        new Rol(
	                                rs.getString("nombre"),
	                                rs.getString("pais"),
	                                rs.getString("descripcion")
	                        )));
	            }
	        } catch (SQLException e) {
	            System.err.println("ERROR. Trying to get 'socios' from database");
	        }
	        return socios;
	    }

	    //public Usuario getSocio(String e_mail, String passwd)
	    //check passwd.equals(rs.getString("passwd"))
	    //otherwise don't create Usuario entity, throw an error

	    public void endConnection()
	    {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            System.err.println("ERROR. Trying to close database connection");
	        }
	    }
}
