<%@page import="org.springframework.context.support.ResourceBundleMessageSource"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<spring:url value="resources/BootstrapLib/css/bootstrap.min.css" var="BSCss" />
<link rel="stylesheet" href="${BSCss}" />
<spring:url value="resources/BootstrapLib/js/bootstrap.min.js" var="BSJs"></spring:url>
<link rel="stylesheet" href="${BSJs}" />
<spring:url value="resources/css/custom_bootstrap.css" var="custom_bootstrap" />
<link rel="stylesheet" href="${custom_bootstrap}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<fmt:bundle basename="com.bo.labels_en">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="col-lg-offset-1 col-lg-11">
				<ul class="nav navbar-nav nav-pills">
					<li><a href="#"><fmt:message key="home" /></a></li>
					<li><a href="#"><fmt:message key="aboutUs" /></a></li>
				</ul>
				<div class="col-lg-offset-4 col-lg-3">
					<form class="navbar-form" actin="#">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search for..."> <span
								class="input-group-btn">
								<button class="btn btn-secondary" type="submit">Go!</button>
							</span>
						</div>
					</form>
				</div>
			</div>
		</div>
		</nav>
 		<div class="container">
			<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000">
			<ol class="carousel-indicators">
			      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			      <li data-target="#myCarousel" data-slide-to="1" ></li>
		    </ol>
				<div class="carousel-inner">
					<div class="item active">
						<img src="resources/images/getcreditcard.jpg" class="img-respsonsive"/>
					</div>
					<div class="item ">
						<img src="resources/images/getcreditcard1.jpg" class="img-respsonsive"/>
					</div>
				</div>
				<a class="left carousel-control" href="#myCarousel" data-slide="prev">
    				<span class="glyphicon glyphicon-chevron-left"></span>
      				<span class="sr-only">Previous</span>
    			</a>
			    <a class="right carousel-control" href="#myCarousel" data-slide="next">
			     	<span class="glyphicon glyphicon-chevron-right"></span>
			     	<span class="sr-only">Next</span>
			    </a>
			</div>
		</div>
	</fmt:bundle>
<script type="text/javascript">
$(document).ready(function(){
    $('#myCarousel').carousel();
  }); 
</script>
</body>
</html>