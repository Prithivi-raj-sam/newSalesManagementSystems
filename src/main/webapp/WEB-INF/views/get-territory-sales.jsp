<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="territory">
				<div class="form">
					<table>
					<caption></caption>
					<tr><th></th></tr>
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
	<div>${result}</div>
</body>
</html>