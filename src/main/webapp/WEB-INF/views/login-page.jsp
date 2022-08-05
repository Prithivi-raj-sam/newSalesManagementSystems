<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login Page</title>
</head>
<body style="background-color:#3d403d; color:white;">
<div align="center">
	<form:form action="employeepage" method="post" modelAttribute="login">
				<div>
					<label for="employeeId"> Employee Id</label>
					<div>
						<form:input path="employeeId" />
					</div>
				</div>
				<div>
					<label for="password">Password</label>
					<div>
						<form:input path="password" />
					</div>
				</div>
				<div>
					<form:button>login</form:button>
				</div>
				</form:form>
</div>
<div align="center">
     <div>${head}</div>
	 <div>${title}</div>
     <div>${message}</div>
     </div>
</body>
</html>