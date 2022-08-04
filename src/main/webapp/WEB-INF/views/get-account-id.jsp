<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Account By Id</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="account">
				<div>
					<label for="accountId"> Account id</label>
					<div>
						<form:input path="accountId" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="companyName">Company Name</label>
					<div>
						<form:input path="companyName" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="contactPerson">Contact Person</label>
					<div>
						<form:input path="contactPerson" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="contactPersonRole">COntact Person Role</label>
					<div>
						<form:input path="contactPersonRole" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="contactPersonPhone">Contact Person Phone</label>
					<div>
						<form:input path="contactPersonPhone" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="address">Address</label>
					<div>
						<form:input path="address" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="accountType">Account Type</label>
					<div>
						<form:input path="accountType" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="marketId">Market Id</label>
					<div>
						<form:input path="marketId" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="leadThroughChannel">Lead Though Channel</label>
					<div>
						<form:input path="leadThroughChannel" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="customerJoinDate">Customer Join Date</label>
					<div>
						<form:input path="customerJoinDate" readonl="true"/>
					</div>
				</div>
				<div>
					<label for="territoryId">Territory Id</label>
					<div>
						<form:input path="territoryId" readonl="true"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div>${result}</div>
	
</body>
</html>