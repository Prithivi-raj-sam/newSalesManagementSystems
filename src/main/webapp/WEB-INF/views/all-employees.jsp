<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Employees</title>
<style>
<%@include file="/WEB-INF/css/allemployee.css" %>
</style>
</head>
<body>
	<div class="table">
		<table>
		<caption></caption>
			<thead>
				<tr>
					<th>Profile</th>
					<th>Employee Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
					<th>TerritoryId</th>
					<th>Password</th>
					<th>Password Last Change Date</th>
					<th>Role</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allEmployee" items="${allEmployee}">
			
			   <tr>
			   	   <td><img width="30" height="25" src="getImage?id=${allEmployee.employeeId}" alt="image"></td>
			   	  <td>${allEmployee.employeeName}</td>
			   	  <td>${allEmployee.employeePhone}</td>
			   	  <td>${allEmployee.email}</td>
			   	  <td>${allEmployee.address}</td>
			   	  <td>${allEmployee.territoryId}</td>
			   	  <td>${allEmployee.password}</td>
			   	  <td>${allEmployee.passwordLastChangeDate}</td>
			   	  <td>${allEmployee.role}</td>
			   	  <td id="view"><a href="/employee/getemployee?getId=${allEmployee.employeeId}">View</a></td>
			   </tr>
			   
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>