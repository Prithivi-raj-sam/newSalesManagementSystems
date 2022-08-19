<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Get Marketer For Marketer</title>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>

</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="account">
				<div class="form">
					<table>
					<caption></caption>
					<tr>
					<th></th></tr>
						<tbody>
							<tr>
								<td><label for="accountId"> Account id</label></td>
								<td><form:input path="accountId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="companyName">Company Name</label></td>
								<td><form:input path="companyName" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="contactPerson">Contact Person</label></td>
								<td><form:input path="contactPerson" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="contactPersonRole">COntact Person
										Role</label></td>
								<td><form:input path="contactPersonRole" readonly="true" />
								</td>
							</tr>
							<tr>
								<td><label for="email">Email</label></td>
								<td><form:input path="email" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="contactPersonPhone">Contact Person
										Phone</label></td>
								<td><form:input path="contactPersonPhone" readonly="true" />
								</td>
							</tr>
							<tr>
								<td><label for="address">Address</label></td>
								<td><form:input path="address" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="accountType">Account Type</label></td>
								<td><form:input path="accountType" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="employeeId">Market Id</label></td>
								<td><form:input path="employeeId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="leadThroughChannel">Lead Though
										Channel</label></td>
								<td><form:input path="leadThroughChannel" readonly="true" />
								</td>
							</tr>
							<tr>
								<td><label for="customerJoinDate">Customer Join
										Date</label></td>
								<td><form:input path="customerJoinDate" readonly="true" />
								</td>
							</tr>
							<tr>
								<td><label for="territoryId">Territory Id</label></td>
								<td><form:input path="territoryId" readonly="true" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
	<div></div>
	<div>
		<a href="/account/updateaccountform?id=${account.accountId}"><button>update</button></a>
		<a
			href="/account/deleteaccount?id=${account.accountId}&empId=${empId}"><button>delete</button></a>
	</div>
</body>
</html>