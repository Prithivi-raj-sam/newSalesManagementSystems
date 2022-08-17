<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Trirong">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
<%@include file="/WEB-INF/script/employeeValidation.js"%>
</script>
<style type="text/css">
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body>
		
			<form:form action="updateemployee" method="post" modelAttribute="updateEmployee" name="form">
			<div class="form">
			<table>
			<tbody>
			<tr>
					<td><label for="employeeName">Employee Name</label></td>
					<td><form:input placeholder="Enter Your Name" path="employeeName" onblur="employeeNameCheck()"
						required="true" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
						title="Please enter only character in employeeName" name="employeeName" class="txt"/></td>

				</tr>
				<tr>
					<td><label for="employeePhone">Employee Phone</label></td>
						<td><form:input placeholder="Enter Your Phone Number" path="employeePhone" onblur="employeePhoneCheck()"
						required="true" pattern="^[0-9]{10}$" title="Please Enter valid Phone Number" name="employeePhone" class="txt"/></td>
				</tr>

				<tr>
					<td><label for="email">Email</label></td>
						<td><form:input type="email" placeholder="Enter Your Email" path="email" onblur="emailCheck()"
						required="true" title="Please Enter Valid Email"
						pattern="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\d.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
						name="email" class="txt"/></td>
				</tr>

				<tr>
					<td><label for="address">Address</label></td>
						<td><form:input placeholder="Enter Your Address" path="address" onblur="addressCheck()"
						required="true" title="Please Enter valid Address" name="address" class="txt"/></td>
				</tr>

				<tr>
					<td><label for="territoryId">Territory Name : </label></td>
					<td><form:select path="territoryId" id="territoryId">
						<c:forEach var="allTerritory" items="${allTerritory}">
							<form:option value="${allTerritory.territoryId}"
								label="${allTerritory.territoryName}" class="txt"/>
						</c:forEach>
					</form:select></td>

				</tr>
				<tr>
					<td><label for="password">Password</label></td>
						<td><form:input type="password" placeholder="Enter Password" path="password" onblur="passwordCheck()"
						required="true" title="Password doesnot reach reqired length or pattern it should contain min 1 number,simbal"
						pattern="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$" name="password" class="txt"/></td>
				</tr>

				<tr>
					<td><label for="passwordLastChangeDate">Password Last Change
						Date</label></td>
						<td><form:input type="date" placeholder="Enter Your Last Password Change Date" path="passwordLastChangeDate" 
						required="true" class="txt"/></td>
				</tr>

				<tr>
					<td><label for="role">Role</label></td>
						<td><form:select path="role" class="txt">
							<form:option value="manager" label="Manager"></form:option>
							<form:option value="marketer" label="Maketing Team"></form:option>
							<form:option value="salesman" label="SalesMan"></form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><label for="profile">Profile</label></td>
						<td><form:input path="profile" type="file" accept=".png" /></td>
				</tr>
			</tbody>
			</table>
					<form:button id="button">Update</form:button>
					</div>
			</form:form>
	<div>${result}</div>
	</body>
</html>