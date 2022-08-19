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

<form:form action="/target/gettargetbydate" method="post" modelAttribute="target">
<div class="navbar">
			<a href="/home/addTarget">Add Target</a>
			<form:input path="targetDate"  type="date" placeholder="from date"/>
			<form:input path="targetSetDate" type="date" placeholder="To date" />
			<form:button>search</form:button>
</div>
		</form:form>
		<div>
		<iframe class="iframe" title='All Employee' src='/home/getalltarget' ></iframe>
	  </div>
	  <div>
		<iframe id="current" class="iframeleft" title='Today Target'
			src='/target/todaytarget'
			></iframe>
	</div>
</body>
</html>