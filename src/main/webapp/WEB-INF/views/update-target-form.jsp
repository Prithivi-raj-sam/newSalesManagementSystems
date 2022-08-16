<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Target</title>
<script>
<%@include file="/WEB-INF/script/targetValidation.js"%>
</script>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="updatetarget" method="post" modelAttribute="updatetarget" name="form">
				<div>
					<label for="targetDate">Target Date</label>
					<div>
						<form:input path="targetDate" type="date" name="targetDate" required="true"/>
					</div>
				</div>
				<div>
					<label for="plannedTarget">Planned Target</label>
					<div>
						<form:input placeholder="Enter Planned Target" path="plannedTarget" 
						pattern="^[0-9]{1,10}" title="Please Enter Valid Planned Target" name="plannedTarget"
						onblur="plannedTargetCheck()"/>
					</div>
				</div>
				<div>
					<label for="closedTarget">Closed Target</label>
					<div>
						<form:input path="closedTarget" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="employeeId">Employee Id</label>
					<div>
						<form:input path="employeeId" required="true" name="employeeId" onblur="employeeIdCheck()"
						pattern="^[0-9]{1,10}" title="Please Enter Valid Employee Id"/>
					</div>
				</div>
				<div>
					<label for="managerComment">Manager Comment</label>
					<div>
						<form:input placeholder="Enter Manager Comment" path="managerComment" 
						pattern="^[a-zA-z\s]+$" title="Please enter valid comments" name="managerComment"
						onblur="managerCommentCheck()"/>
					</div>
				</div>
				<div>
					<label for="targetSetDate">Target Set Date</label>
					<div>
						<form:input path="targetSetDate" type="date" required="true"/>
					</div>
				</div>
				<div>
					<label for="targetCategory">Target Category</label>
					<div>
						<form:select path="targetCategory" >
						<form:option value="lead"  label="Leads"></form:option>
						<form:option value="sales"  label="Sale"></form:option>
						<form:option value="account"  label="Account"></form:option>
						</form:select>
					</div>
				</div>
				<div>
					<form:button id="button">update</form:button>
				</div>
			</form:form>
		</div>
	</div>
	<div>${result}</div>
	
</body>
</html>