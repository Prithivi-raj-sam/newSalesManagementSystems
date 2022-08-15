<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	<%@include file="/WEB-INF/css/employee.css"%>
</style>
</head>
<body>
	<div class="menu">
	<form:form action="/target/alltargetfortwodates" method="post" modelAttribute="salesInCome">
		<ul>
			<li><form:input path="fromDate" placeholder="enter From Ended" type="date"/></li>
			<li><form:input path="toDate" placeholder="enter To Date" type="date"/></li>
			<li><form:input path="commitedLeads" type="hidden" value="${empId}" /></li>
			<li><form:button>search</form:button></li>
		</ul>
		</form:form>
</div>
	<div></div>
	<div><iframe id="alltarget" class="iframe" title='All target' src='/target/alltargetbyEmployeeid?empId=${empId}' 
	   style='border:10px solid #25195c' ></iframe></div>
	   
	   <div><iframe id="current" class="iframeleft" title='Current Target' src='/target/goingtarget?empId=${empId}' 
	   style='border:10px solid #25195c' ></iframe></div>
</body>
</html>