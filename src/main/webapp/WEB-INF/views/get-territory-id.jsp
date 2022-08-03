<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Territory By Id</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="addEmployee">
				<div>
					<label for="territoryId">Territory id</label>
					<div>
						<form:input path="territoryId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="territoryName">Territory Name</label>
					<div>
						<form:input path="territoryName" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="noOfCustomer">No Of Customer</label>
					<div>
						<form:input path="noOfCustomer" readonly="true"/>
					</div>
				</div>
				
			</form:form>
		</div>
	</div>
	<div>${result}</div>
	
</body>
</html>