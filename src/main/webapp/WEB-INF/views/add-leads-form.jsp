<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Leads</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addlead" method="post" modelAttribute="addLead">
				<div>
					<label for="leadId">Lead Id</label>
					<div>
						<form:input placeholder="Enter Lead Id" path="leadId" />
					</div>
				</div>
				<div>
					<label for="accountId">Account Id</label>
					<div>
						<form:input placeholder="Enter Your Account Id" path="accountId" />
					</div>
				</div>
				<div>
					<label for="status">Status</label>
					<div>
						<form:input placeholder="Enter Your Status" path="status" />
					</div>
				</div>
				<div>
					<label for="employeeId">SellerId</label>
					<div>
						<form:input placeholder="Enter Your Seller Id" path="employeeId" />
					</div>
				</div>
				<div>
					<label for="leadDate">Lead Date</label>
					<div>
						<form:input type="date" placeholder="Enter Lead Date" path="leadDate" />
					</div>
				</div>
				<div>
					<label for="stages">Stage</label>
					<div>
						<form:input placeholder="Enter Your Stage" path="stages" />
					</div>
				</div>
				<div>
					<label for="propability">Probability</label>
					<div>
						<form:input placeholder="Enter Probability" path="propability" />
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