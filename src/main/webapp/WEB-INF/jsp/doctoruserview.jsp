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
<title>Doctor Details</title>
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
				<li><a href="/login" onclick="return confirm('Are you sure?')">Log
						Out</a></li>
			</div>
		</ul>
	</nav>
	<h3 align="center">
		<font><strong>DOCTOR'S DETAILS</strong></font>
	</h3>
	<div class="main">
		<div class="inner">
			<div class="container my-2">
				<table class="table table-striped table-responsive-md" border="1">
					<c:forEach var="list" items="${list}">
						<tr>
							<th><b>ID Number</b></th>
							<td>${list.getDid()}</td>
						</tr>
						<tr>
							<th><b>Name</b></th>
							<td>${list.getDname()}</td>
						</tr>
						<tr>
							<th><b>Address</b></th>
							<td>${list.getDaddress()}</td>
						</tr>
						<tr>
							<th><b>Mobile Number</b></th>
							<td>${list.getDmobile()}</td>
						</tr>
						<tr>
							<th><b>Specialization</b></th>
							<td>${list.getDspecialization()}</td>
						</tr>
					</c:forEach>
				</table>
				<table class="table table-striped table-responsive-md" border="1">
					<h3 align="center">
						<font><strong>List of Patients</strong></font>
					</h3>
					<tr>
						<th><b>Patient's ID</b></th>
						<th><b>Patient's Name</b></th>
						<th><b>Full Details</b></th>
					</tr>
					<c:forEach var="list2" items="${list2}">
						<tr>
							<td>${list2.getPid()}</td>
							<td>${list2.getPname()}</td>
							<td><form method="post" action="/patient/userview/${list2.getPid()}">
									<button class="btn btn-primary">View</button>
								</form></td>
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
