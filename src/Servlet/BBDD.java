package Servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author imssbora
 */
public class BBDD {
  public static void main(String[] args) {

    String jdbcUrl = "jdbc:postgresql://localhost:5432/JavaTomcat";
    String username = "postgres";
    String pa = "123";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // Step 1 - Load driver
       // Class.forName("org.postgresql.Driver"); // Class.forName() is not needed since JDBC 4.0

        // Step 2 - Open connection
        conn = DriverManager.getConnection(jdbcUrl, username, pa);

        // Step 3 - Execute statement
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * from users");

        // Step 4 - Get result

        if (rs.next()) {
          System.out.println(rs.getString(1));
        }

      } catch (SQLException e) {
        e.printStackTrace();
      } 
        
  	}
}




