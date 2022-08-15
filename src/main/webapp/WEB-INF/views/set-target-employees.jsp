<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Target For Employee</title>
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
<body style="background-color: #c4f4f5; color: white;">
<div class="menu">
	<form:form action="/employee/getemployeebyname" method="post"
		modelAttribute="employeeDetail">
		<ul>
			<li><form:input path="employeeName" placeholder="enter Employee Name" /></li>
			<li><form:button>search</form:button></li>
		</ul>
	</form:form>
	</div>
	<div id="table root">
		<table>
			<thead>
				<tr style="width: 100%, height:100%">
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
					<th>TerritoryId</th>
					<th>Password</th>
					<th>Password Last Change Date</th>
					<th>Role</th>
					<th>Profile</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="allEmployee" items="${allEmployee}">

					<tr>
						<td>${allEmployee.employeeId}</td>
						<td>${allEmployee.employeeName}</td>
						<td>${allEmployee.employeePhone}</td>
						<td>${allEmployee.email}</td>
						<td>${allEmployee.address}</td>
						<td>${allEmployee.territoryId}</td>
						<td>${allEmployee.password}</td>
						<td>${allEmployee.passwordLastChangeDate}</td>
						<td>${allEmployee.role}</td>
						<td>${allEmployee.profile}</td>
						<td><a
							href="/target/addtargetform?id=${allEmployee.employeeId}"><button>SetTarget</button></a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>