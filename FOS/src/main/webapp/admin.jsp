<%--
  Created by IntelliJ IDEA.
  User: mandu
  Date: 11/19/2019
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Admin Page</title>
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/manduul.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<a href="${pageContext.request.contextPath}/logout" class="btn btn-primary mb-2 float-right">Logout</a>
		<h1 class="my-4">Welcome to Admin Panel</h1>
		<!-- Marketing Icons Section -->
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Orders</a></li>
			<li class="nav-item"><a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Users</a></li>
			<li class="nav-item"><a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false">Foods</a></li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
				<div class="col-lg-12">
					<h4>New Orders</h4>
					<table width="100%" class="table table-striped">
						<tr>
							<th>#</th>
							<th>Foods</th>
							<th>Total</th>
							<th>Created at</th>
							<th></th>
						</tr>
						<c:set var="total" value="0" scope="session" />
						<c:forEach items="${orderList}" var="order" varStatus="loop">
							<c:set var="total" value="${total + order.totalAmount}" />
							<tr>
								<td>${loop.index+1}</td>
								<td>
									<c:forEach items="${order.getFoods()}" var="food" varStatus="loop">
										<p>
											<c:out value="${food.name}" />
											|
											<c:out value="${food.calories}" />
											kcal | Type:
											<c:out value="${food.type}" />
										</p>
									</c:forEach>
								</td>
								<td>$${order.totalAmount}</td>
								<td>${order.created}</td>
								<td>
									<c:if test="${order.status eq 1}">
										<button type="button" class="order-btn btn status-btn btn-warning" order-id="${order.orderId}">Process the order</button>
								</td>
								</c:if>
								<c:if test="${order.status eq 0}">
									<button type="button" class="order-btn btn status-btn btn-success" disabled order-id="${order.orderId}">Already Served</button>
									</td>
								</c:if>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5" style="font-size: 20px; font-weight: 700;" align="right">$${total}</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
				<div class="user-table-container col-md-12">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">First Name</th>
								<th scope="col">Last Name</th>
								<th scope="col">Email</th>
								<th scope="col">Role</th>
								<th scope="col">Created</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="user" varStatus="loop">
								<tr>
									<td scope="row">
										<c:out value="${loop.index+1}" />
									</td>
									<td>
										<c:out value="${user.first_name}" />
									</td>
									<td>
										<c:out value="${user.last_name}" />
									</td>
									<td>
										<c:out value="${user.email}" />
									</td>
									<td>
										<c:out value="${user.role}" />
									</td>
									<td>
										<c:out value="${user.created}" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
				<div class="col-lg-12 mb-4">
					<div class="card h-100">
						<h4 class="card-header">Food List</h4>
						<a href="food.jsp">
							<button type="button" class="btn btn-primary" style="width: 100%;">Add New</button>
						</a>
						<div class="card-body">
							<ul class="list-group">
								<c:forEach items="${foodList}" var="food" varStatus="loop">
									<li food-id="${food.foodId}" class="list-group-item d-flex justify-content-between align-items-center">
										<div style="max-width: 80%;">
											<p>
												Name :
												<c:out value="${food.name}" />
											</p>
											<p>
												Description :
												<c:out value="${food.description}" />
											</p>
										</div>
										<div>
											<form method="POST" action="editFood" id="button-form" style="display: inline-block;">
												<input value="${food.foodId}" name="foodID" style="visibility: hidden; width: 50px;">
												<button type="submit" class="btn m-btn food-edit">
													<i class="fa fa-edit"></i>
												</button>
											</form>
											<form method="POST" action="deleteFood" style="display: inline-block; width: 50px;">
												<input value="${food.foodId}" name="foodID" style="visibility: hidden;">
												<button type="submit" class="btn m-btn food-delete">
													<i class="fa fa-close"></i>
												</button>
											</form>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
						<div class="card-footer"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script>
	$(document)
			.ready(
					function() {
						$('.status-btn')
								.on(
										'click',
										function() {
											console.log($(this)
													.attr('order-id'));
											$
													.ajax({
														url : "${pageContext.request.contextPath}/orderStatus?orderId="
																+ $(this)
																		.attr(
																				'order-id'),
														type : "POST",
														data : {
															orderId : $(this)
																	.attr(
																			'order-id')
														},
														contentType : false,
														cache : false,
														processData : false,
														success : function(data) {
															console.log(data);
															if (data == "okay")
																window.location
																		.replace("${pageContext.request.contextPath}/admin");
														},
														error : function(error) {
															console.log(error);
														}
													});
										})
					});
</script>


