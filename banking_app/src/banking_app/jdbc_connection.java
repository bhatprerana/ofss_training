package banking_app;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class jdbc_connection {
//	
//		public static void main(String[] args) {
//			try {
//				String url = "jdbc:mysql://localhost:3306/sample";
//				String uname = "root";
//				String password = "orcl@111";
//				Connection con = DriverManager.getConnection(url,uname,password);
//				System.out.println("connected");
//				
////				String query = "Select * from person";
////				
////				//creating statement object
////				Statement st = con.createStatement();
////				ResultSet rs = st.executeQuery(query);
//				
////				while(rs.next()) {
////					int id = rs.getInt(1);  // here 1 is the column number, it starts from 1
////					String name = rs.getString(2);
////					int age = rs.getInt(3);
////					String city = rs.getString(4);
////					String fav_food = rs.getString(5);
////					
////					System.out.println(id+"--"+name+"--"+age+"--"+city+"--"+fav_food);
//					
////				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		
//
//	}
//
//}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc_connection {

    private static final String URL = "jdbc:mysql://localhost:3306/sample"; // Replace with your DB name
    private static final String USER = "root"; // Replace with your DB username
    private static final String PASSWORD = "1234"; // Replace with your DB password

    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to the database.");
            e.printStackTrace();
        }
        return null;
    }
}

