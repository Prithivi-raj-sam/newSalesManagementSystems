<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employees</title>
<style>
table,th,td{
text-align:center;
border:3px solid black;
 border-collapse: collapse;
}

</style>
</head>
<body style="background-color:#c4f4f5; color:#0e5a5c;">
	<div class="table">
		<table>
			<thead>
				<tr style="width:100% , height:100%">
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
					<th>View</th>
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
			   	  <td><a href="/employee/getemployee?getId=${allEmployee.employeeId}"><button>View</button></a></td>
			   </tr>
			   
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>