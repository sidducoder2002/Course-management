<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        /* Add your custom styles here */
        body {
            padding-top: 50px;
            padding-bottom: 20px;
            background-color: #f8f9fa; /* Background color */
        }
        .container {
            max-width: 960px;
            background-color: #ffffff; /* Container background color */
            border-radius: 5px; /* Container border radius */
            box-shadow: 0 4px 8px rgba(0,0,0,.05); /* Container box shadow */
            padding: 20px;
            margin: 0 auto;
            margin-top: 20px;
        }
        .btn-container {
            margin-top: 20px;
        }
        .btn {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Student Dashboard</h1>
        
        <h2>Your Instructors:</h2>
        <ul>
            <!-- Iterate over the student's instructors -->
            <c:forEach var="instructor" items="${student.instructors}">
                <li>${instructor.name}</li>
            </c:forEach>
        </ul>
        
        <h2>Your Courses:</h2>
        <ul>
            <!-- Iterate over the student's courses -->
            <c:forEach var="course" items="${student.courses}">
                <li>${course.name}</li>
            </c:forEach>
        </ul>
        
    </div>
</body>
</html>
