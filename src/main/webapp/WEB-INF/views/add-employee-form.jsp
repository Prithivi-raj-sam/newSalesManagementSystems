<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addemployee" method="post" modelAttribute="addEmployee">
				<div>
					<label for="employeeName">Employee Name</label>
					<div>
						<form:input path="employeeName" />
					</div>
				</div>
				<div>
					<label for="employeePhone">Employee Phone</label>
					<div>
						<form:input path="employeePhone" />
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" />
					</div>
				</div>
				<div>
					<label for="address">Address</label>
					<div>
						<form:input path="address" />
					</div>
				</div>
				<div>
				<label for="territoryId">Territory Name : </label> <form:select
                                path="territoryId" id="territoryId">
                                <form:option value="">--select territory--</form:option>
                                <c:forEach var="allTerritory" items="${allTerritory}">
                                    <form:option value="${allTerritory.territoryId}"
                                        label="${allTerritory.territoryName}" />
                                </c:forEach>
                            </form:select>
                </div>
				<div>
					<label for="password">Password</label>
					<div>
						<form:input path="password" />
					</div>
				</div>
				<div>
					<label for="passwordLastChangeDate">Password Last Change Date</label>
					<div>
						<form:input path="passwordLastChangeDate" />
					</div>
				</div>
				<div>
					<label for="role">Role</label>
					<div>
						<form:input path="role" />
					</div>
				</div>
				<div>
					<label for="profile">Profile</label>
					<div>
						<form:input path="profile" type="file" accept=".png"/>
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