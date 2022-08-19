<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Marketer Account</title>
<style type="text/css">
	<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
	
	<form:form action="/account/getaccountbycompanyname" method="post" modelAttribute="account">
		<div class="navbar">
			<a href="/account/addaccountform?empId=${empId}">Add Account</a>
			<form:input path="companyName" placeholder="Enter Company Name" />
			<form:input path="employeeId" value="${empId}" type="hidden"/>
			<form:button>Search</form:button>
			</div>
		</form:form>
	<div id="emp1">
	<iframe id="allemployee" class="iframe" title='All Employee' src='/account/allaccountbyemployee?empId=${empId}' 
	   style='border:10px solid #25195c' ></iframe></div>
</body>
</html>