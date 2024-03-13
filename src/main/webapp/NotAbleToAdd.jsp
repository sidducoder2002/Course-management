<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 20px;
            background-color: #f8f9fa;
        }
        .error-container {
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
        }
        .logout-btn {
            position: absolute;
            top: 10px;
            right: 20px;
            background-color: #dc3545; /* Red color */
            color: #fff; /* White text color */
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <a href="/logout" class="logout-btn btn">Logout</a>
    <div class="container">
        <div class="error-container">
            <h1>Not able add course because Course  is already present </h1>
            <a href="/dashboard" class="logout-btn btn">Back To Dashboard</a>
        </div>
    </div>
</body>
</html>
