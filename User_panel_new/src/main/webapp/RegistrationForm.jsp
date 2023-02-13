
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Register Form</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="AdminPanel/css/style.css">

<style>

</style>

</head>
<body >

	<div>
		<div class="main">
			<section class="signup">
				<div class="container">
					<div class="signup-content">
						<div class="signup-form">
							<h2 class="form-title">REGISTER</h2>

							<form action="Registration" method="post" class="register-form"
								id="register-form" onclick="return myfunction()">

								<div class="form-group">
									<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
									<input type="hidden" name="id" id="re_pass"/>
								</div>
								
								<input type="hidden" name="user_type" value="Normal User" />
								
								<!-- changes current -->
								<div class="form-group">
									<label for="name"> <i
										class="zmdi zmdi-account material-icons-name"></i></label> <input
										type="text" name="name" id="name" placeholder="Your Name"  required/>
									<span id="uname"> </span>
								</div>
								<div class="form-group">
									<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
									<input type="text" name="contact" id="contact"
										placeholder="Mobile No"  required/>
								</div>
								<div class="form-group">
									<label for="Address"><i class="zmdi zmdi-lock-outline"></i></label>
									<input type="text" name="Address" id="Address"
										placeholder="Address"  required/>
								</div>
								<div class="form-group">
									<label for="email"><i class="zmdi zmdi-email"></i></label> <input
										type="email" name="email" id="email" placeholder="Your Email"  required/>
								</div>
								<div class="form-group">
									<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
										type="password" name="pass" id="pass" placeholder="Password"  required/>
								</div>
								<div class="form-group">
									<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
									<input type="password" name="re_pass" id="re_pass"
										placeholder="Confirm password"  required/>
								</div>

								<div class="form-group">
									<input type="checkbox" name="agree-term" id="agree-term"
										class="agree-term" /> <label for="agree-term"
										class="label-agree-term"><span><span></span></span>I agree all statements in <a href="#" class="term-service">Terms
											of service</a></label>
								</div>
								<div class="form-group form-button">
									<input type="submit" name="signup" id="signup"
										class="form-submit" value="Register" />
								</div>
							</form>
						</div>
						<div class="signup-image">

							<figure>
								<img src="AdminPanel/images/signup-image.jpg"
									alt="sing up image" />
							</figure>
							<a href="loginfrom.jsp" class="signup-image-link"><b>I am
									already Register</b></a>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<!--  form  div end -->

	
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>

	<script>  
   function myfunction()
   {
	   var name= document.getElementById("name").value;
	  
	   if(name ==""){
		   document.getElementById("uname").innerHTML="***please enter your name";
	   }
	  
       </script>
</body>