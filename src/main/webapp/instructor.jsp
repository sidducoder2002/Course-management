<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Instructor Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Instructor Details</h1>
        
        <div class="row">
            <div class="col-md-6">
                <h2>Instructor Information</h2>
                <p><strong>Name:</strong> ${instructor.name}</p>
                <p><strong>Email:</strong> ${instructor.email}</p>
                <p><strong>Qualification:</strong> ${instructor.qualification}</p>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-6">
                <h2>List of Courses Allocated</h2>
                <ul class="list-group">
                    <c:forEach var="course" items="${instructor.courses}">
                        <li class="list-group-item">${course.name}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
