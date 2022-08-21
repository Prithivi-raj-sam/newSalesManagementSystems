<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Update Target</title>
<script>
<%@include file="/WEB-INF/script/targetValidation.js"%>
</script>
<style>
 <%@include file="/WEB-INF/css/getemployeebyid.css"%>
</style>
</head>
<body>
			<form:form action="updatetarget" method="post"
				modelAttribute="updatetarget" name="form">
				<div class="form">
					<table>
					<caption></caption>
					<tr>
					<th></th></tr>
						<tbody>
							<tr>
								<td><label for="targetDate">Target Date</label></td>
								<td><form:input path="targetDate" type="date"
										name="targetDate" required="true" /></td>
							</tr>
							<tr>
								<td><label for="plannedTarget">Planned Target</label></td>
								<td><form:input placeholder="Enter Planned Target"
										path="plannedTarget" pattern="^[0-9]{1,10}"
										title="Please Enter Valid Planned Target" name="plannedTarget"
										onblur="plannedTargetCheck()" /></td>
							</tr>
							<tr>
								<td><label for="closedTarget">Closed Target</label></td>
								<td><form:input path="closedTarget" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="employeeId">Employee Id</label></td>
								<td><form:input path="employeeId" required="true"
										name="employeeId" onblur="employeeIdCheck()"
										pattern="^[0-9]{1,10}" title="Please Enter Valid Employee Id" />
								</td>
							</tr>
							<tr>
								<td><label for="managerComment">Manager Comment</label></td>
								<td><form:input placeholder="Enter Manager Comment"
										path="managerComment" pattern="^[a-zA-z\s]+$"
										title="Please enter valid comments" name="managerComment"
										onblur="managerCommentCheck()" /></td>
							</tr>
							<tr>
								<td><label for="targetSetDate">Target Set Date</label></td>
								<td><form:input path="targetSetDate" type="date"
										required="true" /></td>
							</tr>
							<tr>
								<td><label for="targetCategory">Target Category</label></td>
								<td><form:select path="targetCategory">
										<form:option value="lead" label="Leads"></form:option>
										<form:option value="sales" label="Sale"></form:option>
										<form:option value="account" label="Account"></form:option>
									</form:select></td>
							</tr>
						</tbody>
					</table>
					<form:button id="button">Update</form:button>
				</div>
			</form:form>
			
	<div>${result}</div>

</body>
</html>