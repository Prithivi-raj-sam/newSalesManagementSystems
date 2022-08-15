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
<div class="menu">
<form:form action="/territory/getTerritorybyname" method="post" modelAttribute="territory">
		<ul>
			<li><a href="/home/addterritory">Add Territory</a></li>
			<li><form:input path="territoryName" placeholder="Enter Territory Name" /></li>
			<li><form:button>search</form:button></li>
		</ul>
		</form:form>
		</div>
		<div></div>
		<div><iframe id="allterritory" class="iframe" title='All territory' src='/territory/allterritory?empId=${empId}' 
	   style='border:10px solid #25195c' ></iframe></div>
</body>
</html>