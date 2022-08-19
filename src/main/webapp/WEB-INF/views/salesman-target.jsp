<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salesman Target</title>
<style type="text/css">
<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
	<form:form action="/target/alltargetfortwodates" method="post"
		modelAttribute="salesInCome">
		<div class="navbar">
			<form:input path="fromDate" placeholder="enter From Ended"
				type="date" />
			<form:input path="toDate" placeholder="enter To Date" type="date" />
			<form:input path="commitedLeads" type="hidden" value="${empId}" />
			<form:button>Search</form:button>
		</div>
	</form:form>
	
	<div>
		<iframe id="alltarget" class="iframe" title='All target'
			src='/target/alltargetbyEmployeeid?empId=${empId}'
			style='border: 10px solid #25195c'></iframe>
	</div>

	<div>
		<iframe id="current" class="iframeleft" title='Current Target'
			src='/target/goingtarget?empId=${empId}'
			style='border: 10px solid #25195c'></iframe>
	</div>
</body>
</html>