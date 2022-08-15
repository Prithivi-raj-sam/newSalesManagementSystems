<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="addnewterritory" method="post" modelAttribute="addterritory">
				
				<div>
					<label for="companyName">Company Name</label>
					<div>
						<form:input placeholder="Enter Comapany Name" path="companyName" 
					onchange="validate()" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in CompanyName" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="contactPerson">Contact Person</label>
					<div>
						<form:input placeholder="Enter Your Contact Person" path="contactPerson" 
					onchange="validate()"	pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Contactperson" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="contactPersonRole">Contact Person Role</label>
					<div>
						<form:input placeholder="Enter Your Contact Person Role" path="contactPersonRole" 
						onchange="validate()" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Contact Person Role" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" placeholder="Enter Your Email" onchange="validate()"
						pattern="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\d.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
						title="Please Enter Valid Email" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="contactPersonPhone">Contact Person Phone</label>
					<div>
						<form:input placeholder="Enter Your Contact Person Phone Number" path="contactPersonPhone" 
						onchange="validate()" pattern="^[0-9]+{10}$" 
						title="Please Enter Phone Number" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="address">Address</label>
					<div>
						<form:input placeholder="Enter Your Address" path="address" 
					onchange="validate()"	
					title="Please Enter valid Address" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="accountType">Account Type</label>
					<div>
						<form:input placeholder="Enter Your Account Type" path="accountType" 
					onchange="validate()"	pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Account Type" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="employeeId">Market Id</label>
					<div>
						<form:input placeholder="Enter Your Market Id" path="employeeId" 
					onchange="validate()"	pattern="^[0-9]+$" title="Please Enter Only Number In marketer Id" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="leadThroughChannel">Lead Though Channel</label>
					<div>
						<form:input placeholder="Enter Your Lead Though Channel" path="leadThroughChannel" onchange="validate()"
						pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Please enter only character in Channel" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="territoryId">Territory Name</label>
					<div>
						<form:input placeholder="Enter Your Territory Name" path="territoryId" />
					</div>
				</div>
				<div>
					<label for="customerJoinDate">Customer Join Date</label>
					<div>
						<form:input type="date" placeholder="Enter Your Joining Date" path="customerJoinDate" readonly="true"/>
					</div>
       			</div>
				<div>
					<form:button id="button">Add New</form:button>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>