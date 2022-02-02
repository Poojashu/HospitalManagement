<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/stylepatient.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Patient Update Page</title>
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
<script language="javascript" type="text/javascript">
	function doReload(catid) {
		document.location = 'samepage.php?catid=' + catid;

		/* But if you want to submit the form just comment above line and uncomment following lines*/
		//document.frm1.action = 'samepage.php';
		//document.frm1.method = 'post';
		//document.frm1.submit();
	}
</script>
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
		<font><strong>Insert Details</strong></font>
	</h3>
	<h5 align="center">
		<font><strong>${error}</strong></font>
	</h5>
	<div class="main">
		<div class="container my-2">
			<form class="login-form forminner" method="post"
				action="/patient/add">
				<table class="table table-striped table-responsive-md" border="1">
					<tr>
						<td><input type="text" name="pname"
							placeholder="Patient's Name" required>
					<tr>
						<td><select id="proom" name="proom" required>
								<option disabled selected>---Patient's Room Number---</option>
								<c:forEach var="list" items="${list}">
									<option value="${list.getRoomno()}">${list.getRoomno()}
										- ${list.getLocation()}</option>
								</c:forEach>
						</select>
						<tr>
					<td><input type="number" name="page"
							placeholder="Patient's Age" required><tr>
						<td><select id="pgender" name="pgender" required>
								<option disabled selected>-------Patient's Gender------</option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="Others">Others</option>
						</select>
						<tr>
					<td><select id="psurgery" name="psurgery" required>
								<option disabled selected>------Patient's Surgery------</option>
								<c:forEach var="list2" items="${list2}">
									<option value="${list2.getSname()}">${list2.getSname()}</option>
								</c:forEach>
						</select><tr>
						<td><input type="text" name="paddress"
							placeholder="Patient's Address" required>
						<tr>
				<td>
							<button type="submit" class="btn btn-primary">Submit</button></table>
			</form>
		</div>
	</div>
</body>
</html>
