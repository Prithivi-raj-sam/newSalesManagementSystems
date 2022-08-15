<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Employee By Id</title>
<style>
body{
text-align:center;
background-color:#c4f4f5;
}
h1 {
    font-family: "Lucida Console", "Courier New", monospace;
    font-size: 25px;
    color: cyan;
}

.form label {
    font-family: Verdana, sans-serif;
    font-size: 20px;
    color: red;
}

.form table {
    font-size: 30px;
}

.form input {
    width: 300px;
    height: 27px;
}

button {
    border-radius: 25px;
    background: cyan;
    padding: 20px;
    width: 140px;
}

</style>
</head>
<body>
			<form:form action="" method="post" modelAttribute="employee">
			<div class="form">
			<table>
			<tbody>
			<tr>
					<td><label for="employeeId">Employee id</label></td>
						<td><form:input path="employeeId" readonly="true"/></td>
				</tr>
				<tr>
					<td><label for="employeeName">Employee Name</label></td>
						<td><form:input path="employeeName" readonly="true"/></td>
				</tr>
				<tr>
					<td><label for="employeePhone">Employee Phone</label></td>
						<td><form:input path="employeePhone" readonly="true"/></td>
				</tr>
				<tr>
					<td><label for="email">Email</label></td>
						<td><form:input path="email" readonly="true"/></td>
				</tr>
				<tr>
					<td><label for="address">Address</label></td>
						<td><form:input path="address" readonly="true"/></td>
				</tr>
				<tr>
					<td><label for="territoryId">Territory Id</label></td>
						<td><form:input path="territoryId" readonly="true"/></td>
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
						<td><form:input path="password" readonly="true"/></td>
				</tr>
				<tr>
					<td><label for="passwordLastChangeDate">Password Last Change Date</label></td>
						<td><form:input path="passwordLastChangeDate" readonly="true"/></td>
				</tr>
				<tr>
					<td><label for="role">Role</label></td>
						<td><form:input path="role" readonly="true"/></td>
				</tr>
			</tbody>
			</table>
			</div>
								<%-- <tr>
					<label for="profile">Profile</label>
					<tr>
						<form:input path="profile" readonly="true" type="image"/>
					</tr>
					<tr>
					<img src="data:image/jpg;base64,${employee.profile}" width="240" height="300"/>
					</tr>
									</tr> --%>
			</form:form>
			<a href="/employee/updateemployeeform?id=${employee.employeeId}"><button>update</button></a>
			<a href="/employee/employeeachievment?id=${employee.employeeId}"><button>Achievement</button></a>
			<a href="/employee/deleteemployee?id=${employee.employeeId}"><button>Delete</button></a>
			
</body>
</html>