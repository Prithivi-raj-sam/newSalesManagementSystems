<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All target By Employee Id</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="getEmployee">
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
	<div id="table root">
		<table>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Target Id</th>
					<th>Target Date</th>
					<th>Planned Target</th>
					<th>closed Target</th>
					<th>Employee Id</th>
					<th>Manager Comment</th>
					<th>Target Month</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="alltargets" items="${getTargets}">
			   <tr>
			   	  <td>${alltargets.targetId}</td>
			   	  <td>${alltargets.targetDate}</td>
			   	  <td>${alltargets.plannedTarget}</td>
			   	  <td>${alltargets.closedTarget}</td>
			   	  <td>${alltargets.employeeId}</td>
			   	  <td>${alltargets.managerComment}</td>
			   	  <td>${alltargets.targetMonth}</td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>