<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Target</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addtarget" method="post" modelAttribute="addtarget">
				<div>
					<label for="targetDate">Target Date</label>
					<div>
						<form:input type="date" placeholder="Enter Target Date" path="targetDate" />
					</div>
				</div>
				<div>
					<label for="plannedTarget">Planned Target</label>
					<div>
						<form:input placeholder="Enter Planned Target" path="plannedTarget" />
					</div>
				</div>
				<div>
					<label for="employeeId">Employee Id</label>
					<div>
						<form:input placeholder="Enter Seller Id" path="employeeId" />
					</div>
				</div>
				<div>
					<label for="managerComment">Manager Comment</label>
					<div>
						<form:input placeholder="Enter Manager Comment" path="managerComment" />
					</div>
				</div>
				<div>
					<label for="targetSetDate">Target set Date</label>
					<div>
						<form:input path="targetSetDate" />
					</div>
				</div>
				<div>
					<form:button id="button">Add new</form:button>
				</div>
			</form:form>
		</div>
	</div>
	<div>${result}</div>
	
</body>
</html>