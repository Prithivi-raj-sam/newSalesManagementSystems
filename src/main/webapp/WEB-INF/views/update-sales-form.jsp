<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="updatesales" method="post" modelAttribute="updatesales">
				<div>
					<label for="salesId"> Sales id</label>
					<div>
						<form:input path="salesId" />
					</div>
				</div>
				<div>
					<label for="employeeId">Seller Name</label>
					<div>
						<form:input path="employeeId" />
					</div>
				</div>
				<div>
					<label for="leadId">Lead Id</label>
					<div>
						<form:input path="leadId" />
					</div>
				</div>
				<div>
					<label for="salesDate">sales Date</label>
					<div>
						<form:input path="salesDate" />
					</div>
				</div>
				<div>
					<label for="amount">Amount</label>
					<div>
						<form:input path="amount" />
					</div>
				</div>
				<div>
					<form:button id="button">update</form:button>
				</div>
			</form:form>
		</div>
	</div>
	<div>${result}</div>
	
</body>
</html>