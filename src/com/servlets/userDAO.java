package com.servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDAO extends DBservlet{

	public User getUser (int id) {
		
		int Id = id;
		String query = (String) "Select * from users where userID = " + Id;
		ResultSet rs = null;
		
		User u = new User();
		u.setUserID(Id);
		
		Connection con = getDBConnection(url, userName, password);
		
		try {
		Statement st = con.createStatement();		
		rs = st.executeQuery(query);
		if(rs != null) {
			System.out.println("SQL statement executed succesfully and ResultSet rs filled");
		}else {
			System.out.println("Failed to execute sql statement. ResultSet rs was not filled");
		}
		
		//extract values from rs and assign to userDAO object;
		
		if(u != null) {
			System.out.println("returned userDAO Object is not null");
		}
		return u;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to extract data from database");
			return u;
		}
		
	}
}
