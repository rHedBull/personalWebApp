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
		try {
			deleteUser(6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		u.setUserID(2);
		u.setLastName("Davi");
		u.setName("Ken");
		u.setBirthDate(9);
		u.seteMail("theDavises@test.com");
		u.setPassword("DAvisPassword");
		
		try {
			updateUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		out.println("process has been executed");
	}

	/**
	 *add new user object to users DB
	 * @param newUser Object to store
	 * @throws Exception 
	 */
	public void addUserToDB(User newUser) throws Exception {
		
		User u = newUser;
		userDAO  uDAO = new userDAO();
		uDAO.addNewUser(u);
	}
	
	/**
	 * Updates a message in the chat database. The message has
	 * to be already stored in the database to get updated successfully.
	 * @param updatedMessage
	 * @throws Exception 
	 */
	public void updateUser(User u) throws Exception {
		
		User updatedUser = u;
		int uID= updatedUser.getUserID();
		userDAO  uDAO = new userDAO();
		uDAO.updateUser(uID, updatedUser);
		
	}
	
	/**
	 * extracts one distinct User Object from DB
	 * @param id the id of the User from which the method should extract the User Object
	 * @return User object with @param id in DB
	 * works
	 * @throws Exception 
	 */
	public User getUserFromDB(int id) throws Exception {
		int Id = id;
		
		userDAO uDAO = new userDAO(); // create DAO object for user to acces DB
		User u = new User();  // create user Object that will be returned
		u = uDAO.getUser(Id); // assign the extracted userObject from the DB by the userDAO object to the user Object
		return u;
	}
	
	/**
	 * deletes a user from Database
	 * @param userID the userID of the user that will be delted
	 * @throws Exception 
	 */
	public void deleteUser(int uID) throws Exception {
		int userID = uID;
		userDAO  uDAO = new userDAO();
		uDAO.deleteUserObject(userID);
	}
		
}
