package com.servlets;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDAO extends DBservlet{

	/**
	 * returns a certain full User Object from database indentified by userID
	 * @param id, the userId by which he can be found in the DB
	 * @return the User Object
	 */
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
		
		//extract values from rs and assign to userDAO object;
		String lastName = rs.getString("lastName");
		u.setLastName(lastName);
		String name = rs.getString("name");
		u.setName(name);
		int birthDate = rs.getInt("birthDate");
		u.setBirthDate(birthDate);
		String eMail = rs.getString("eMail");
		u.seteMail(eMail);
		String password = rs.getString("password");
		u.setPassword(password);
		
		// u.print();
		
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
	 * updates a certain int Value of a user in DB
	 * @param userID to identify the user which has to be updated
	 * @param columnIndex the index of the column where you want to update a value
	 * @param columnValue the actual int value which should be inserted in the use in DB
	 */
	public void updateUserInt(int userID, String columnIndex, int columnValue ) {
		Connection con = getDBConnection(url, userName, password);
		
		String updateStatement = "dkfsfj";
		
		
		try {
			Statement st = con.createStatement();
			System.out.println("Updated user information");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to update user information");
		}
				
	}
	
	/** updates a certain String Value of a user in DB
	 * @param userID to identify the user which has to be updated
	 * @param columnIndex the index of the column where you want to update a value
	 * @param columnValue the actual String value which should be inserted in the use in DB
	 */
	public void updateUserString(int userID, String columnIndex, String columnValue) {
		
	}
	
	/** 
	 * add a new user object to users Db
	 * @param newUser the user object that should be stored
	 * throws error when password of user is empty
	 * throw exception when process fails
	 */
	public void addNewUser(User newUser) {
		 User u = newUser;
		 
		 String userLastName = u.getLastName();
		 String uName = u.getName();
		 int userBirthDate = u.getBirthDate();
		 String userEMail = u.geteMail();
		 String userPassword = u.getPassword();
		 
		 if (userPassword == null) { // user needs to provide password !!!
			 System.out.println("user: " + u.getUserID() + " did not provide a password!!" );
			 System.out.println("failed to insert User into DB");
			 return;
		 }
		 
		 Connection con = getDBConnection(url, userName, password);
		 
		 String query = (String) "Insert into users(lastName,name,birthDate,eMail,password) "
			 		+ "values(\"" + userLastName + "\", \"" + uName + "\", " + userBirthDate + ", \"" + userEMail + "\", \"" + userPassword + "\")";
		 PreparedStatement pst;
		 try {
			pst = con.prepareStatement(query);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to execute insert query");
			System.out.println("failed to insert User into DB");
			e.printStackTrace();
			
		}
		 
	}
	
	
}
