<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
<%@include file="/WEB-INF/script/salesValidation.js"%>
</script>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addsales" method="post" modelAttribute="addsales" name="form">
				<div>
					<label for="employeeId">Seller Id</label>
					<div>
						<form:input placeholder="Enter Seller Id" path="employeeId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="leadId">Lead Id</label>
					<div>
						<form:input placeholder="Enter Lead Id" path="leadId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="salesDate">sales Date</label>
					<div>
						<form:input type="date" placeholder="Enter Sales Date" path="salesDate" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="amount">Amount</label>
					<div>
						<form:input placeholder="Enter Amount" path="amount" name="amount" onblur="amountCheck()"
						pattern="^[0-9]+(.[0-9]*)?$" title="Please Enter valid Amount" required="true"/>
					</div>
				</div>
				<div>
					<form:button id="button">Add New</form:button>
				</div>
			</form:form>
		</div>
	</div>
	<div>${result}</div>
	
</body>
</html>