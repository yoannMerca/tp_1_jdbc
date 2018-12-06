package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionLivre {

	public static void main(String[] args) {
		Connection conn = null;

		try{
			conn = ConnectionLivre.getConnection();
			

			System.out.println("Connexion effective !");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
			}
			catch (SQLException e){
				// do nothing
			}
		}
	}

	public static Connection getConnection() throws Exception{
		
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mariadb://localhost:3331/formation";
		String user = "root";
		String passwd = "root";

		return DriverManager.getConnection(url, user, passwd);
	}
}
