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
	<h1>Sales Management System</h1>

	<form:form action="employeepage" method="post" modelAttribute="login">
		<div class="form">
			<div>
				<label for="employeeId"> Employee Id</label>
				<form:input path="employeeId" pattern="^[0-9]{1,10}$"
					title="please enter Number in employee Id" />
			</div>
			<div>
				<label for="password">Password</label>
				<form:input path="password"
					pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"
					title="please enter password correctly" />
			</div>
			<div>
				<form:button>Log in</form:button>
			</div>
		</div>
	</form:form>
	<div align="center">
		<div>${head}</div>
		<div style="color: red;">${error}</div>
		<div style="color: white;">${message}</div>
	</div>

</body>
</html>









