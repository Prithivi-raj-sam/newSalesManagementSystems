<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	
<%@include file="/WEB-INF/script/salesValidation.js"%>
	
</script>
<style>
 <%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="updatesales" method="post"
				modelAttribute="updatesales" name="form">

				<div class="form">
					<table>
					<caption></caption>
					<tr>
					<th></th></tr>
						<tbody>
							<tr>
								<td><label for="employeeId">Seller Id</label></td>
								<td><form:input path="employeeId" required="true"
										name="employeeId" onblur="employeeIdCheck()"
										pattern="^[0-9]{1,10}" title="Please Enter Valid Number" /></td>
							</tr>
							<tr>
								<td><label for="leadId">Lead Id</label></td>
								<td><form:input path="leadId" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="salesDate">sales Date</label></td>
								<td><form:input path="salesDate" type="date"
										required="true" /></td>
							</tr>
							<tr>
								<td><label for="amount">Amount</label></td>
								<td><form:input placeholder="Enter Amount" path="amount"
										name="amount" onblur="amountCheck()"
										pattern="^[0-9]+(.[0-9]*)?$" title="Please Enter valid Amount"
										required="true" /></td>
							</tr>
							<form:button id="button">update</form:button>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
	<div>${result}</div>

</body>
</html>