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
			<a href="/account/addaccountform">Add Account</a>
			<form:button>Search</form:button>
			<form:input path="employeeId" value="${empId}" type="hidden"/>
			<form:input path="companyName" placeholder="Enter Company Name" />
			</div>
		</form:form>
		<button style="font-size: 12px; background-color: #e7e7e7; color: black;" onclick="history.back()">Go Back</button>
	<div id="emp1">
	<iframe id="allemployee" class="iframe" title='All Employee' src='/account/allaccountbyemployee?empId=${empId}' 
	   style='border:3px solid #25195c' ></iframe></div>
	   <div><iframe id="current" class="iframeleft" title='High Account Employee' src='/employee/getemployeebyaccountcount' 
	   style='border:3px solid #25195c' ></iframe></div>
</body>
</html>