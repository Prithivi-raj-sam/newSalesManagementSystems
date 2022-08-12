<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password</title>
</head>
<body>
<script>
function passwordCheck(){
	var password=document.getElementById("password").value;
	var confirmPassword=document.getElementById("confirmpassword").value;
	if(password==confirmPassword){
		alert('password missmatch');
	}
}
</script>
	<form:form action="updatepassword" method="post" modelAttribute="emp">
	<div>
				<div>
					<div>
						<form:input placeholder="Enter Comapany Name" path="employeeId" type="hidden" value="${empId}"/>
					</div>
				</div>
				<label for="password">Password</label>
					<div>
						<form:input type="password" placeholder="Enter Password" path="password" onchange="passwordCheck()"/>
					</div>
				</div>
				<label for="confirmpassword"></label>
				<div><input type="password" id="confirmpassword" placeholder="Confirm Password" onchange="passwordCheck(this.form)"></div>
				<div>
					<form:button id="button">Add New</form:button>
				</div>
</form:form>
</body>
</html>