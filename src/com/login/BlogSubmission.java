package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.apphosting.client.datastoreservice.proto.DatastoreService;

public class BlogSubmission extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	 			throws IOException, ServletException {
	 		com.google.appengine.api.datastore.DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
	 		//PrintWriter p=resp.getWriter();
	 		
	 		 String title=req.getParameter("title");
	 		 String contents=req.getParameter("content");

	 		
	 		resp.setContentType("text/html");
	 		HttpSession session=req.getSession();
	 		String userName=(String)session.getAttribute("uname");
	 		//String test;
	 		
	 		PersistenceManager pm = PMF.get().getPersistenceManager();
			blogDetail blogDetails = new blogDetail(userName,title,contents);
			pm.makePersistent(blogDetails);
			
	 		
	 	
	 	
	 			
	 			String text = "created";

			    resp.setContentType("text/plain");  
			    resp.setCharacterEncoding("UTF-8"); 
			    resp.getWriter().write(text);       
				
	 		
	 		
	 	}

}
