package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOCategorie {


		public static void getAllCategorie() {
			Connection conn = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			try{
				conn = ConnectionLivre.getConnection();
				statement = conn.createStatement();
				
		
				resultSet = statement.executeQuery("SELECT * FROM categorie");
				

				ResultSetMetaData resultMetaData = resultSet.getMetaData();
				
				System.out.println("\r\n====");

				for (int i = 1; i <= resultMetaData.getColumnCount(); i++){
					System.out.print("\t" + resultMetaData.getColumnName(i).toUpperCase() + "\t");
				}
				
				
				System.out.println();
				
				while (resultSet.next()){
					System.out.print("\t" + resultSet.getInt("id") + "\t\t" + resultSet.getString("nom_categorie") + "\r\n");
				}
				
				System.out.println("\r\n====");
				
				
			}
			catch (Exception e){
				e.printStackTrace();
			}
			finally{
				try {
					resultSet.close();
					statement.close();
					conn.close();
				}
				catch (SQLException e){

					e.printStackTrace();
				}
				
			}
		}
		
		public static void deleteCategorie(int id ) throws Exception{
			Connection conn = null;
			PreparedStatement preparestatement = null;
			try{
				conn = ConnectionLivre.getConnection();

				preparestatement = conn.prepareStatement("DELETE FROM categorie WHERE id=?");
				preparestatement.setInt(1, id);
				
				int result = preparestatement.executeUpdate();
				if(result ==0) System.out.println("pas de categorie à supprimer");
				
			}
			catch (Exception e){
				throw new Exception("la suppression de la categorie n'a pas abouti");
			}
			finally{
					
					preparestatement.close();
					conn.close();
			}
		}


		public static void insertCategorie(String name) throws Exception{
			Connection conn = null;
			PreparedStatement preparestatement = null;
			try{
				conn = ConnectionLivre.getConnection();

				preparestatement = conn.prepareStatement("INSERT INTO categorie (nom_categorie) values (?)");
				preparestatement.setString(1, name);
				
				int result = preparestatement.executeUpdate();
				if(result ==0) System.out.println("pas de categorie ajouté");
				
			}
			catch (Exception e){
				throw new Exception("l'ajout de la categorie n'a pas abouti");
			}
			finally{
					
					preparestatement.close();
					conn.close();
			}
		}
		public static void updateCategorie(int id , String cat) throws Exception{
			Connection conn = null;
			PreparedStatement preparestatement = null;
			try{
				conn = ConnectionLivre.getConnection();

				preparestatement = conn.prepareStatement("UPDATE categorie SET nom_categorie =? WHERE id = ?");
				preparestatement.setInt(2, id);
				preparestatement.setString(1, cat);
				int result = preparestatement.executeUpdate();
				if(result ==0) System.out.println("pas de categorie trouvé");
				
			}
			catch (Exception e){
				throw new Exception("l'update de la categorie n'a pas abouti");
			}
			finally{
					
					preparestatement.close();
					conn.close();
			}
		}
	}


