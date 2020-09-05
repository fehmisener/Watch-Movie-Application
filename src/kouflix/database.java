package kouflix;


import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.*;;

public class database {
	
	static Connection myConn;
	static Statement myStat;
	static Statement myStat1;
	static String url = "jdbc:sqlite:database.db";
	

	static Connection conn = null;
	
	static boolean connect() {
		try {
			conn = DriverManager.getConnection(url);
			return true;			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	static ResultSet show(String sorgu) {
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sorgu);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
		
	}	
	static void add(String sorgu) {
		Statement st;
		
		try {
			st = conn.createStatement();
			st.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}