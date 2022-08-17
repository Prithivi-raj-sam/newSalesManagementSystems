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
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addsales" method="post" modelAttribute="addsales" name="form">
				<div class="form">
				<table>
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
					<form:button id="button">Add New</form:button>
				</tbody>
				</table>
				</div>
				
			</form:form>
		</div>
	</div>
	<div>${result}</div>
	
</body>
</html>