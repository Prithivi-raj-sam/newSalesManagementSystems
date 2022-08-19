<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AddTerritory</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="addnewterritory" method="post" modelAttribute="addterritory">
				Not use
				<div class="from">
				<table>
				<caption></caption>
					<tr>
					<th></th></tr>
				<tbody>
				<tr>
				<td>
					<label for="companyName">Company Name</label></td>
					<td>
						<form:input placeholder="Enter Comapany Name" path="companyName" 
					onchange="validate()" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in CompanyName" readonly="true"/>
				</td>
				</tr>
				<tr>
				<td>
					<label for="contactPerson">Contact Person</label></td>
					<td>
						<form:input placeholder="Enter Your Contact Person" path="contactPerson" 
					onchange="validate()"	pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Contactperson" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="contactPersonRole">Contact Person Role</label>
					</td>
					<td>
						<form:input placeholder="Enter Your Contact Person Role" path="contactPersonRole" 
						onchange="validate()" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Contact Person Role" readonly="true"/>
					</td>
			</tr>
				<tr>
				<td>
					<label for="email">Email</label>
					</td>
					<td>
						<form:input path="email" placeholder="Enter Your Email" onchange="validate()"
						pattern="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\d.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
						title="Please Enter Valid Email" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="contactPersonPhone">Contact Person Phone</label>
					</td>
					<td>
						<form:input placeholder="Enter Your Contact Person Phone Number" path="contactPersonPhone" 
						onchange="validate()" pattern="^[0-9]+{10}$" 
						title="Please Enter Phone Number" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="address">Address</label>
					</td>
					<td>
						<form:input placeholder="Enter Your Address" path="address" 
					onchange="validate()"	
					title="Please Enter valid Address" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="accountType">Account Type</label>
					</td>
					<td>
						<form:input placeholder="Enter Your Account Type" path="accountType" 
					onchange="validate()"	pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Account Type" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="employeeId">Market Id</label>
					</td>
					<td>
						<form:input placeholder="Enter Your Market Id" path="employeeId" 
					onchange="validate()"	pattern="^[0-9]+$" title="Please Enter Only Number In marketer Id" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="leadThroughChannel">Lead Though Channel</label>
					</td>
					<td>
						<form:input placeholder="Enter Your Lead Though Channel" path="leadThroughChannel" onchange="validate()"
						pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Channel" readonly="true"/>
					</td>
				</tr>
				<tr>
				<td>
					<label for="territoryId">Territory Name</label>
					</td>
					<td>
						<form:input placeholder="Enter Your Territory Name" path="territoryId" />
					</td>
				</tr>
				<tr>
				<td>
					<label for="customerJoinDate">Customer Join Date</label>
					</td>
					<td>
						<form:input type="date" placeholder="Enter Your Joining Date" path="customerJoinDate" readonly="true"/>
					</td>
       			</tr>
					<form:button id="button">Add New</form:button>
				</tbody>
				</table>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>