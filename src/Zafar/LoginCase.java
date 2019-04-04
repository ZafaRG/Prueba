package Zafar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCase {



	/*CREATE TABLE*/
	public static boolean insertUser(String uName, String uPass, String uEmail) {
		Connection conectionNick;
		
		PreparedStatement pss = null;
		PreparedStatement nick = null;
		
		
		try {
			String consultaNick = "select * from users where nick=?;";
			
			nick.setString(1,uName);
			ResultSet Respuesta = nick.executeQuery();
			
			if (Respuesta.next()) {
				return false;
			}else {
				
				String consulta = "insert into users (NICK,PASS,EMAIL) VALUES (?,?,?);";
			
				pss.setString(1,uName);
				pss.setString(2,uPass);
				pss.setString(3,uEmail);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pss != null) {
					pss.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
