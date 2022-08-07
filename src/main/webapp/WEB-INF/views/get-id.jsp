<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Id</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form  action="${redirect}" method="post" modelAttribute="getId">
				<div>
					<label for="id">Enter Id</label>
					<div>
						<form:input path="id" />
					</div>
				</div>
				<div>
					<form:button id="button">Add New</form:button>
				</div>
				</form:form>
				</div></div>
</body>
</html>