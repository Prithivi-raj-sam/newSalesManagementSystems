<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login Page</title>
<style>
	<%@include file="/WEB-INF/css/loginpage.css"%>
</style>

</head>
<body>
	<h1 align="center">Sales Management System</h1>
	<div align="center" id="all">
		<div>
			<form:form action="employeepage" method="post" modelAttribute="login">
				<div></div>
				<div>
					<label for="employeeId"> Employee Id</label>
					<div>
						<form:input path="employeeId" id="employeeId" pattern="^[0-9]{1,10}$"
						title="please enter Number in employee Id"/>
					</div>
				</div>
				<div>
					<label for="password">Password</label>
					<div>
						<form:input path="password" id="password" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"
						title="please enter password correctly"/>
					</div>
				</div>
				<div>
					<form:button id="button">login</form:button>
				</div>
			</form:form>
		</div>
	</div>
	<div align="center">
		<div>${head}</div>
		<div style="color:red;">${error}</div>
		<div style="color:white;">${message}</div>
	</div>
</body>
</html>









