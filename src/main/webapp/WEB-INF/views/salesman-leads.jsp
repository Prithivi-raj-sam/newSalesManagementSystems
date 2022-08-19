<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salesman Leads</title>
<style type="text/css">
	<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
	
	<form:form action="/leads/getleadsbytwodates" method="post" modelAttribute="salesInCome">
	<div class="navbar">
		
			<a href="/home/addleads?empId=${empId}">Add Leads</a>
			<form:input path="fromDate" placeholder="Enter Leads From date" type="date"/>
			<form:input path="toDate" placeholder="Enter Leads To date" type="date"/>
			<form:input path="plannedLeads" type="hidden" value="${empId}"/>
			<form:button>Search</form:button>
			</div>
		</form:form>
	<div>
	<div id="emp1"><iframe id="allleads" class="iframe" title='All Leads' src='/leads/allleads?empId=${empId}' 
	   style='border:10px solid #25195c' ></iframe></div>
	</div>
</body>
</html>