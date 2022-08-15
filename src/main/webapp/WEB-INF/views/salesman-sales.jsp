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

.iframe {
    position: absolute;
 	top:65%;
    right: 0%;
    width: 1000px;
    height: 500px;
    margin-top: -400px;
    margin-right: 20px;
    z-index: 999;
    border-radius:20px;
} 
</style>
</head>
<body>
	<div class="menu">
	<form:form action="/sales/getsalesfortwodates" method="post" modelAttribute="salesInCome">
		<ul>
			<li><a href="/home/addsales?empId=${empId}">Add Sales</a></li>
			<li><form:input path="fromDate" placeholder="enter From date" type="date"/></li>
			<li><form:input path="toDate" placeholder="enter To Date" type="date"/></li>
			<li><form:input path="plannedSales"  type="hidden" value="${empId}"/></li>
			<li><form:button>search</form:button></li>
		</ul>
		
		</form:form>
		<div></div>
		 <div id="sale1"><iframe id="salesman" class="iframe" title='All Sales' src='/sales/getsalesbyemployeeid?empId=${empId}' 
	   style='border:10px solid #25195c' ></iframe></div>
	  
</div>
</body>
</html>