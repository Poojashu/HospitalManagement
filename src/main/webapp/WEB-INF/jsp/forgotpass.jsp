<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password!!</title>
<link rel="stylesheet" href="/css/loginpage.css">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<div class="login">
				<div class="login-header">
					<h3>${errormsg2}</h3>
					<h3>RESET PASSWORD</h3>
				</div>
			</div>
			<form class="login-form" action="/forgot" method="post">
				<input type="text" name="userid" placeholder="User ID" required>
				<input type="password" name="oldpassword" placeholder="Old Password" required>
				<input type="password" name="newpassword" placeholder="New Password" required>
				<input type="password" name="newpassword2" placeholder="Cofirm New Password" required>
				<button onclick="return confirm('Are you sure?')">Change Password</button>
			</form>
			<p class="message">
				<a href="/login">Sign In</a>
			</p>
		</div>
	</div>
</body>
</html>