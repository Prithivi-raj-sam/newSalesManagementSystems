<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marketing Man Page</title>
<style type="text/css">
	<%@include file="/WEB-INF/css/employees.css"%>
</style>
</head>
<body>
	<div class="navbar">
			<a href="/home/marketeraccount?empId=${empId}">Account</a>
			<a href="/home/marketerterritory?empId=${empId}">Territory</a>
			<a href="/home/employeeTarget?empId=${empId}">Target</a>
</div>
	
</body>
</html>