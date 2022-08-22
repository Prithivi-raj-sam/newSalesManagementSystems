<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Sales man Page</title>
<style>
<%@include file="/WEB-INF/css/employees.css"%>
</style>
</head>
<body>
	<div class="navbar">
			<a href="/home/employeeTarget">Target</a>
			<a href="/home/salesmanSales">Sales</a>
			<a href="/home/salesmanLeads">Leads</a>
	 </div>
	 <h1>Sales Man</h1>
	<h3>Welcome ${employeeName}</h3>
</body>
</html>