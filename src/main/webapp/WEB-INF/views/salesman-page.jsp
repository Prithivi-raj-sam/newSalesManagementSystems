<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales man Page</title>
<style>
<%@include file="/WEB-INF/css/employee.css"%>

</style>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="/target/alltargetbyEmployeeid?empId=${empId}">Target</a></li>
			<li><a href="/home/salesmanSales?empId=${empId}">Sales</a></li>
			<li><a href="/home/salesmanLeads">Leads</a></li>
		</ul>
	
	 </div>
</body>
</html>