<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set -->
<!-- the browser's rendering engine into -->
<!-- "Quirks Mode". Replacing this declaration -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout. -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="test.css" />


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="blog.js">
</script>
</head>

<body>
<script>


</script>

<div id="welcome">
<h1 style="color: green; text-align: center; font-family: Impact">WELCOME</h1>

<input type="button" value="signup" id="welcomesignup">
<input type="button" value="login" id="welcomelogin">

</div>

<div id="bloglist">
</div>

<div id="loginform" >

<b>Name: </b><input type="text" id="loginname"> <br> 
<b>Password:</b><input type="password" id="loginpassword"> <br>
<input type="button" value="login" id="loginbutton">

</div>

<div  id="signupform">
<b>Name:</b> <input type="text" id="signupname"> <br> 
<b>Password:</b><input type="password" id="signuppassword"> <br> 
<b>Email :</b><input type="email" id="emailId"> <br>
<input type="button" value="Signup" id="signupbutton">

</div>



<div id="profile">

<b>Welcome to profile</b>
<%
System.out.println("Inside profile");
System.out.println(session.getAttribute("uname"));
if(session.getAttribute("uname")!=null){
	String name=(String)session.getAttribute("uname");
	System.out.println("session name inside loop::"+name);
	

	out.print("welcome "+name);
	out.print("<br><input type=\"button\" value=\"logout\" id =\"logoutbutton\"/>");
	out.print("<br><input type=\"button\" value=\"createBlog\" id =\"createbutton\"/>");
	
	} else {
		System.out.println("coming to null");
		
		String name=(String)session.getAttribute("uname");
}
%>

</div>
<div id ="print">

</div>


<div id="createblogform">
<b>Blog Creation</b>
<br> Title: </b><input type="text" id="title" > <br> 
<br>
<textarea name="content" id="content" rows="30" cols="70"></textarea><br>
<br><input type="button" value="SubmitBlog" id ="submitBlog">

</div>



</body>
</html>