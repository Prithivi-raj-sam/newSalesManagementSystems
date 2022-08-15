<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
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
		<ul>
			<li><a href="/home/addterritory">Add Territory</a></li>
			<li><form:input path="territoryName" placeholder="enter Territory Name" /></li>
			<li><form:button>search</form:button></li>
		</ul>
		</form:form>
</div>
	<div id="mark1"><iframe id="marketer" class="iframe" title='All target' src='/territory/allterritory?empId=${empId}' 
	   style='border:10px solid #25195c' ></iframe></div>
</body>
</html>