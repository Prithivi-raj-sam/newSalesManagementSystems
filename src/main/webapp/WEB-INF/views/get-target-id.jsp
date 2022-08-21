<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Get Target By Id</title>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body>
			<form:form action="" method="post" modelAttribute="target">
				<div class="form">
					<table>
					<caption></caption>
					<tr><th></th></tr>
						<tbody>
							<tr>
								<td><label for="targetDate">Target Date</label></td>
								<td><form:input path="targetDate" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="plannedTarget">Planned Target</label></td>
								<td><form:input path="plannedTarget" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="closedTarget">Closed Target</label></td>
								<td><form:input path="closedTarget" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="employeeId">Employee Id</label></td>
								<td><form:input path="employeeId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="managerComment">Manager Comment</label></td>
								<td><form:input path="managerComment" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="targetSetDate">Target Month</label></td>
								<td><form:input path="targetSetDate" readonly="true" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
			<a href="/target/updatetargetform?targetId=${target.targetId}"><button>Update</button></a>
		<a href="/target/deleteTarget?targetId=${target.targetId}"><button>Delete</button></a>
	<div>${result}</div>
</body>
</html>