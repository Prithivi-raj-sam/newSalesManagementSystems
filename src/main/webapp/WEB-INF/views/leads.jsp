<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>leads And Sales</title>
<style>
<%@include file="/WEB-INF/css/employee.css"%>

</style>
</head>
<body>
<div class="navbar">
			<a href="/leads/allleads">All Leads</a>
			<a href="/account/allaccount?empId=${empId}">All Account</a>
		</div>
		<div>
	  <iframe class="iframe" title='All sales' src='/sales/allsales?empId=${empId}' 
	    ></iframe>
	  </div>
</body>
</html>