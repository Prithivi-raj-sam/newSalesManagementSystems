<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Page</title>
<style>

</style>
<style type="text/css">
`	<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="/home/employees">Employee</a></li>
			<li><a href="/home/targets">Target</a></li>
			<li><a href="/home/lead?empId=${empId}">Leads and Sales</a></li>
			<li><a href="/territory/allterritory?empId=${empId}">Territory</a></li>
		</ul>
</div>
</body>
</html>


