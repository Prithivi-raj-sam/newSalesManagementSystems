<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Get Territory By Id</title>
<script>
var territoryNameCheck = function() {
	var nameRegex = new RegExp("^[a-zA-z\s]+$");
	if (!document.form.territoryName.value.match(nameRegex)) {
		if (alert("Company Name can't be empty and must contain only alphabets")) {
			document.form.territoryName.focus();
		} else
			document.activeElement.blur();
	} else {
		return false;
	}

}
</script>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="territory" name="form">
				
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
	<div>
		<a href="/territory/updateterritoryform?id=${territory.territoryId}"><button>update</button></a>
		<a href="/territory/deleteterritory?id=${territory.territoryId}"><button>delete</button></a>
	</div>
</body>
</html>