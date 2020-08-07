package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class servlet01 extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		int sum, numb1, numb2;
		
		numb1 = Integer.parseInt(req.getParameter("num1"));
		numb2 = Integer.parseInt(req.getParameter("num2"));
		
		sum = numb1 + numb2;
		
		
		String output = "the sum of the two numbers is: " + sum;
		
		PrintWriter out = res.getWriter();
		out.print(output);
		
	}
	

}

