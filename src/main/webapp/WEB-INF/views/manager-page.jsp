<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Page</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
<%@include file="/WEB-INF/css/employees.css" %>
</style>
</head>
<body>
	<form:form action="/sales/salesTotalAmount" method="post"
		modelAttribute="salesIncome">
		<div class="navbar">
			<a href="/home/employees">Employee</a>
			<a href="/home/targets">Target</a> 
			<a
				href="/home/lead?empId=${empId}">Leads/Sales</a> 
				<a
				href="/home/territorys?empId=${empId}">Territory</a>
			<form:input path="fromDate" type="date" placeholder="Enter From Date" />
			<form:input path="toDate" type="date" placeholder="Enter To Date" />
			<form:button id="btn">Income</form:button>
		</div>
	</form:form>
</body>
</html>


