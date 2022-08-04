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
						<form:input path="leadId" />
					</div>
				</div>
				<div>
					<label for="accountId">Account Id</label>
					<div>
						<form:input path="accountId" />
					</div>
				</div>
				<div>
					<label for="status">Status</label>
					<div>
						<form:input path="status" />
					</div>
				</div>
				<div>
					<label for="sellerId">SellerId</label>
					<div>
						<form:input path="sellerId" />
					</div>
				</div>
				<div>
					<label for="leadDate">Lead Date</label>
					<div>
						<form:input path="leadDate" />
					</div>
				</div>
				<div>
					<label for="stages">Stage</label>
					<div>
						<form:input path="stages" />
					</div>
				</div>
				<div>
					<label for="propability">Probability</label>
					<div>
						<form:input path="propability" />
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