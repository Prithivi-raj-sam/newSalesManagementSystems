<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
<script>
<%@include file="/WEB-INF/script/salesValidation.js"%>
</script>
</head>
<body>
			<form:form action="addsales" method="post" modelAttribute="addsales" name="form">
			<h1>Add Sales Form</h1>
				<div class="add-form">
				<table>
				<caption></caption>
					<tr>
					<th></th></tr>
						<tbody>
							<tr>
					<td><label for="employeeId">Seller Id</label></td>
					
					<td>	<form:input placeholder="Enter Seller Id" path="employeeId" readonly="true"/></td>
					</tr>
					<tr>
					<td><label for="leadId">Lead Id</label></td>
					<td>
						<form:input placeholder="Enter Lead Id" path="leadId" readonly="true"/>
					</td>
				</tr>
					<tr>
					<td>
					<label for="salesDate">sales Date</label></td>
					<td>
						<form:input type="date" placeholder="Enter Sales Date" path="salesDate" readonly="true"/>
				</td>
				</tr>
					<tr>
					<td>
					<label for="amount">Amount</label></td>
					<td>
						<form:input placeholder="Enter Amount" path="amount" name="amount" onblur="amountCheck()"
						pattern="^[0-9]+(.[0-9]*)?$" title="Please Enter valid Amount" required="true"/>
					</td>
			</tr>
				</tbody>
				</table>
				<br><br>
				<form:button>Add New</form:button>
				</div>
				
			</form:form>
	<div>${result}</div>
	
</body>
</html>