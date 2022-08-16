<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Leads</title>
<script>
<%@include file="/WEB-INF/script/leadValidation.js"%>
</script>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addlead" method="post" modelAttribute="addLead" name="form">
				
				<div>
					<label for="accountId">Account Id</label>
					<div>
						<form:input placeholder="Enter Your Account Id" path="accountId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="status">Status</label>
					<div>
						<form:input placeholder="Enter Your Status" path="status" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="employeeId">SellerId</label>
					<div>
						<form:input placeholder="Enter Your Seller Id" path="employeeId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="leadDate">Lead Date</label>
					<div>
						<form:input type="date" placeholder="Enter Lead Date" path="leadDate" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="stages">Stage</label>
					<div>
						<form:select placeholder="Enter Your Stage" path="stages" >
							<form:option value="Subscriber" label="Subscriber"></form:option>
							<form:option value="Lead/Nurturing" label="Lead/Nurturing"></form:option>
							<form:option value="MarketingQualifiedLead" label="Marketing Qualified Lead"></form:option>
							<form:option value="SalesQualifiedLead" label="Sales Qualified Lead"></form:option>
							<form:option value="Opportunity" label="Opportunity"></form:option>
						</form:select>
					</div>
				</div>
				<div>
					<label for="propability">Probability</label>
					<div>
						<form:input placeholder="Enter Probability" path="propability" name="propability" onblur="probabilityCheck()"
						pattern="^[0-9]+(.[0-9]*)?$" title="please Enter Valid Probabilty"/>
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