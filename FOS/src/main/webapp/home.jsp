<%--
  Created by IntelliJ IDEA.
  User: tuvsh
  Date: 11/19/2019
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<html>
<head>
<title>HOME</title>
</head>
<body>
	<header>
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div id="logo">
						<a href="index.html"><img id="logo_img" class="img-fluid"
							src="assets/images/logo/logo-white.png" alt="logo" title="logo"></a>
					</div>
				</div>
			</div>
		</div>
	</header>
	${email} ${firstName}
	<c:choose>
		<c:when test="${empty user}">
	        I see!  You don't have a name.. well.. Hello no name
	    </c:when>
		<c:otherwise>
			<%@ include file="response.jsp"%>
		</c:otherwise>
	</c:choose>
	<%@ include file="fragments/header.jsp"%>
</body>
</html>
