<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All Leads By Account Id</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="getaccount">
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
					<label for="employeeId">Market Id</label>
					<div>
						<form:input path="employeeId" readonl="true"/>
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
	<div id="table root">
		<table>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Lead Id</th>
					<th>Account Id</th>
					<th>Status</th>
					<th>Seller Id</th>
					<th>Lead Date</th>
					<th>Stages</th>
					<th>Probability</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allLeads" items="${getlead}">
			   <tr>
			   	  <td>${allLeads.leadId}</td>
			   	  <td>${allLeads.accountId}</td>
			   	  <td>${allLeads.status}</td>
			   	  <td>${allLeads.sellerId}</td>
			   	  <td>${allLeads.leadDate}</td>
			   	  <td>${allLeads.stages}</td>
			   	  <td>${allLeads.propability}</td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>