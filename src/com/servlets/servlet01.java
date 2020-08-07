package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet01 extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Cookie kekse [] = req.getCookies(); // there are many cookies you have to find yours!!
		int recVar ;
		
		for(Cookie c: kekse) {
			if(c.getName().equals("test")) {
				recVar = Integer.parseInt(c.getValue());  //the cookie value is always a String !!!
			}
		}
		
		String contextValue;
		
		ServletConfig cg = getServletConfig();
		contextValue = cg.getInitParameter("nameOfConfigParam");
		
		
		ServletContext ctx = getServletContext();
		contextValue = ctx.getInitParameter("paramName01");
		
		String someVar = "yay";
		
		PrintWriter out = res.getWriter();
		out.print("Here can your wirte what ever shall appear on the page" + someVar);
		
	}
	

}

