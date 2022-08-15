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
body{
background-size:1366px 768px;
}
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
.menu input{
width:300px;
height:30px;
text-align:center;
border:2px solid black;
} 

.menu button{
width:100px;
height:30px;
text-align:center;
border:2px solid black;
} 

</style>
</head>
<body>
<div class="menu">
	<form:form action="/employee/getemployeebyname" method="post" modelAttribute="employee">
		<ul>
			<li><a href="/home/addemployeeform">Add Employee</a></li>
			<li><form:input path="employeeName" placeholder="Enter Employee Name" /></li>
			<li id="search"><form:button>Search</form:button></li>
		</ul>
		</form:form>
		</div>
		<div>
	  <div id="emp1"><iframe id="allemployee" class="iframe" title='All Employee' src='/employee/allemployee' 
	   style='border:10px solid #25195c' ></iframe></div>
	  </div>
		
</body>
</html>