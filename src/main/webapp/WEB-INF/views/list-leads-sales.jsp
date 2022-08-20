<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Get Sales By Lead Id</title>
<style type="text/css">
<%@include file="/WEB-INF/css/allemployee.css" %>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="getLeads">
				<div class="form">
				<table>
				<caption></caption>
					<tr>
					<th></th></tr>
				<tbody>
				<tr><td>
					<label for="leadId">Lead Id</label>
					</td><td>
						<form:input path="leadId" readonly="true"/>
					</td></tr>
					<tr><td>
					<label for="accountId">Account Id</label>
					</td><td>
						<form:input path="accountId" readonly="true"/>
					</td></tr>
					<tr><td>
					<label for="status">Status</label>
					</td><td>
						<form:input path="status" readonly="true"/>
					</td></tr>
					<tr><td>
					<label for="employeeId">SellerId</label>
					</td><td>
						<form:input path="employeeId" readonly="true"/>
					</td></tr>
					<tr><td>
					<label for="leadDate">Lead Date</label>
					</td><td>
						<form:input path="leadDate" readonly="true"/>
					</td></tr>
					<tr><td>
					<label for="stages">Stage</label>
					</td><td>
						<form:input path="stages" readonly="true"/>
					</td></tr>
					<tr><td>
					<label for="propability">Probability</label>
					</td><td>
						<form:input path="propability" readonly="true"/>
					</td></tr></tbody></table>
				</div>
			</form:form>
		</div>
	</div>
	<div class="table">
		<table>
		<caption></caption>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Seller Name</th>
					<th>Account Name</th>
					<th>Sales Date</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>

			   <tr>
			   	  <td>${employeeName}</td>
			   	  <td>${accountName}</td>
			   	  <td>${getSales.salesDate}</td>
			   	  <td>${getSales.amount}</td>
			   </tr>
			</tbody>
		</table>
	</div>
</body>
</html>