<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Password</title>
</head>
<body>
<script>
var passwordMatch= function(){
	var password=document.form.password.value;
	var confirmPassword=document.getElementById("confirmpassword").value;
	if(password==confirmPassword){
		alert('password missmatch');
	}
}
var passwordCheck = function() {
	var nameRegex = new RegExp(
			"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
	if (!document.form.password.value.match(nameRegex)) {
		if (alert("Password must begin with letter and contain atleast one number and must have atleast 8 characters")) {
			document.form.password.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}
</script>
	<form:form action="updatepassword" method="post" modelAttribute="emp" name="form">
	<div>
				<div>
					<div>
						<form:input placeholder="Enter Comapany Name" path="employeeId" type="hidden" value="${empId}"/>
					</div>
				</div>
				<label for="password">Password</label>
					<div>
						<form:input type="password" placeholder="Enter Password" path="password" onblur="passwordCheck()"
						name="password" pattern="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$" 
						title="Password does not meat its required length or strength" required="true" />
					</div>
				</div>
				<label for="confirmpassword"></label>
				<div><input type="password" id="confirmpassword" placeholder="Confirm Password" onblur="passwordMatch()"></div>
				<div>
					<form:button id="button" onclick="passwordMatch()">Add New</form:button>
				</div>
</form:form>
</body>
</html>