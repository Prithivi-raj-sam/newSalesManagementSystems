<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Manager Page</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
<%@include file="/WEB-INF/css/employees.css" %>
h1,h3{
color:white;
text-align:center;
font-weight:800;
}

</style>
</head>
<body>
	<form:form action="/sales/salesTotalAmount" method="post"
		modelAttribute="salesIncome">
		<div class="navbar">
			<a href="/home/employees">Employee</a>
			<a href="/home/targets">Target</a> 
			<a
				href="/home/lead">Leads/Sales</a> 
				<a
				href="/home/territorys">Territory</a>
				<form:button id="btn">Income</form:button>
				<form:input path="toDate" type="date" placeholder="Enter To Date" />
			<form:input path="fromDate" type="date" placeholder="Enter From Date" />
		</div>
	</form:form>
	<h1>Manager</h1>
	<h3>Welcome ${employeeName}</h3>
</body>
</html>


