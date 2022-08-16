<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<style>
text-error {
	color: #e80c4d;
	font-size: 0.9em;
}
</style>
<script type="text/javascript">
<%@include file="/WEB-INF/script/employeeValidation.js"%>
</script>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="/employee/addemployee" method="post"
				modelAttribute="addEmployee" name="form">

				<div>
					<label for="employeeName">Employee Name</label>
					<div>
						<form:input placeholder="Enter Your Name" path="employeeName" onblur="employeeNameCheck()"
						required="true" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
						title="Please enter only character in employeeName" name="employeeName"/>

					</div>
				</div>
				<div>
					<label for="employeePhone">Employee Phone</label>
					<div>
						<form:input placeholder="Enter Your Phone Number" path="employeePhone" onblur="employeePhoneCheck()"
						required="true" pattern="^[0-9]{10}$" title="Please Enter valid Phone Number" name="employeePhone"/>
					</div>
				</div>

				<div>
					<label for="email">Email</label>
					<div>
						<form:input type="email" placeholder="Enter Your Email" path="email" onblur="emailCheck()"
						required="true" title="Please Enter Valid Email"
						pattern="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\d.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
						name="email"/>
					</div>
				</div>

				<div>
					<label for="address">Address</label>
					<div>
						<form:input placeholder="Enter Your Address" path="address" onblur="addressCheck()"
						required="true" title="Please Enter valid Address" name="address"/>
					</div>
				</div>

				<div>
					<label for="territoryId">Territory Name : </label>
					<form:select path="territoryId" id="territoryId">
						<c:forEach var="allTerritory" items="${allTerritory}">
							<form:option value="${allTerritory.territoryId}"
								label="${allTerritory.territoryName}" />
						</c:forEach>
					</form:select>

				</div>
				<div>
					<label for="password">Password</label>
					<div>
						<form:input type="password" placeholder="Enter Password" path="password" onblur="passwordCheck()"
						required="true" title="Password doesnot reach reqired length or pattern it should contain min 1 number,simbal"
						pattern="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$" name="password"/>
					</div>
				</div>

				<div>
					<label for="passwordLastChangeDate">Password Last Change
						Date</label>
					<div>
						<form:input type="date" placeholder="Enter Your Last Password Change Date" path="passwordLastChangeDate" 
						required="true" />
					</div>
				</div>

				<div>
					<label for="role">Role</label>
					<div>
						<form:select path="role">
							<form:option value="manager" label="Manager"></form:option>
							<form:option value="marketer" label="Maketing Team"></form:option>
							<form:option value="salesman" label="SalesMan"></form:option>
						</form:select>
					</div>
				</div>
				<div>
					<label for="profile">Profile</label>
					<div>
						<form:input path="profile" type="file" accept=".png" 
						/>
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