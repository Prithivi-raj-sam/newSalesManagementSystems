<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
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
			<form:button>Search</form:button>
		</div>
	</form:form>
	<button style="font-size: 12px; background-color: #e7e7e7; color: black;" onclick="history.back()">Go Back</button>
	<div>
		<iframe id="alltarget" class="iframe" title='All target'
			src='/target/alltargetbyEmployeeid'
			style='border: 10px solid #25195c'></iframe>
	</div>

	<div>
		<iframe id="current" class="iframeleft" title='Current Target'
			src='/target/goingtarget'
			style='border: 10px solid #25195c'></iframe>
	</div>
</body>
</html>