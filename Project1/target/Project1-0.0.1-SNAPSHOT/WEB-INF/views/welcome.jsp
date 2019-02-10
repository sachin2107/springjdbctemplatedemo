<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<spring:url value="resources/BootstrapLib/css/bootstrap.min.css" var="BSCss" />
<link rel="stylesheet" href="${BSCss}" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container-fluid" style="height: 20px;">
		<div class="row">
			<!-- <div class="col-lg-3 text-right">
				<ul class="nav navbar-nav nav-pills">
					<li><a href="signup"><fmt:message key="signUp" /></a></li>
					<li><a href="#"><fmt:message key="login" /></a></li>
					<li><a href="#"><p id="logout"><fmt:message key="logout" />
							</p></a></li>
				</ul>
			</div> -->
			welcome
		</div>

		<div class="row" style="background-color: yellow; height: 80px;">
			<div class="col-xs-12">.col-12 .col-md-8</div>
		</div>
	</div>
</body>
</html>