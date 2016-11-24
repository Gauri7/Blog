package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		 resp.setContentType("text/html");  
		PrintWriter out=resp.getWriter();
		DatastoreService lds=DatastoreServiceFactory.getDatastoreService();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(Validation.nullCheckLogin(username, password)){
		Key key=KeyFactory.createKey("UserDetail", username);
		
		
//			 com.google.appengine.api.datastore.Entity ent=lds.get(key);
			PersistenceManager pm = PMF.get().getPersistenceManager();
			userDetail userDetails = pm.getObjectById(userDetail.class,username);
	//		userDetails.getPassword().equals(password)

				if (userDetails.getPassword().equals(password)){
					
//				
					
					HttpSession session = req.getSession();
					session.setAttribute("uname", username);
					
					System.out.print(session.getAttribute("uname"));
					
				   	String text = "Loggedin";

				    resp.setContentType("text/plain"); 
				    resp.setCharacterEncoding("UTF-8");
				    resp.getWriter().write(text); 
				       
				   // resp.sendRedirect("welcome.jsp");
				    
				}
				else{
					
					//out.print("please enter valid details");
					
					String text = "invalid";

				    resp.setContentType("text/plain"); 
				    resp.setCharacterEncoding("UTF-8");
			        resp.getWriter().write(text); 
					 //req.getRequestDispatcher("Login.html").forward(req, resp);
				}
				//System.out.print(employee.toString());
			 
				
			}
		
		else {
			//out.print("Please fill fields");
			
			String text = "fill";

		    resp.setContentType("text/plain"); 
		    resp.setCharacterEncoding("UTF-8");
		    resp.getWriter().write(text); 
			//req.getRequestDispatcher("Login.html").forward(req, resp);
			
		}
		
	}
}
