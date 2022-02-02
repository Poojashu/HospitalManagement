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
<title>Doctor Update Page</title>
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
				<li><a href="/home">Home</a></li>
				<li>About</li>
				<li class="services">Services
					<ul class="dropdown">
						<li><a href="/doctor/home">Doctor</a></li>
						<li><a href="/patient/home">Patient</a></li>
						<li><a href="/room/home">Room</a></li>
						<li><a href="/staffs/home">Staffs</a></li>
						<li><a href="/charges/home">Surgeries</a></li>
					</ul>
				</li>
				<li class="services">Find-By-ID
					<ul class="dropdown">
						<li><a href="/doctor/findbyid">Doctor</a></li>
						<li><a href="/patient/findbyid">Patient</a></li>
						<li><a href="/room/findbyid">Room</a></li>
						<li><a href="/staffs/findbyid">Staffs</a></li>
					</ul>
				</li>
				<li class="services">Find-By-Name
					<ul class="dropdown">
						<li><a href="/doctor/findbyname">Doctor</a></li>
						<li><a href="/patient/findbyname">Patient</a></li>
						<li><a href="/staffs/findbyname">Staffs</a></li>
						<li><a href="/charges/findbyname">Surgeries</a></li>
					</ul>
				</li>
				<li><a href="/login" onclick="return confirm('Are you sure?')">Log
						Out</a></li>
			</div>
		</ul>
	</nav>
	<h3 align="center">
		<font><strong>Update Details</strong></font>
	</h3>
	<div class="main">
		<div class="container my-2">
			<c:forEach var="list" items="${list}">
				<form class="login-form forminner" method="post"
					action="/doctor/update">
					<table class="table table-striped table-responsive-md" border="1">
						<tr>
							<td><input type="number" value="${list.getDid()}" name="did"
								placeholder="Doctor's ID" readonly>
						<tr>
							<td><input type="text" value="${list.getDname()}"
								name="dname" placeholder="Doctor's Name" required>
						<tr>
							<td><input type="text" value="${list.getDaddress()}"
								name="daddress" placeholder="Doctor's Address" required>
						<tr>
							<td><input type="text" value="${list.getDmobile()}"
								name="dmobile" placeholder="Doctor's Mobile Number" required>
						<tr>
							<td><input type="text" value="${list.getDspecialization()}"
								name="dspecialization" placeholder="Doctor's Specialization"
								readonly>
						<tr>
							<td>
								<button class="btn btn-primary" type="submit">Update</button>
					</table>
				</form>
			</c:forEach>
		</div>
	</div>
</body>
</html>
