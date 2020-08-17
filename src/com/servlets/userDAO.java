package com.servlets;

import java.io.PrintWriter;
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
		rs.next();
		// code works till here ------------------------------------------------------------------------------------------
		
		//extract values from rs and assign to userDAO object;
		//String lastName = null; // = rs.getString("columnName");
		//u.setLastName(lastName);
		// this for every var of user Object
		
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
	
	
	/**
	 * returns a single String value of a certain column in the ResultSet
	 * @param columnName , the name of the column from which the String will be returned
	 * @param RS the ResultSet in which the columnValues are stored
	 * @return columnValue in columName as a String
	 */
	public String getString(String columnName, ResultSet RS) {
		String cn = columnName;
		String columnValue = null;
		ResultSet rs = RS;
		
		// assuming the rs.next(operation has already been executed);
		try {
			columnValue = rs.getString("cn");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return columnValue;
	}
}
