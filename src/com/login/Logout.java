package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Logout extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
System.out.println("LOGOUT");
		HttpSession session = req.getSession(false);
		//if (session != null) {
			//String name = (String) session.getAttribute("name");

			
			// HttpSession session=req.getSession();
			session.removeAttribute("name");
			session.invalidate();
			//session.setAttribute("uname", "");
			String text = "Loggedout";

		    resp.setContentType("text/plain"); 
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(text); 
			
		  //  out.append("You are successfully logged out!");
			//req.getRequestDispatcher("login.html").forward(req, resp);
		
		out.close();
	}
}
