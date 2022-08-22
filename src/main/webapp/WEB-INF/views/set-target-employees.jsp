<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Set Target For Employee</title>
<style>
<%@include file="/WEB-INF/css/employee.css"%>
<%@include file="/WEB-INF/css/allemployee.css" %>
</style>
</head>
<body style="background-color: #c4f4f5; color: white;">

	<form:form action="/employee/getemployeebyname" method="post"
		modelAttribute="employeeDetail">
			<div class="navbar">
			<form:input path="employeeName" placeholder="enter Employee Name" />
			<form:button>search</form:button>
		</div>
	</form:form>
<button style="font-size: 12px; background-color: #e7e7e7; color: black;" onclick="history.back()">Go Back</button>
	<div class="table">
		<table>
		<caption></caption>
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
						<td id="view"><a
							href="/target/addtargetform?id=${allEmployee.employeeId}"><button>SetTarget</button></a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>