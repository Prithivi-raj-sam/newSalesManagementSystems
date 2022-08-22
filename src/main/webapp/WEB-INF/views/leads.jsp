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
			<a href="/account/allaccount">All Account</a>
		</div>
		<div>
	  <iframe class="iframe" title='All sales' src='/sales/allsales' 
	     style='border:3px solid #25195c' ></iframe>
	  </div>
	  <div><iframe id="current" class="iframeleft" title='High Sales Employee' src='/employee/getemployeebyhighsales' 
	   style='border:3px solid #25195c' ></iframe></div>
</body>
</html>