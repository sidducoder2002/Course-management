<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
    prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oops!</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
    background-color: #f8f9fa;
}

.error-container {
    margin-top: 50px;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    max-width: 500px; /* Adjust width as needed */
}

.error-container:hover {
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    transition: box-shadow 0.3s ease;
}
</style>
</head>
<body>
    <div class="container">
        <div class="error-container">
            <p><strong>Message:</strong> ${message}</p>
            <p><strong>Error:</strong> ${error}</p>
            <p><strong>Status:</strong> ${status}</p>
            <p><strong>Date:</strong> ${timestamp}</p>
            <p><strong>Exception:</strong> ${exception}</p>
            <p><strong>StackTrace:</strong> ${trace}</p>
            <br> <br>
            <sec:authorize access="hasRole('ADMIN')">
                <i><a href="/dashboard">Back to Admin Panel</a></i>
            </sec:authorize>

            <sec:authorize access="hasRole('INSTRUCTOR')">
                <i><a href="/instructor">Back to Instructor Panel</a></i>
            </sec:authorize>

            <sec:authorize access="hasRole('STUDENT')">
                <i><a href="/student">Back to Student Panel</a></i>
            </sec:authorize>

        </div>
    </div>
</body>
</html>
