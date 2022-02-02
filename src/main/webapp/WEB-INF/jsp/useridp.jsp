<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up!!</title>
<link rel="stylesheet" href="/css/loginpage.css">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<div class="login">
				<div class="login-header">
					<h3>${errormsg2}</h3>
					<h3>SIGN UP</h3>
					<p>Create an Account</p>
				</div>
			</div>
			<form class="login-form" action="/create" method="post">
				<input type="text" name="userid" placeholder="New User ID" required>
				<input type="password" name="password" placeholder="Password" required>
				<input type="password" name="password2"
					placeholder="Confirm Password" required>
				<button>Register</button>
			</form>
			<p class="message">
				<a href="/login">Sign In</a>
			</p>
		</div>
	</div>
</body>
</html>