package com.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Query;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class welcome extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	 			throws IOException, ServletException {
	 	//	com.google.appengine.api.datastore.DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
	 		//PrintWriter p=resp.getWriter();
	 		
		PersistenceManager pm= PMF.get().getPersistenceManager();
		javax.jdo.Query q = pm.newQuery(blogDetail.class);
		
		
			ArrayList<blogDetail> results = (ArrayList<blogDetail>) q.execute();

			
	 			String text = "displayed";

			    resp.setContentType("text/plain");  
			    resp.setCharacterEncoding("UTF-8"); 
			    resp.getWriter().write(text);       
				
	 		
	 		
	 	}

}



