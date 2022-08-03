<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Employee By Id</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="employee">
				<div>
					<label for="employeeId">Employee id</label>
					<div>
						<form:input path="employeeId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="employeeName">Employee Name</label>
					<div>
						<form:input path="employeeName" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="employeePhone">Employee Phone</label>
					<div>
						<form:input path="employeePhone" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="address">Address</label>
					<div>
						<form:input path="address" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="territoryId">Territory Id</label>
					<div>
						<form:input path="territoryId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="password">Password</label>
					<div>
						<form:input path="password" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="passwordLastChangeDate">Password Last Change Date</label>
					<div>
						<form:input path="passwordLastChangeDate" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="role">Role</label>
					<div>
						<form:input path="role" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="profile">Profile</label>
					<div>
						<form:input path="profile" readonly="true" type="image"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>