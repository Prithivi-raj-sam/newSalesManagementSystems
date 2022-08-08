<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
<style>
text-error {
    color: #e80c4d;
    font-size: 0.9em;
}
</style>
</head>


<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="addaccount" method="post" modelAttribute="addAccount">
				
				<div>
					<label for="companyName">Company Name</label>
					<div>
						<form:input path="companyName" />
						<form:errors path="companyName" cssClass="text-error" />
					</div>
				</div>
				<div>
					<label for="contactPerson">Contact Person</label>
					<div>
						<form:input path="contactPerson" />
						<form:errors path="contactPerson" cssClass="text-error" />
					</div>
				</div>
				<div>
					<label for="contactPersonRole">COntact Person Role</label>
					<div>
						<form:input path="contactPersonRole" />
						<form:errors path="contactPersonRole" cssClass="text-error" />
					</div>
				</div>
				<div>
					<label for="email">Email</label>
					<div>
						<form:input path="email" />
						<form:errors path="email" cssClass="text-error" />
					</div>
				</div>
				<div>
					<label for="contactPersonPhone">Contact Person Phone</label>
					<div>
						<form:input path="contactPersonPhone" />
						<form:errors path="contactPersonPhone" cssClass="text-error" />
					</div>
				</div>
				<div>
					<label for="address">Address</label>
					<div>
						<form:input path="address" />
						<form:errors path="address" cssClass="text-error" />
					</div>
				</div>
				<div>
					<label for="accountType">Account Type</label>
					<div>
						<form:input path="accountType" />
						<form:errors path="accountType" cssClass="text-error" />
					</div>
				</div>
				<div>
					<label for="employeeId">Market Id</label>
					<div>
						<form:input path="employeeId" />
						<form:errors path="employeeId" cssClass="text-error" />
					</div>
				</div>
				<div>
					<label for="leadThroughChannel">Lead Though Channel</label>
					<div>
						<form:input path="leadThroughChannel" />
						<form:errors path="leadThroughChannel" cssClass="text-error" />
					</div>
				</div>
				<div>
					<label for="customerJoinDate">Customer Join Date</label>
					<div>
						<form:input path="customerJoinDate" />
						<form:errors path="customerJoinDate" cssClass="text-error" />
					</div>
				</div>
				
				<label for="territoryId">Territory Name : </label> <form:select
                                path="territoryId" id="territoryId">
                                <form:option value="">--select territory--</form:option>
                                <c:forEach var="allTerritory" items="${allTerritory}">
                                    <form:option value="${allTerritory.territoryId}"
                                        label="${allTerritory.territoryName}" />
                                </c:forEach>
                            </form:select>
       
				<div>
					<form:button id="button">Add New</form:button>
				</div>
			</form:form>
		</div>
	</div>
	
		<div>${result}</div>		
	
</body>
</html>