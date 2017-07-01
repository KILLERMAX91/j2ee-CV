<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<!-- 
		Il faut utilisé NPM et YARN (NodeJS)
	 -->
	<script src="<%=request.getContextPath()%>/bower_components/jquery/dist/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bower_components/bootstrap/dist/css/bootstrap.min.css">

	<!-- datetimepicker -->
 	<script type="text/javascript" src="<%=request.getContextPath()%>/bower_components/moment/min/moment.min.js"></script>
 	<script type="text/javascript" src="<%=request.getContextPath()%>/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />
</head>
<body>
<div class="container-fluid">