<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>get Leads For sales man</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="leads">
				<div>
					<label for="leadId">Lead Id</label>
					<div>
						<form:input path="leadId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="accountId">Account Id</label>
					<div>
						<form:input path="accountId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="status">Status</label>
					<div>
						<form:input path="status" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="employeeId">SellerId</label>
					<div>
						<form:input path="employeeId" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="leadDate">Lead Date</label>
					<div>
						<form:input path="leadDate" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="stages">Stage</label>
					<div>
						<form:input path="stages" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="propability">Probability</label>
					<div>
						<form:input path="propability" readonly="true"/>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div><a href="/leads/updateleadfrom?empId=${leads.leadId}"><button>update</button></a>
		<a href="/leads/deletelead?id=${leads.leadId}&empId=${employeeId}"><button>delete</button></a>
	</div>
</body>
</html>