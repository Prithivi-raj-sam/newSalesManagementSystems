<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Audiowide">
<meta charset="ISO-8859-1">
<title>Get Employee By Id</title>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
.img{
margin-left:20%;
width: 150px;
height: 120px; 
border-radius: 50%;
}

</style>
</head>
<body>
	<form:form action="" method="post" modelAttribute="employee">
	<div class="img">
	<img class="img" src="getImage?id=${employee.employeeId}" alt="image">
	
	</div><hr>
		<div class="form">
			<table>
				<caption></caption>
					<tr>
					<th></th></tr>
				<tbody>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><label for="employeeId">Employee id</label></td>
						<td><form:input path="employeeId" readonly="true" /></td>
					</tr>
					<tr>
						<td><label for="employeeName">Employee Name</label></td>
						<td><form:input path="employeeName" readonly="true" /></td>
					</tr>
					<tr>
						<td><label for="employeePhone">Employee Phone</label></td>
						<td><form:input path="employeePhone" readonly="true" /></td>
					</tr>
					<tr>
						<td><label for="email">Email</label></td>
						<td><form:input path="email" readonly="true" /></td>
					</tr>
					<tr>
						<td><label for="address">Address</label></td>
						<td><form:input path="address" readonly="true" /></td>
					</tr>
					<tr>
						<td><label for="territoryId">Territory Id</label></td>
						<td><form:input path="territoryId" readonly="true" /></td>
					</tr>
					<tr>
						<td><label for="password">Password</label></td>
						<td><form:input path="password" readonly="true" /></td>
					</tr>
					<tr>
						<td><label for="passwordLastChangeDate">Password Change Date</label></td>
						<td><form:input path="passwordLastChangeDate" readonly="true" /></td>
					</tr>
					<tr>
						<td><label for="role">Role</label></td>
						<td><form:input path="role" readonly="true" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form:form><br>
	<a href="/employee/updateemployeeform?id=${employee.employeeId}"><button>To Update</button></a>
	<a href="/employee/employeeachievment?id=${employee.employeeId}"><button>Achievement</button></a>
	<a href="/employee/deleteemployee?id=${employee.employeeId}"><button>Delete</button></a>

</body>
</html>