<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
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
			<form:button>Search</form:button>
			<form:input path="plannedLeads" type="hidden" value="${empId}"/>
			<form:input path="toDate" placeholder="Enter Leads To date" type="date"/>
			<form:input path="fromDate" placeholder="Enter Leads From date" type="date"/>
			</div>
		</form:form>
		<button style="font-size: 12px; background-color: #e7e7e7; color: black;" onclick="history.back()">Go Back</button>
	<div>
	<div id="emp1"><iframe id="allleads" class="iframe" title='All Leads' src='/leads/allleadsbyemployeeid' 
	   style='border:10px solid #25195c' ></iframe></div>
	</div>
</body>
</html>