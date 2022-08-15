<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Target</title>
</head>

<body style="background-color:#3d403d; color:white;">
	<h3>Current target</h3>
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="target">
				<div>
					<label for="targetDate">Target Date</label>
					<div>
						<form:input path="targetDate" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="plannedTarget">Planned Target</label>
					<div>
						<form:input path="plannedTarget" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="closedTarget">Closed Target</label>
					<div>
						<form:input path="closedTarget" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="managerComment">Manager Comment</label>
					<div>
						<form:input path="managerComment" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="targetSetDate">Target Set Date</label>
					<div>
						<form:input path="targetSetDate" readonly="true"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>