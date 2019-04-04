package Zafar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginCase {



	/*CREATE TABLE*/
	public static boolean insertUser(String uName, String uPass, String uEmail) {
	    String jdbcUrl = "jdbc:postgresql://localhost:5432/JavaTomcat";
	    String username = "postgres";
	    String password = "123";

	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;

	    try {
	        // Step 1 - Load driver
	       // Class.forName("org.postgresql.Driver"); // Class.forName() is not needed since JDBC 4.0

	        // Step 2 - Open connection
	        conn = DriverManager.getConnection(jdbcUrl, username, password);

	        // Step 3 - Execute statement
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("insert into users(nick,pass,email) values");

	        // Step 4 - Get result
	        if (rs.next()) {
	          System.out.println(rs.getString(1)+" " +rs.getString(2) +" " +rs.getString(3));
	        }

	      } catch (SQLException e) {
	        e.printStackTrace();
	      } finally {
	        try {

	          // Step 5 Close connection
	          if (stmt != null) {
	            stmt.close();
	          }
	          if (rs != null) {
	            rs.close();
	          }
	          if (conn != null) {
	              conn.close();
	            }
	          } catch (Exception e) {
	            e.printStackTrace();
	          }
	        }
		return false;
	}
}
