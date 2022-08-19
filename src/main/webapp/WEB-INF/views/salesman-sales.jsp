<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salesman Sales</title>
<style type="text/css">
	<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
	
	<form:form action="/sales/getsalesfortwodates" method="post" modelAttribute="salesInCome">
	<div class="navbar">
		
			<a href="/home/addsales?empId=${empId}">Add Sales</a>
			<form:input path="fromDate" placeholder="enter From date" type="date"/>
			<form:input path="toDate" placeholder="enter To Date" type="date"/>
			<form:input path="plannedSales"  type="hidden" value="${empId}"/>
		<form:button>Search</form:button>
</div>		
		</form:form>
		 <div id="sale1"><iframe id="salesman" class="iframe" title='All Sales' src='/sales/getsalesbyemployeeid?empId=${empId}' 
	   style='border:3px solid #25195c' ></iframe></div>
	  
</body>
</html>