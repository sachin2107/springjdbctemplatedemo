<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<spring:url value="resources/BootstrapLib/css/bootstrap.min.css" var="BS_css" />
<link rel="stylesheet" href="${BS_css}" />
<meta charset="utf-8">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container" style="background-color:silver;">

	<div class="row" style="background-color:aqua;">
		<div class="col-lg-6">
        	<ul class="nav nav-tabs nav-justified">
        		<li class="active"><a href="#"><span class="glyphicon glyphicon-home"> Home</span></a></li>
        		<li><a href="#">About Us</a></li>
        		<li><a href="#"><span class="glyphicon glyphicon-earphone"> Contact</span></a></li>
        	</ul>
        </div>
    </div>	
    	<br/>
    	<div class="row">
        <form action="/Project1/log" method="post" class="form-horizontal" role="form">
            <div class="form-group row">
            	<label class="col-lg-2 col-lg-offset-2 control-label text-right" for="uname">Username: </label>
                <div class="col-lg-4">
                	<div class="input-group">
                    	<input type="text" class="form-control" name="name" id="uname""/>
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        			</div>
                </div>
                
            </div>
            <div class="form-group row">
            	<label class="col-lg-2 col-lg-offset-2 control-label text-right" for="id">Password: </label>
                <div class="col-lg-4">
                	<input type="text" class="form-control" id="id" name="id"/>
        		</div>
            </div>
            <div class="form-group row">
            		<p class="col-lg-12" style="font-size:1.5em;text-align:center;"><a href="signup">Sign Up</a></p>
            </div>
            <div class="form-group row">
            	<div class="col-lg-2 col-lg-offset-5 ">
            	<input type="submit" class="btn btn-primary col-lg-12" value="Login"/>
            	</div>
            </div>
        </form>
 
 </div>
</div>
</body>
</html>