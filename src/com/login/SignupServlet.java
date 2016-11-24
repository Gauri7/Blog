
package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@SuppressWarnings("serial")
public class SignupServlet extends HttpServlet {

	public static boolean checkUser(Key name){
		boolean status = false;
		DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		
//		
//		try {
//	//	Entity ent1 = ds.get(name);
//		//	status = true;
//			//System.out.print(employee.toString());
//		} catch (EntityNotFoundException e) {
//			// TODO Auto-generated catch block
//		//	e.printStackTrace();
//			status = false;
//			//System.out.println("Not found");
//		}		
		return status;
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		com.google.appengine.api.datastore.DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/text");
		String emailId=req.getParameter("emailId");
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		
		if(Validation.nullCheck(emailId, userName, password)){
			    try{
			 PersistenceManager pm = PMF.get().getPersistenceManager();
			 
			 userDetail e = pm.getObjectById(userDetail.class, userName);
			 String text = "Not";
			 
			 		    resp.setContentType("text/plain"); 
			 		    resp.setCharacterEncoding("UTF-8");
     		 		    resp.getWriter().write(text); 
			 
			 
			}
			catch(JDOObjectNotFoundException ne){
				PersistenceManager pm = PMF.get().getPersistenceManager();
				userDetail userDetails = new userDetail(userName,password,emailId);
				pm.makePersistent(userDetails);
			//	userDetails.setTitle(title);
				
			}
			    String text = "Signedin";

			    resp.setContentType("text/plain");  
			    resp.setCharacterEncoding("UTF-8"); 
			    resp.getWriter().write(text); 
			
//			Entity user=new Entity("UserDetails",userName);
//			Key key=KeyFactory.createKey("UserDetails", userName);
//			System.out.println(checkUser(key));
//			if(checkUser(key) == false){
//			user.setProperty("emailId", emailId);
//			user.setProperty("userName", userName);
//			user.setProperty("password", password);
//			user.setProperty("title", title);
//			ds.put(user);
			 
			      
			
		  
		 			
		   }
			
			else{
				String text = "Failed";
				//out.print("<p>Please Enter Valid Details</p>");
			    resp.setContentType("text/plain"); 
			    resp.setCharacterEncoding("UTF-8");
			    resp.getWriter().write(text); 
				
				//out.print("<p>Please Enter Valid Details</p>");
			
				
			
			}
		}
//		else{
//			String text = "Not";
//
//		    resp.setContentType("text/plain"); 
//		    resp.setCharacterEncoding("UTF-8");
//		    resp.getWriter().write(text); 
//		//out.print("<p>Please Enter all Details</p>");
//		
//		}

	
}



