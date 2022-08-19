<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Get All Leads By Account Id</title>
<style>
<%@include file="/WEB-INF/css/allemployee.css" %>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="getaccount">
				<div class="form">
					<table>
					<caption></caption>
					<tr>
					<th></th></tr>
						<tbody>
							<tr>
								<td><label for="accountId"> Account id</label></td>
								<td><form:input path="accountId" readonl="true" /></td>
							</tr>
							<tr>
								<td><label for="companyName">Company Name</label></td>
								<td><form:input path="companyName" readonl="true" /></td>
							</tr>
							<tr>
								<td><label for="contactPerson">Contact Person</label></td>
								<td><form:input path="contactPerson" readonl="true" /></td>
							</tr>
							<tr>
								<td><label for="contactPersonRole">COntact Person
										Role</label></td>
								<td><form:input path="contactPersonRole" readonl="true" />
								</td>
							</tr>
							<tr>
								<td><label for="email">Email</label></td>
								<td><form:input path="email" readonl="true" /></td>
							</tr>
							<tr>
								<td><label for="contactPersonPhone">Contact Person
										Phone</label></td>
								<td><form:input path="contactPersonPhone" readonl="true" />
								</td>
							</tr>
							<tr>
								<td><label for="address">Address</label></td>
								<td><form:input path="address" readonl="true" /></td>
							</tr>
							<tr>
								<td><label for="accountType">Account Type</label></td>
								<td><form:input path="accountType" readonl="true" /></td>
							</tr>
							<tr>
								<td><label for="employeeId">Market Id</label></td>
								<td><form:input path="employeeId" readonl="true" /></td>
							</tr>
							<tr>
								<td><label for="leadThroughChannel">Lead Though
										Channel</label></td>
								<td><form:input path="leadThroughChannel" readonl="true" />
								</td>
							</tr>
							<tr>
								<td><label for="customerJoinDate">Customer Join
										Date</label></td>
								<td><form:input path="customerJoinDate" readonl="true" /></td>
							</tr>
							<tr>
								<td><label for="territoryId">Territory Id</label></td>
								<td><form:input path="territoryId" readonl="true" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
	<div id="table root">
		<table>
		<caption></caption>
			<thead>
				<tr style="width: 100%, height:100%">
					<th>Lead Id</th>
					<th>Account Id</th>
					<th>Status</th>
					<th>Seller Id</th>
					<th>Lead Date</th>
					<th>Stages</th>
					<th>Probability</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="allLeads" items="${getlead}">
					<tr>
						<td>${allLeads.leadId}</td>
						<td>${allLeads.accountId}</td>
						<td>${allLeads.status}</td>
						<td>${allLeads.employeeId}</td>
						<td>${allLeads.leadDate}</td>
						<td>${allLeads.stages}</td>
						<td>${allLeads.propability}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>