<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales man Page</title>
<style>
<%@include file="/WEB-INF/css/employees.css"%>
</style>
</head>
<body>
	<div class="navbar">>
			<a href="/home/employeeTarget?empId=${empId}">Target</a>
			<a href="/home/salesmanSales?empId=${empId}">Sales</a>
			<a href="/home/salesmanLeads?empId=${empId}">Leads</a>
	 </div>
</body>
</html>