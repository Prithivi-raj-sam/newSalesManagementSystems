<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marketing Man Page</title>
<style type="text/css">
	<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="/home/marketeraccount?empId=${empId}">Account</a></li>
			<li><a href="/home/marketerterritory?empId=${empId}">Territory</a></li>
			<li><a href="/home/employeeTarget?empId=${empId}">Target</a></li>
		</ul>
</div>
	
</body>
</html>