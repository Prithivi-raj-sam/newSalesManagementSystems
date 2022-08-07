<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login Page</title>
<style>
body {
	background-image:
		url("https://previews.123rf.com/images/nexusplexus/nexusplexus1601/nexusplexus160101888/50267785-modern-office-window-view-with-virtual-market-infographs.jpg");
	background-width: 1366 px;
	background-height: 768 px;
}

#all {
	display: block;
	margin-left: auto;
	margin-right: auto;
	background: #fcebc2;
	border-radius: 25px;
	border: 7px solid #150a36;
	padding: 30px;
	width: 300px;
	height: 200px;
}

h1 {
	color: white;
	font-size: 40px;
	font-family: "Audiowide", sans-serif;
	font-style: italic;
}
#employeeId,#password,#button{
	size:30px;
}
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
						<form:input path="employeeId" id="employeeId"/>
					</div>
				</div>
				<div>
					<label for="password">Password</label>
					<div>
						<form:input path="password" id="password"/>
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
		<div>${title}</div>
		<div>${message}</div>
	</div>
</body>
</html>