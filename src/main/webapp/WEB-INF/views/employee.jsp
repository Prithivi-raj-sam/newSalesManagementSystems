<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<style>
<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
	<form:form action="/employee/getemployeebyname" method="post"
		modelAttribute="employee">
		<div class="navbar">
			<a href="/home/addemployeeform">Add Employee</a>
			<form:input path="employeeName" placeholder="Enter Employee Name" />
			<form:button>Search</form:button>
		</div>
		</form:form>
		<div>
				<iframe id="allemployee" class="iframe" title='All Employee'
					src='/employee/allemployee'></iframe>
</div>
	
</body>
</html>