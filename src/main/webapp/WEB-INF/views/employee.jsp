<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<style>
<%@include file="/WEB-INF/css/employee.css"%>
#emp1{
float:right
}
 
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
	<form:form action="/employee/getemployeebyname" method="post" modelAttribute="employee">
		<ul>
			<li><a href="/home/addemployeeform">Add Employee</a></li>
			<li><form:input path="employeeName" placeholder="enter Employee Name" /></li>
			<li><form:button>search</form:button></li>
		</ul>
		</form:form>
		</div>
		<div>
	  <div id="emp1"><iframe id="allemployee" class="iframe" title='All Employee' src='/home/getallemplyee' 
	   style='border:10px solid #25195c' ></iframe></div>
	  </div>
		
</body>
</html>