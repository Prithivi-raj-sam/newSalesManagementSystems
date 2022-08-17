<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Account</title>
<script type="text/javascript">
<%@include file="/WEB-INF/script/accountValidation.js"%>
</script>
</head>
<body style="background-color: #3d403d; color: white;">
	<div id="root">
		<div id="form">
			<form:form action="updateaccount" method="post"
				modelAttribute="updateAccount" name="form">
				<div class="form">
					<table>
						<tbody>
							<tr>
								<td><label for="companyName">Company Name</label></td>
								<td><form:input placeholder="Enter Comapany Name"
										path="companyName" name="companyName" onchange="validate()"
										pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
										title="Please enter only character in CompanyName"
										required="true" onblur="companyNameCheck()" /></td>
							</tr>
							<tr>
								<td><label for="contactPerson">Contact Person</label></td>
								<td><form:input placeholder="Enter Your Contact Person"
										path="contactPerson" name="contactPerson"
										onchange="validate()" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
										title="Please enter only character in Contactperson"
										required="true" onblur="contactPersonCheck()" /></td>
							</tr>
							<tr>
								<td><label for="contactPersonRole">Contact Person
										Role</label></td>
								<td><form:input
										placeholder="Enter Your Contact Person Role"
										path="contactPersonRole" name="contactPersonRole"
										onchange="validate()" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
										title="Please enter only character in Contact Person Role"
										required="true" onblur="contactPersonRoleCheck()" /></td>
							</tr>
							<tr>
								<td><label for="email">Email</label></td>
								<td><form:input path="email" placeholder="Enter Your Email"
										onchange="validate()" name="email"
										pattern="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\d.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
										title="Please Enter Valid Email" required="true"
										onblur="emailCheck()" /></td>
							</tr>
							<tr>
								<td><label for="contactPersonPhone">Contact Person
										Phone</label></td>
								<td><form:input
										placeholder="Enter Your Contact Person Phone Number"
										path="contactPersonPhone" onchange="validate()"
										pattern="^[0-9]+{10}$" name="contactPersonPhone"
										title="Please Enter Phone Number" required="true"
										onblur="contactPersonPhoneCheck()" /></td>
							</tr>
							<tr>
								<td><label for="address">Address</label></td>
								<td><form:input placeholder="Enter Your Address"
										path="address" name="address" onchange="validate()"
										title="Please Enter valid Address" required="true"
										onblur="addressCheck()" /></td>
							</tr>
							<tr>
								<td><label for="accountType">Account Type</label></td>
								<td><form:input placeholder="Enter Your Account Type"
										path="accountType" name="accountType" onchange="validate()"
										pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
										title="Please enter only character in Account Type"
										required="true" onblur="accountTypeCheck()" /></td>
							</tr>
							<tr>
								<td><label for="employeeId">Market Id</label></td>
								<td><form:input placeholder="Enter Your Market Id"
										path="employeeId" name="employeeId" onchange="validate()"
										pattern="^[0-9]+$"
										title="Please Enter Only Number In marketer Id"
										required="true" readonly="true" /></td>
							</tr>
							<tr>
								<td><label for="leadThroughChannel">Lead Though
										Channel</label></td>
								<td><form:input
										placeholder="Enter Your Lead Though Channel"
										path="leadThroughChannel" onchange="validate()"
										name="leadThroughChannel" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$"
										title="Please enter only character in Channel"
										onblur="leadThroughChannelCheck()" /></td>
							</tr>
							<tr>
								<td><label for="customerJoinDate">Customer Join
										Date</label></td>
								<td><form:input type="date"
										placeholder="Enter Your Joining Date" path="customerJoinDate"
										readonly="true" required="true" name="customerJoinDate"
										onblur="companyNameCheck()" /></td>
							</tr>
							<tr>
								<td><label for="territoryId">Territory Name : </label></td>
								<td><form:select path="territoryId">
										<c:forEach var="allTerritory" items="${allTerritory}">
											<form:option value="${allTerritory.territoryId}"
												label="${allTerritory.territoryName}" />
										</c:forEach>
									</form:select></td>
							</tr>
							<form:button id="button">update</form:button>
						</tbody>
					</table>
				</div>
			</form:form>
		</div>
	</div>
	<div>${result}</div>

</body>
</html>




