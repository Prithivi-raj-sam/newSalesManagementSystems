<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Marketing Man Page</title>
<style type="text/css">
	<%@include file="/WEB-INF/css/employees.css"%>
</style>
</head>
<body>
	<div class="navbar">
			<a href="/home/marketeraccount">Account</a>
			<a href="/home/marketerterritory">Territory</a>
			<a href="/home/employeeTarget">Target</a>
</div>
	<h1>Marketer</h1>
	<h3>Welcome ${employeeName}</h3>
</body>
</html>