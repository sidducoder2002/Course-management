<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instructors and Assign Course</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom styles */
        body {
            padding-top: 20px;
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h1 {
            color: #007bff;
            margin-bottom: 20px;
        }
        .logout-btn {
            position: fixed;
            top: 10px;
            right: 10px;
            z-index: 9999;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        ul li {
            margin-bottom: 5px;
        }
        form {
            margin-top: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-primary, .btn-danger {
            width: 150px;
        }
    </style>
</head>
<body>
<a href="/logout" class="logout-btn btn btn-danger">Logout</a>
  
<div class="container">
 <h1 class="display-4">Welcome, ${username}!</h1>
    <div class="row">
        <div class="col-md-12">
            <h1 class="mb-4">Instructor Details</h1>
        </div>
    </div>
    <div class="row mb-4">
        <div class="col-md-12">
            <div class="border rounded p-3 bg-light">
                <p><strong>ID:</strong> ${instructor.id}</p>
                <p><strong>Name:</strong> ${instructor.name}</p>
                <p><strong>Email:</strong> ${instructor.email}</p>
                <p><strong>Contact:</strong> ${instructor.qualification}</p>
            </div>
        </div>
    </div>
    <div class="row mb-4">
        <div class="col-md-12">
            <div class="border rounded p-3 bg-light">
                <h2>Your Courses:</h2>
                <ul class="mb-0">
                    <c:forEach var="course" items="${instructor.courses}">
                        <li>${course.name}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <div class="row mb-4">
        <div class="col-md-12">
            <div class="border rounded p-3 bg-light">
                <h2>Your Students:</h2>
                <ul class="mb-0">
                    <c:forEach var="student" items="${students}">
                        <li>${student.name}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <form action="/assigncoursetostudent" method="post">
                <div class="form-row mt-4">
                    <div class="form-group col-md-6">
                        <label for="studentId">Select Student:</label>
                        <select name="studentId" id="studentId" class="form-control">
                            <c:forEach var="student" items="${allstudennts}">
                                <option value="${student.id}">${student.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="courseId">Select Course:</label>
                        <select name="courseId" id="courseId" class="form-control">
                            <c:forEach var="course" items="${courses}">
                                <option value="${course.id}">${course.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Assign Course</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
