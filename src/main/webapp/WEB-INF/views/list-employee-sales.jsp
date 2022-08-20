<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List All Sales Of Employee</title>
<style type="text/css">
<%@include file="/WEB-INF/css/allemployee.css" %>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="getEmployee">
				<div class="form">
					<table>
					<caption></caption>
					<tr>
					<th></th></tr>
						<tbody>
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
								<td><label for="passwordLastChangeDate">Password
										Last Change Date</label></td>
								<td><form:input path="passwordLastChangeDate"
										readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="role">Role</label></td>
								<td><form:input path="role" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="profile">Profile</label></td>
								<td><form:input path="profile" readonly="true" type="image" />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
	<div class="table">
		<table>
		<caption></caption>
			<thead>
				<tr style="width: 100%, height:100%">
					<th>Seller Name</th>
					<th>Account Name</th>
					<th>Sales Date</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="allsales" items="${getSales}">
					<tr>
						<td>${allsales.employeeName}</td>
						<td>${allsales.accountName}</td>
						<td>${allsales.salesDate}</td>
						<td>${allsales.amount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>