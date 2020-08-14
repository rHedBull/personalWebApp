package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

@WebServlet("/db")
public class DBservlet extends HttpServlet{
	
	/** The URL to the database file. */
	public final String url = "jdbc:sqlite:user.db";
	
	/** The used user name to interact with the database. */
	public final String userName = "root";
	
	/** The used password to interact with the database. */
	public final String password = "root";

	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException  {
		String debugServletCalled = "db Servelt called!";
		System.out.println(debugServletCalled);
		
		PrintWriter out = res.getWriter();
		out.print(debugServletCalled);
		
		Connection c = getDBConnection(url, userName, password);
		if (c != null) {
			System.out.println("connection established !!");
			out.print("connection established !!!");
		} else{
			out.print("connection was tried to establish but did not return any connection object");
		}
		
	}
	
	public Connection getDBConnection(String URL, String uName, String p){
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(url, userName, password);
			
			return con;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return con;
		}catch(SQLException e) {
			e.printStackTrace();
			return con;
		}
	}
	
	/**
	 * Stores a message in the chat database. By doing that the message's id is set to something not equal to {@code -1}.
	 * If the message's id stays {@code -1}, the message couldn't get stored. 
	 * <p>
	 * Added to that the method will return {@code false} if
	 * the storing process fails and {@code true} if everything goes fine.
	 * </p>
	 * @param m the message to store
	 * @return whether the storing process succeeded
	 */
	public boolean addUserToDB(userDAO d) {
		//d.getLocalData().setId(23);
		return true;
	}
	
	/**
	 * Updates a message in the chat database. The message has
	 * to be already stored in the database to get updated successfully.
	 * @param updatedMessage
	 */
	public void updateUser(userDAO d) {
		
	}
	
	public User getUserfromDB(int id) {
		int Id = id;
		
		userDAO uDAO = new userDAO(); // create DAO object for user to acces DB
		User u = new User();  // create user Object that will be returned
		u = uDAO.getUser(Id); // assign the extracted userObject from the DB by the userDAO object to the user Object
		return u;
	}
	
	
	
}
