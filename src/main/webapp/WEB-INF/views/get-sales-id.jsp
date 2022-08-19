<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body>
<h1>Sales Details</h1>
			<form:form action="" method="post" modelAttribute="sales">
				<div class="sales-form">
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
								<td><label for="salesDate">Sales Date</label></td>
								<td><form:input path="salesDate" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="amount">Amount</label></td>
								<td><form:input path="amount" readonly="true" /></td>
							</tr>
						</tbody>
					</table>
					</form:form>
					<br><br>
					<a href="/sales/updatesalesform?id=${sales.salesId}"><button>Update</button></a>
		<a href="/sales/deletesales?id=${sales.salesId}"><button>Delete</button></a>
				</div>
			
</body>
</html>