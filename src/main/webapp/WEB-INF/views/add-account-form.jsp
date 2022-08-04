<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addaccount" method="post" modelAttribute="addAccount">
				<div>
					<label for="accountId"> Account id</label>
					<div>
						<form:input path="accountId" />
					</div>
				</div>
				<div>
					<label for="companyName">Company Name</label>
					<div>
						<form:input path="companyName" />
					</div>
				</div>
				<div>
					<label for="contactPerson">Contact Person</label>
					<div>
						<form:input path="contactPerson" />
					</div>
				</div>
				<div>
					<label for="contactPersonRole">COntact Person Role</label>
					<div>
						<form:input path="contactPersonRole" />
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" />
					</div>
				</div>
				<div>
					<label for="contactPersonPhone">Contact Person Phone</label>
					<div>
						<form:input path="contactPersonPhone" />
					</div>
				</div>
				<div>
					<label for="address">Address</label>
					<div>
						<form:input path="address" />
					</div>
				</div>
				<div>
					<label for="accountType">Account Type</label>
					<div>
						<form:input path="accountType" />
					</div>
				</div>
				<div>
					<label for="marketId">Market Id</label>
					<div>
						<form:input path="marketId" />
					</div>
				</div>
				<div>
					<label for="leadThroughChannel">Lead Though Channel</label>
					<div>
						<form:input path="leadThroughChannel" />
					</div>
				</div>
				<div>
					<label for="customerJoinDate">Customer Join Date</label>
					<div>
						<form:input path="customerJoinDate" />
					</div>
				</div>
				<div>
					<label for="territoryId">Territory Id</label>
					<div>
						<form:input path="territoryId" />
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