<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom CSS -->
<style>
/* Custom styles */
/* General styles */
body {
	padding-top: 50px;
	padding-bottom: 20px;
	background-color: #f8f9fa; /* Background color */
}

.container {
	max-width: 960px;
	background-color: #ffffff; /* Container background color */
	border-radius: 5px; /* Container border radius */
	box-shadow: 0 4px 8px rgba(0, 0, 0, .05); /* Container box shadow */
	padding: 20px;
	margin: 0 auto;
	margin-top: 20px;
}

.btn-container {
	margin-top: 20px;
	position: sticky;
	top: 0;
	background-color: #ffffff; /* Background color */
	padding: 10px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, .1);
	/* Button container box shadow */
}

.btn {
	margin-right: 10px;
}

.table-container {
	margin-top: 20px;
}

.dashboard-heading {
	color: #007bff;
	text-align: center;
	margin-top: 20px;
}

.logout-btn {
	position: fixed;
	top: 10px;
	right: 10px;
	z-index: 999; /* Ensure logout button is above other elements */
}
/* Custom sidebar styles */
.layout {
	display: flex;
	height: 100vh;
}

.sidebar {
	width: 250px;
	background-color: #0c1e35;
	color: #ffffff;
	padding-top: 20px;
}

.sidebar-collapsed {
	width: 80px;
}

.sidebar-logo {
	display: flex;
	align-items: center;
	justify-content: center; /* Center logo horizontally */
	padding-bottom: 20px; /* Add some space below logo */
	border-bottom: 1px solid #4a4e69;
	/* Add a border line below the logo */
}

.sidebar-menu {
	list-style-type: none;
	padding: 0;
	margin: 0;
}

.sidebar-menu-item {
	padding: 10px 0;
	font-size: 0.8em;
	letter-spacing: 2px;
	opacity: 0.5;
	transition: opacity 0.3s;
	text-align: center; /* Center menu items */
}

.sidebar-menu-item a {
	color: #ffffff;
	text-decoration: none;
}

.sidebar-menu-item:hover {
	opacity: 1;
}

.sidebar-menu-item.active {
	opacity: 1;
}

.sidebar-footer {
	text-align: center;
	margin-top: auto;
	padding: 20px;
}

.sidebar-toggle {
	position: fixed;
	right: 20px;
	top: 20px;
}
/* Sidebar animation */
@
keyframes swing { 0%, 30%, 50%, 70%, 100% {
	transform: rotate(0deg);
}
10
%
{
transform
:
rotate(
10deg
);
}
40
%
{
transform
:
rotate(
-10deg
);
}
60
%
{
transform
:
rotate(
5deg
);
}
80
%
{
transform
:
rotate(
-5deg
);
}
}
</style>
</head>
<body>
	<!-- Header -->
	<div class="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="/dashboard">Admin Dashboard</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">


					<li class="nav-item dropdown"></li>

				</ul>

			</div>
		</nav>
	</div>

	<!-- Sidebar -->
	<div class="layout">
		<div class="sidebar">
			<div class="sidebar-logo"></div>
			<ul class="sidebar-menu">
			<sec:authorize access="hasRole('ADMIN')">
				<li class="sidebar-menu-item"><a href="/dashboard">Dashboard</a></li>
				<li class="sidebar-menu-item"><a href="addInstructor.jsp">Add
						Instructor</a></li>
				<li class="sidebar-menu-item"><a href="addStudent.jsp">Add
						Student</a></li>
				<li class="sidebar-menu-item"><a href="addCourse.jsp">Add
						Course</a></li>
				<!-- Updated link -->
				
			 </sec:authorize>
			 <li class="sidebar-menu-item"><a href="/assignClassForm">Assign
						Course</a></li>
			</ul>

		</div>

		<!-- Main Content -->
		<div class="container">
			<h1 class="dashboard-heading">Welcome to Admin Dashboard</h1>
			<div class="btn-container">
				<a href="/logout" class="logout-btn btn btn-danger">Logout</a>
			</div>

			<!-- Instructor Table -->
			<h2 style="color: blue;">List of Instructors:</h2>
			<div class="table-container">
				<!-- Search input field -->
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Qualification</th>
							<th>Courses</th>
						</tr>
					</thead>
					<tbody>
						<!-- Iterate over instructor data and populate the table -->
						<c:forEach var="instructor" items="${instructors}">
							<tr>
								<td>${instructor.id}</td>
								<td>${instructor.name}</td>
								<td>${instructor.email}</td>
								<td>${instructor.qualification}</td>
								<td>
									<ul>
										<!-- Iterate over instructor's courses and display -->
										<c:forEach var="course" items="${instructor.courses}">
											<li>${course.name}</li>
										</c:forEach>
									</ul>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<!-- Course Table -->
			<h2 style="color: blue;">List of Courses:</h2>
			<div class="table-container">
				<!-- Search input field -->

				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Instructors</th>
							<th>Students</th>
						</tr>
					</thead>
					<tbody>
						<!-- Iterate over course data and populate the table -->
						<c:forEach var="course" items="${courses}">
							<tr>
								<td>${course.id}</td>
								<td>${course.name}</td>
								<td>${course.description}</td>
								<td>${course.startDate}</td>
								<td>${course.endDate}</td>
								<td>
									<ul>
										<!-- Iterate over course's instructors and display -->
										<c:forEach var="instructor" items="${course.instructors}">
											<li>${instructor.name}</li>
										</c:forEach>
									</ul>
								</td>
								<td>
									<ul>
										<!-- Iterate over course's students and display -->
										<c:forEach var="student" items="${course.students}">
											<li>${student.name}</li>
										</c:forEach>
									</ul>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<!-- Student Table -->
			<h2 style="color: blue;">List of Students:</h2>
			<div class="table-container">
				<!-- Search input field -->

				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Date of Birth</th>
							<th>Courses</th>
						</tr>
					</thead>
					<tbody>
						<!-- Iterate over student data and populate the table -->
						<c:forEach var="student" items="${students}">
							<tr>
								<td>${student.id}</td>
								<td>${student.name}</td>
								<td>${student.email}</td>
								<td>${student.dateOfBirth}</td>
								<td>
									<ul>
										<!-- Iterate over student's courses and display -->
										<c:forEach var="course" items="${student.courses}">
											<li>${course.name}</li>
										</c:forEach>
									</ul>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<a href="/logout" class="logout-btn btn btn-danger">Logout</a>
	</div>

	<!-- Bootstrap JS and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<!-- Custom JS -->
	<script>
       
    </script>
</body>
</html>
