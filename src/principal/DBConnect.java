package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class DBConnect {

	public void showDB(){
		try{
			Statement s = conexion();
			ResultSet rs = s.executeQuery("SELECT name, iduser, password from usuarios");
			while(rs.next()){
				System.out.println("Usuario: " + rs.getString(1));
				System.out.println("IDUser: " + rs.getString(2));
				System.out.println("Password: " + rs.getString(3));
				System.out.println("CUA: " + rs.getString(4));
				}
			rs.close();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String[] getUser(String usuario) throws SQLException{
		String datos[] = new String[4];
		Statement s = conexion();
		try{			
			ResultSet rs = s.executeQuery("SELECT * from usuarios where name ='"+usuario+"'");	
			while(rs.next()){
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				
				}
			rs.close();
			s.close();			
		}catch(Exception e){
			s.close();
			return datos;
		}		
		return datos;
	}
	
	public boolean cambioPassword(String usuario, String NewPass) throws SQLException{
		boolean cambio = false;
		java.sql.PreparedStatement ps;
		String query = "Update usuarios set password= ? where name= ?";
		try{
			String driver = "org.apache.derby.jdbc.EmbeddedDriver";			
			Class.forName(driver).newInstance();
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:derby:DBCarpeta");	
			ps = conn.prepareStatement(query);
			ps.setString(1, NewPass);
		    ps.setString(2, usuario);		     
		    ps.executeUpdate();					
			ps.close();
			cambio=true;
			return cambio;		
		}catch(Exception e){			
			return cambio;
		}
	}
	
	
	private Statement conexion(){
		Statement s = null;
		try{
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";			
		Class.forName(driver).newInstance();
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:derby:DBCarpeta");
		s = conn.createStatement();
		}catch(Exception e){
			return null;
		}
		return s;
	}
	

}
