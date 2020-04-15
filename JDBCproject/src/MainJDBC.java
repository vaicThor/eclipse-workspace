import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainJDBC {

	public static void main(String[] args) {


		// Loading Driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("Driver MySQL introuvable");
			}
		// Utilisation de la classe DriverManager pour créer une connexion à votre bbd
		// port 3306 pour localhost
			
			Connection connexion = null ;
			String url = "jdbc:mysql://localhost:3306/jdbcbegining?serverTimezone=UTC";
			String user = "root";
			String pwd = "" ;
			
			try {
				 connexion = DriverManager.getConnection(url,user,pwd) ;	
			}catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Connection refused");
			}
			
		// Requesting Database
			ResultSet rs = null; 
			String query = "SELECT * FROM tabletestamap";
			try (Statement st = connexion.createStatement()) { // try(with) le Statement est autoclose si tu le mets dans le with du try il se ferme tt seul

				rs = st.executeQuery(query);
				
				while(rs.next()) {
					int	   fruitId= rs.getInt("id");
					String fruitName= rs.getString("name");
					float  fruitPrice= rs.getFloat("price");
					
					System.out.println("Fuit id :"+ fruitId);
					System.out.println("Fuit Name :"+ fruitName);
					System.out.println("Fuit Price :"+ fruitPrice);
					System.out.println("\n");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			} 
	}
}
