package Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.Permission;
import Classes.User;

public class UserController {

	
	

	
	public static User logIn(String id, String password, String IP)
	{
		try {
			Statement stmt= Server.conn.createStatement();
			Statement stmt2=Server.conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM USERS WHERE ID='"+id+"' AND Password='"+password+"' ;");			
			if(rs.next()) {				
				stmt2.executeUpdate("INSERT INTO ONLINEUSERS VALUES ('"+id+"','"+IP+"');");
				return new User(rs.getString(1),rs.getString(2),Permission.values()[rs.getInt(3)-1]);
			}
		} 
			catch (SQLException e) {
				return new User("0", "0", Permission.NONE); 
		}
		return null;
	}
	
	public static void logOut(String ID)
	{ 
		
			Statement stnt;
			try {
				stnt = Server.conn.createStatement();
				stnt.executeUpdate("DELETE FROM OnlineUsers WHERE ID='"+ID+"';");
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		
		
	}
	
	

}
