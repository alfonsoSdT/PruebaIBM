package programa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement ;

public class Prueba {
	public static void main(String args[]) throws SQLException, IOException{
		/* Conectamos a la base de datos y recibimos parametro */
		String login_ = "admin" ;
		String password_ = "adminpassword" ;
		String url_ = "jdbc:mysql://localhost:3306/mydb";
		
		Connection con = ConectarABDD(login_,password_,url_);
		
		String parametro = args[0];
		
		/*Preparamos el fichero y el statement */
		
		Statement st = con.createStatement();
		FileWriter fichero = new FileWriter("/home/alfon/Documentos/fichero.txt");
		PrintWriter pw = new PrintWriter(fichero);
		
		
		/* Ejecutamos la query sobre la base de datos */
		
		String query = "SELECT id_cliente,id_proveedor,nombre, DATE_FORMAT(fechaDeAlta, \"%d/%m/%Y\") as fechaDeAlta FROM proveedores WHERE id_cliente = " + parametro;
		ResultSet rs = st.executeQuery(query);

		/* Si el codigo no tiene registros, muestra por consola que el cliente no tiene proveedores asignados */

		if(rs.next() == false) {
			System.out.println("El cliente no dispone de proveedores asignados.");
		}
		/* Si si tiene registros, lo escribimos en el fichero */
		else {
			pw.println("Proveedores:");
			
			/* Como hemos hecho ya el next, registramos en el fichero el primer proveedor */
			
			int id_proveedor = rs.getInt("id_proveedor");
			String nombre = rs.getString("nombre");
			String fechaDeAlta = rs.getString("fechaDeAlta");
			int id_cliente = rs.getInt("id_cliente");

			pw.println(id_proveedor + ", " + nombre + ", " + fechaDeAlta +", " + id_cliente);
			
			/* Si hay mas, los guardamos en el fichero */
			while (rs.next()) {
				id_proveedor = rs.getInt("id_proveedor");
				nombre = rs.getString("nombre");
				fechaDeAlta = rs.getString("fechaDeAlta");
				id_cliente = rs.getInt("id_cliente");
				//System.out.println(id_proveedor + ", " + nombre + ", " + fechaDeAlta +", " + id_cliente);
				pw.println(id_proveedor + ", " + nombre + ", " + fechaDeAlta +", " + id_cliente);
			}
			/* Una vez terminado, cerramos el fichero y el printWriter */
			
			fichero.close();
			pw.close();
		}
	}
	/* Metodo auxiliar para conectar con la base de datos. 
	 * Parametros: String login, password, url.
	 * Devuelve: Connection 
	 * */
	private static Connection ConectarABDD(String login_, String password_, String url_) {
		Connection connection_ = null;
		try {
			Class.forName ( "com.mysql.cj.jdbc.Driver" ) ;
			connection_ = DriverManager.getConnection(url_ ,login_,password_) ;
			if ( connection_ != null ) {
				//System . out . println ( "Conexion a base de datos correcta . " ) ;
			}
			else {
				System . out . println ( "Fallo en la conexion." ) ;
			}

		} catch ( SQLException e ) { 
			e . printStackTrace () ;
		}catch ( ClassNotFoundException e ) { 
			e . printStackTrace () ;
		}
		catch ( Exception e ) { 
			e . printStackTrace () ;
		}
		
		return connection_;
	}
}
