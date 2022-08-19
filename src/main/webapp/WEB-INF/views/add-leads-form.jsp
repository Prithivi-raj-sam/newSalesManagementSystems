<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Leads</title>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
<script>
<%@include file="/WEB-INF/script/leadValidation.js"%>
</script>
</head>
<body>
			<form:form action="addlead" method="post" modelAttribute="addLead" name="form">
			<h1>All Leads Form</h1>
				<div class="lead-form">
				<table>
				<caption></caption>
					<tr>
					<th></th></tr>
				<tbody>
				<tr>
					<td><label for="accountId">Account Id</label></td>
				<td>
						<form:input placeholder="Enter Your Account Id" path="accountId" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="status">Status</label></td>
				<td>
						<form:input placeholder="Enter Your Status" path="status" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="employeeId">SellerId</label></td>
				<td>
						<form:input placeholder="Enter Your Seller Id" path="employeeId" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="leadDate">Lead Date</label></td>
					<td>
						<form:input type="date" placeholder="Enter Lead Date" path="leadDate" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="stages">Stage</label></td>
					<td>
						<form:select placeholder="Enter Your Stage" path="stages" >
							<form:option value="Subscriber" label="Subscriber"></form:option>
							<form:option value="Lead/Nurturing" label="Lead/Nurturing"></form:option>
							<form:option value="MarketingQualifiedLead" label="Marketing Qualified Lead"></form:option>
							<form:option value="SalesQualifiedLead" label="Sales Qualified Lead"></form:option>
							<form:option value="Opportunity" label="Opportunity"></form:option>
						</form:select>
					</td>
				</tr>
				<tr>
				<td>
					<label for="propability">Probability</label></td>
					<td>
						<form:input placeholder="Enter Probability" path="propability" name="propability" onblur="probabilityCheck()"
						pattern="^[0-9]+(.[0-9]*)?$" title="please Enter Valid Probabilty"/>
					</td>
				</tr>
				</tbody>
				</table>
				<br><br>
				<form:button id="button">Add New</form:button>
				</div>
			</form:form>
	<div>${result}</div>
	
</body>
</html>