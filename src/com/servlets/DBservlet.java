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

	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException  {
		String debugServletCalled = "db Servelt called!";
		System.out.println(debugServletCalled);
		
		PrintWriter out = res.getWriter();
		out.print(debugServletCalled);
		
		User u = new User();
		//u = getUserFromDB(2);
		
		/**
		u.setLastName("TestLastName");
		u.seteMail("test@email04.com"); // email needs to be always different !!!
		u.setPassword("p");
		 */
		//addUserToDB(u); 
		
		//String password = u.getPassword();
		//out.println(password);
		deleteUser(4);
		out.println("process has been executed");
	}

	/**
	 *add new user object to users DB
	 * @param newUser Object to store
	 */
	public void addUserToDB(User newUser) {
		
		User u = newUser;
		userDAO  uDAO = new userDAO();
		uDAO.addNewUser(u);
	}
	
	/**
	 * Updates a message in the chat database. The message has
	 * to be already stored in the database to get updated successfully.
	 * @param updatedMessage
	 */
	public void updateUser(userDAO d) {
		
	}
	
	/**
	 * extracts one distinct User Object from DB
	 * @param id the id of the User from which the method should extract the User Object
	 * @return User object with @param id in DB
	 * works
	 */
	public User getUserFromDB(int id) {
		int Id = id;
		
		userDAO uDAO = new userDAO(); // create DAO object for user to acces DB
		User u = new User();  // create user Object that will be returned
		u = uDAO.getUser(Id); // assign the extracted userObject from the DB by the userDAO object to the user Object
		return u;
	}
	
	/**
	 * deletes a user from Database
	 * @param userID the userID of the user that will be delted
	 */
	public void deleteUser(int uID) {
		int userID = uID;
		userDAO  uDAO = new userDAO();
		uDAO.deleteUserObject(userID);
	}
		
}
