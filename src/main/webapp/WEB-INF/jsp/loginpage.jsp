<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login!!</title>
<link rel="stylesheet" href="/css/loginpage.css">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<div class="login">
				<div class="login-header">
					<h3>${errormsg}</h3>
					<h3>SIGN IN</h3>
					<p>Please enter your credentials...</p>
				</div>
			</div>
			<form class="login-form" action="/login" method="post">
				<input type="text" name="userid" placeholder="User ID" required> <input
					type="password" name="password" placeholder="Password" required>
				<button>LOG IN</button>
			</form>
			<p class="message">
				Not registered? <a href="/create">Create an account</a>
			</p>
			<br>
			<p class="message">
				Forgot password? <a href="/forgot">Reset Password</a>
			</p>
		</div>
	</div>
</body>
</html>