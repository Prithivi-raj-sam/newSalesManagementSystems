<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Target</title>
</head>
<style type="text/css">
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
<body>
	<h3>Current Target</h3>
			<form:form action="" method="post" modelAttribute="target">
				<div class="form">
					<table>
					<caption></caption>
					<tr>
					<th></th></tr>
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
								<td><label for="managerComment">Manager Comment</label></td>
								<td><form:input path="managerComment" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="targetSetDate">Target Set Date</label></td>
								<td><form:input path="targetSetDate" readonly="true" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
</body>
</html>