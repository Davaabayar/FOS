<%--
  Created by IntelliJ IDEA.
  User: mandu
  Date: 11/19/2019
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Food Form</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/manduul.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <%@ include file="fragments/header.jsp" %>
    <%@ include file="upload.jsp" %>

    <div class="container">
        <form style="margin-top: 22px;" action="">
            <div class="form-group">
                <label for="name">Food Name</label>
                <input type="text" class="form-control" id="name" name="foodName" placeholder="Food Name">
            </div>
            <div class="form-group">
                <label for="calories">Calories</label>
                <input type="text" class="form-control" id="calories" name="calories" placeholder="Calories">
            </div>
            <div class="form-group">
                <label for="foodType">Food Type</label>
                <select class="form-control" id="foodType" name="foodType">
                    <option>Keto</option>
                    <option>Vegetarian</option>
                    <option>Gluton free</option>
                    <option>Family</option>
                    <option>Paleo</option>
                    <option>Free Style</option>
                </select>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>
