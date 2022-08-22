<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Marketer Territory</title>
<style type="text/css">
	<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
	<div class="menu">
	<form:form action="/territory/getTerritorybyname" method="post" modelAttribute="territory">
		<div class="navbar">
			<a href="/home/addterritory">Add Territory</a>
			<form:button>Search</form:button>
			<form:input path="territoryName" placeholder="Enter Territory Name" />
		</div>
		</form:form>
		<button style="font-size: 12px; background-color: #e7e7e7; color: black;" onclick="history.back()">Go Back</button>
</div>
	<div id="mark1"><iframe id="marketer" class="iframe" title='All target' src='/territory/allterritory' 
	   style='border:10px solid #25195c' ></iframe></div>
</body>
</html>