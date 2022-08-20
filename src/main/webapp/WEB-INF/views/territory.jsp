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
			<form:input path="territoryName" placeholder="Enter Territory Name" />
			<form:input path="territoryId"  type="hidden" value="${empId}" />
			<form:button>search</form:button>
</div>
		</form:form>
		<div><iframe class="iframe" title='All territory' src='/territory/allterritory?empId=${empId}' 
	       ></iframe></div>
</body>
</html>