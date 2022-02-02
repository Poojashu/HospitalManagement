<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/styledoctor.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Doctor Find By Name</title>
<style>
.formright {
	text-align: right;
}

h2 {
	text-align: center;
}

h4 {
	text-align: right;
}

.button {
	position: right;
	bottom: 30px;
}

th {
	text-align: center;
}

td {
	text-align: center;
}
</style>
</head>
<body>
	<nav class="navbar">
		<div class="logo">
		<h1>HMS</h1>
		</div>
		<ul class="nav-links">
			<div class="menu">
				<li><a href="/userhome">Home</a></li>
				<li>About</li>
				<li class="services">Services
					<ul class="dropdown">
						<li><a href="/doctor/userhome">Doctor</a></li>
						<li><a href="/patient/userhome">Patient</a></li>
						<li><a href="/room/userhome">Room</a></li>
						<li><a href="/staffs/userhome">Staffs</a></li>
						<li><a href="/charges/userhome">Surgeries</a></li>
					</ul>
				</li>
				<li class="services">Find-By-ID
					<ul class="dropdown">
						<li><a href="/doctor/userfindbyid">Doctor</a></li>
						<li><a href="/patient/userfindbyid">Patient</a></li>
						<li><a href="/room/userfindbyid">Room</a></li>
						<li><a href="/staffs/userfindbyid">Staffs</a></li>
					</ul>
				</li>
				<li class="services">Find-By-Name
					<ul class="dropdown">
						<li><a href="/doctor/userfindbyname">Doctor</a></li>
						<li><a href="/patient/userfindbyname">Patient</a></li>
						<li><a href="/staffs/userfindbyname">Staffs</a></li>
						<li><a href="/charges/userfindbyname">Surgeries</a></li>
					</ul>
				</li>
				<li><a href="/login" onclick="return confirm('Are you sure?')">Log Out</a></li>
			</div>
		</ul>
	</nav>
	<h3 align="center">
		<font><strong>Find Doctor Details by Name</strong></font>
	</h3>
	<h5 align="center">${error}</h5>
	<div class="main">
		<div class="container my-2">
			<form class="login-form" method="post" action="/doctor/userfindbyname">
				<table class="table table-striped table-responsive-md" border="1">
					<tr>
						<td><input type="text" name="dname" placeholder="Doctor's Name" required></input></td>
					</tr>
					<tr>
						<td><button class="btn btn-primary" type="submit">Submit</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>