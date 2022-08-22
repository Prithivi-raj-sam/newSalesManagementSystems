<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<style>
<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
<form:form action="/territory/getTerritorybyname" method="post" modelAttribute="territory">
<div class="navbar">
			<a href="/home/addterritory">Add Territory</a>
			<form:button>Search</form:button>
			<form:input path="territoryName" placeholder="Enter Territory Name" />
			
</div>
		</form:form>
		<button style="font-size: 12px; background-color: #e7e7e7; color: black;" onclick="history.back()">Go Back</button>
		<div><iframe class="iframe" title='All territory' src='/territory/allterritory' 
	       ></iframe></div>
</body>
</html>