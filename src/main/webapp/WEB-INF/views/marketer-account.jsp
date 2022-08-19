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
	<div class="menu">
	<form:form action="/account/getaccountbycompanyname" method="post" modelAttribute="account">
		<ul>
			<li><a href="/account/addaccountform?empId=${empId}">Add Account</a></li>
			<li><form:input path="companyName" placeholder="enter Company Name" /></li>
			<li><form:input path="employeeId" value="${empId}" type="hidden"/></li>
			<li><form:button>search</form:button></li>
		</ul>
		</form:form>
</div>
	<div></div>
	<div id="emp1"><iframe id="allemployee" class="iframe" title='All Employee' src='/account/allaccountbyemployee?empId=${empId}' 
	   style='border:10px solid #25195c' ></iframe></div>
</body>
</html>