<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "java.util.*" %>
<%@ page import = "edu.mum.cs.cs472.service.impl.FoodServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select meals</title>
</head>
<body>
	<% FoodServiceImpl foodServiceImpl = new FoodServiceImpl(); %>
	<table cellpadding="2" cellspacing="2" border="0">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>Price</th>
			<th>Order</th>
		</tr>
		<c:forEach var="f" items="<%=foodServiceImpl.getAllFood()%>">
			<tr>
				<td>${f.foodId}</td>
				<td>${f.name}</td>
				<td>${f.type}</td>
				<td>${f.price}</td>
				<td align="center"><a href="order?id=${f.foodId}&action=add">Order Now</a></td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>