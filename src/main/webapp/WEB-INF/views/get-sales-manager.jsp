<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>get Sales By Id In Manager page</title>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="sales">
				<div class="form">
					<table>
						<tbody>
							<tr>
								<td><label for="salesId"> Sales id</label></td>
								<td><form:input path="salesId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="employeeId">Seller Name</label></td>
								<td><form:input path="employeeId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="leadId">Lead Id</label></td>
								<td><form:input path="leadId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="salesDate">sales Date</label></td>
								<td><form:input path="salesDate" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="amount">Amount</label></td>
								<td><form:input path="amount" readonly="true" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>