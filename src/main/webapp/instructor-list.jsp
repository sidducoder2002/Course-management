<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <style>
        /* Add your custom CSS styles here */
        body {
            background-color: #f8f9fa; /* Light gray background */
            padding: 20px;
        }
        .jumbotron {
            background-color: #007bff; /* Blue jumbotron background */
            color: #fff; /* White text color */
            padding: 20px;
            margin-bottom: 20px;
        }
        .list-group-item {
            background-color: #fff; /* White list item background */
            border: none; /* Remove borders */
        }
        .logout-btn {
            position: fixed;
            top: 10px; /* Adjust this value as needed */
            right: 10px; /* Adjust this value as needed */
            z-index: 9999; /* To ensure it's on top of other elements */
        }
    </style>
</head>
<body>

    <div class="jumbotron">
        <h1 class="display-4">Welcome, ${username}!</h1>
    </div>
     <a href="/logout" class="logout-btn btn btn-danger">Logout</a>

    <div class="container">
        <h2>Your Instructors</h2>
        <ul class="list-group">
            <c:forEach var="instructor" items="${instructors}">
                <li class="list-group-item">${instructor.name}</li>
                <!-- Add more details about the instructor if needed -->
            </c:forEach>
        </ul>

        <h2>Your Enrolled Courses:</h2>
        <ul class="list-group">
            <c:forEach var="course" items="${student.courses}">
                <li class="list-group-item">${course.name}</li>
                <!-- Add more details about the course if needed -->
            </c:forEach>
        </ul>
    </div>

    <!-- Bootstrap JS (optional, for Bootstrap components that require JavaScript) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
