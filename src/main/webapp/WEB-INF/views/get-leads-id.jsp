<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Get Leads By Id</title>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>

</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="leads">
				<div class="form">
					<table>
						<tbody>
							<tr>
								<td><label for="leadId">Lead Id</label></td>
								<td><form:input path="leadId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="accountId">Account Id</label></td>
								<td><form:input path="accountId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="status">Status</label></td>
								<td></td>
							</tr>
							<tr>
								<td><label for="employeeId">SellerId</label></td>
								<td><form:input path="employeeId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="leadDate">Lead Date</label></td>
								<td><form:input path="leadDate" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="stages">Stage</label></td>
								<td><form:input path="stages" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="propability">Probability</label></td>
								<td><form:input path="propability" readonly="true" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>