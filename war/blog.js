function loginShow() {
	$("#welcome").hide();
	$("#profile").hide();
	$("#loginform").show();
	$("#signupform").hide();
	$("#createblogform").hide();

	// $("#print").hide();

}
function printShow() {
	$("#welcome").hide();
	$("#profile").hide();
	$("#loginform").hide();
	$("#signupform").hide();
	$("#print").show();
	$("#createblogform").hide();
}

function signupShow() {
	$("#welcome").hide();
	$("#profile").hide();
	$("#loginform").hide();
	$("#signupform").show();
	$("#createblogform").hide();
	// $("#print").hide();
}

function welcomeShow() {
	$("#welcome").show();
	$("#profile").hide();
	$("#loginform").hide();
	$("#signupform").hide();
	$("#print").hide();
	$("#createblogform").hide();
}
function profileShow() {
	$("#welcome").hide();
	$("#profile").show();
	$("#loginform").hide();
	$("#print").hide();
	$("#signupform").hide();
	$("#createblogform").hide();
}

$(document).on("click","#signupbutton",function() {
					var name = document.getElementById("signupname").value;

					var password = document.getElementById("signuppassword").value;
					var emailId = document.getElementById("emailId").value;
					var url = "SignupServlet?username=" + name + "&password="
							+ password + "&emailId="+ emailId;
					console.log(url);
					console.log("coming to get call");
					var req = $.get(url, function(responseText) {
						var status = responseText;
					});
					req
							.done(function(status) {
								if (status == "Signedin") {
									document.getElementById("print").innerHTML = "";
									loginShow();
								} else if (status == "Failed") {
									document.getElementById("print").innerHTML = "Already signed in";
									signupShow();
									
								} else if (status == "Not") {
									document.getElementById("print").innerHTML = "Please fill all Details";
									signupShow();
									
								}
							});
				});
/*
 * for login
 */
$(document).on("click","#loginbutton",function() {

					$("#loginform").hide();
					var name = document.getElementById("loginname").value;

					var password = document.getElementById("loginpassword").value;
					 $('#loginpassword').val("");
					 $('#loginname').val("");

					var url = "Login?username=" + name + "&password="
							+ password;
					console.log("coming to get  Login call");
					console.log(url);
					var req = $.get(url, function(responseText) {
						var status = responseText;
						console.log("status::::" + status);
					});
					req.done(function(status) {
								if (status == "Loggedin") {
									document.getElementById("print").innerHTML = "";
									// //var name = session.getSession(uname);

									$('#profile').load("/index.jsp #profile");

									 profileShow();
									//		

								} else if (status == "invalid") {
									document.getElementById("print").innerHTML = "";
									document.getElementById("print").innerHTML = "Please Enter Valid Details";
									loginShow();
									
								} else if (status == "invalids") {
									document.getElementById("print").innerHTML = "";
									document.getElementById("print").innerHTML = "Intially you need to signup";
									signupShow();
									

								} else if (status == "fill") {
									document.getElementById("print").innerHTML = "Please fill Details";
									 loginShow();
									

								}
							});
					req.fail(function(status) {
						console.log("Faileddd");
					});
				});

/* for logout */
$(document).on("click", "#logoutbutton", function() {
	var name = document.getElementById("loginname").value;

	var url = "Logout";
	console.log("coming to get  Logout call");
	// console.log(url);
	var req = $.get(url, function(responseText) {
		var status = responseText;
		console.log("status::::" + status);
	});
	req.done(function(status) {
		if (status == "Loggedout") {
			$("#welcome").show();
			$("#profile").hide();
			$("#loginform").hide();
			$("#signupform").hide();
		}

	});

});
/* for blog creation */

$(document).on("click", "#submitBlog", function() {
	var title=document.getElementById("title").value;
	var content=document.getElementById("content").value;
	
	
	console.log("coming to get  blogsubmission call");
	// console.log(url);
	var req = $.post("BlogSubmission",{
		title: title,
		content: content
	}, function(responseText) {
		var status = responseText;
		console.log("status::::" + status);
	});
	req.done(function(status) {
		if (status == "created") {
			console.log("status: and going to redirect ");
			$("#welcome").show();
			$("#profile").hide();
			$("#loginform").hide();
			$("#signupform").hide();
			$('#createblogform').hide();
		}

	});

});

/* for displaying */

$(document).ready(function() {
	
	$('#bloglist').show();
	$('#profile').hide();
	$('#loginform').hide();
	$('#signupform').hide();
	$('#createblogform').hide();
	
	
	console.log("coming to get  blogsubmission call");
	
	var req = $.post("welcome",{
		title: title,
		content: content
	}, function(responseText) {
		var status = responseText;
		console.log("status::::" + status);
	});
	req.done(function(status) {
		if (status == "displayed") {
			console.log("status: and going to redirect ");
			$("#welcome").show();
			$("#profile").hide();
			$("#loginform").hide();
			$("#signupform").hide();
			$('#createblogform').hide();
		}

	});

	$('#welcomelogin').click(function() {
		$('#welcome').hide();
		$('#loginform').show();
		$('#signupform').hide();
		$('#profile').hide();
		$('#createblogform').hide();
	});
	$('#welcomesignup').click(function() {
		$('#welcome').hide();
		$('#loginform').hide();
		$('#signupform').show();
		$('#profile').hide();
		$('#createblogform').hide();
	});
	
	$(document).on("click", "#createbutton", function() {

		console.log("done!")
		$('#welcome').hide();
		$('#loginform').hide();
		$('#signupform').hide();
		$('#profile').hide();
		$('#createblogform').toggle();
	});
	

});
