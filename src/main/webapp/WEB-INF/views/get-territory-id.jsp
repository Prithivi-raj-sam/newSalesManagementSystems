<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Get Territory By Id</title>
<script>
<%@include file="/WEB-INF/script/territoryValidation.js"%>
</script>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="territory"
				name="form">

				<div class="form">
					<table>
						<tbody>
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
	<div>${result}</div>
	<div>
		<a href="/territory/updateterritoryform?id=${territory.territoryId}"><button>update</button></a>
		<a href="/territory/deleteterritory?id=${territory.territoryId}"><button>delete</button></a>
	</div>
</body>
</html>