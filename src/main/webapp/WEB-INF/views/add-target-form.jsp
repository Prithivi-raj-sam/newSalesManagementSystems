<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Target</title>
<style>
<%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
<script>
<%@include file="/WEB-INF/script/targetValidation.js"%>
</script>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="addtarget" method="post"
				modelAttribute="addtarget" name="form">
				<div class="form">
					<table>
					<caption></caption>
					<tr>
					<th></th></tr>
						<tbody>
							<tr>
								<td><label for="targetDate">Target Date</label></td>
								<td><form:input type="date" placeholder="Enter Target Date"
										path="targetDate" required="true" /></td>
							</tr>
							<tr>
								<td><label for="plannedTarget">Planned Target</label></td>
								<td><form:input placeholder="Enter Planned Target"
										path="plannedTarget" pattern="^[0-9]{1,10}"
										title="Please Enter Valid Planned Target" name="plannedTarget"
										onblur="plannedTargetCheck()" /></td>
							</tr>
							<tr>
								<td><label for="employeeId">Employee Id</label></td>
								<td><form:input path="employeeId" required="true"
										name="employeeId" onblur="employeeIdCheck()"
										pattern="^[0-9]{1,10}" title="Please Enter Valid Employee Id"
										readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="managerComment">Manager Comment</label></td>
								<td><form:input placeholder="Enter Manager Comment"
										path="managerComment" pattern="^[a-zA-z\s]+$"
										title="Please enter valid comments" name="managerComment"
										onblur="managerCommentCheck()" /></td>
							</tr>
							<tr>
								<td><label for="targetSetDate">Target set Date</label></td>
								<td><form:input path="targetSetDate" readonly="true"
										type="date" /></td>
							</tr>
							<tr>
								<td><label for="targetCategory">Target Category</label></td>
								<td><form:select path="targetCategory">
										<form:option value="lead" label="Leads"></form:option>
										<form:option value="sales" label="Sale"></form:option>
										<form:option value="account" label="Account"></form:option>
									</form:select></td>
							</tr>
							<form:button id="button">Add new</form:button>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
	<div>${result}</div>

</body>
</html>