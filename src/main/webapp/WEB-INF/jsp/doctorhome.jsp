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
<link rel="stylesheet" href="/css/style2.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Doctor Home Page</title>
<style>
.bton{
	display: flex;
	align-items: center;
	text-align: center;
	justify-content: center;
}

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
		<font><strong>DOCTOR'S PAGE</strong></font>
	</h3>
	<form method="get" action="/doctor/add" class="formright">
		<button class="btn btn-primary">Insert Details</button>
	</form>
	<div class="main">
		<div class="inner">
			<div class="container my-2">
				<table class="table table-striped table-responsive-md" border="1">
					<tr>
						<th><b>ID Number</b></th>
						<th><b>Name</b></th>
						<th><b>Full Details</b></th>
						<th><b>Actions</b></th>
					</tr>
					<c:forEach var="list" items="${list}">
						<tr color="black">
							<td>${list.getDid()}</td>
							<td>${list.getDname()}</td>
							<td><form method="post" action="/doctor/view/${list.getDid()}">
									<button class="btn btn-primary">View</button>
								</form></td>
							<td><a href="/doctor/update/${list.getDid()}"
								class="btn btn-primary">Update</a> <a
								href="/doctor/delete/${list.getDid()}" class="btn btn-danger"
								onclick="return confirm('Are you sure, you want to delete this data?')">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="bton">
					<button class="btn btn-primary" onclick="display()">Print</button>
					<script>
						function display() {
							window.print();
						}
					</script>
				</div>
			</div>
		</div>
	</div>
</body>
</html>