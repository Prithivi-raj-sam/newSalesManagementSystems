<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Accounts By Territory Id</title>
<style>
<%@include file="/WEB-INF/css/allemployee.css" %>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="getTerritory">
				<div class="form">
					<table>
						<tbody>
							<tr>
								<td><label for="territoryId">Territory id</label></td>
								<td><form:input path="territoryId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="territoryName">Territory Name</label></td>
								<td><form:input path="territoryName" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="noOfCustomer">No Of Customer</label></td>
								<td><form:input path="noOfCustomer" readonly="true" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
	<div class="table">
		<table>
			<thead>
				<tr style="width: 100%, height:100%">
					<th>Account Id</th>
					<th>Company Name</th>
					<th>Contact Person</th>
					<th>Contact Person Role</th>
					<th>Email</th>
					<th>Contact Person Phone</th>
					<th>Address</th>
					<th>Account Type</th>
					<th>Market Id</th>
					<th>Lead Through Channel</th>
					<th>Customer Join Date</th>
					<th>Territory Id</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="getAccounts" items="${getAccounts}">
					<tr>
						<td>${getAccounts.accountId}</td>
						<td>${getAccounts.companyName}</td>
						<td>${getAccounts.contactPerson}</td>
						<td>${getAccounts.contactPersonRole}</td>
						<td>${getAccounts.email}</td>
						<td>${getAccounts.contactPersonPhone}</td>
						<td>${getAccounts.address}</td>
						<td>${getAccounts.accountType}</td>
						<td>${getAccounts.employeeId}</td>
						<td>${getAccounts.leadThroughChannel}</td>
						<td>${getAccounts.customerJoinDate}</td>
						<td>${getAccounts.territoryId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>