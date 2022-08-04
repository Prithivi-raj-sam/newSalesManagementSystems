<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Employee And Territory</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="getTerritory">
				<div>
					<label for="territoryId">Territory id</label>
					<div>
						<form:input path="territoryId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="territoryName">Territory Name</label>
					<div>
						<form:input path="territoryName" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="noOfCustomer">No Of Customer</label>
					<div>
						<form:input path="noOfCustomer" readonly="true"/>
					</div>
				</div>
				
			</form:form>
		</div>
	</div>
	<div id="table root">
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
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allEmployee" items="${getEmployee}">
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
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>