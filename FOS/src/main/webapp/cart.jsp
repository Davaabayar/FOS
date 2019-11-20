<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="selectfood.jsp">Add more items</a>
	<table cellpadding="2" cellspacing="2" border="0">
		<tr>
			<th>Option</th>
			<th>Id</th>
			<th>Name</th>			
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub total</th>
		</tr>
		<c:set var = "total" value="0"  scope = "session" />
		<c:forEach var="item" items="${sessionScope.cart}">
			<c:set var = "total" value = "${total + item.food.price * item.quantity}"/>
			<tr>
				<td align="center"><a  href="CartServlet?id=${item.food.foodId}&action=delete">Delete</a></td>
				<td>${item.food.foodId}</td>
				<td>${item.food.name}</td>
				<td>${item.food.price}</td>
				<td>${item.quantity}</td>
				<td>${item.food.price * item.quantity}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">${total}</td>
		</tr>		
	</table>
	<a href="checkout">Check out</a>
</body>
</html>