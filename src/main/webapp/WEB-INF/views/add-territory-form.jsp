<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Territory</title>
<script>
<%@include file="/WEB-INF/script/territoryValidation.js"%>
</script>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addterritory" method="post" modelAttribute="addterritory" name="form">
				<div>
					<label for="territoryName">Territory Name</label>
					<div>
						<form:input path="territoryName" name="territoryName" onblur="territoryNameCheck()"
						pattern="^[a-zA-z\s]+$" title="Please enter Valid Territory Name" required="true"/>
					</div>
				</div>
				<div>
					<form:button id="button">Add New</form:button>
				</div>
			</form:form>
		</div>
	</div>
	<div>${result}</div>
	
</body>
</html>