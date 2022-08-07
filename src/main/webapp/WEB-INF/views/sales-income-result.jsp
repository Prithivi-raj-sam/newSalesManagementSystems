<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
			<form:form action="addlead" method="post" modelAttribute="addLead">
	           <div>
					<label for="fromDate">Lead Date</label>
					<div>
						<form:input path="fromDate" />
					</div>
				</div>
				<div>
					<label for="toDate">Lead Date</label>
					<div>
						<form:input path="toDate" />
					</div>
				</div>
				<div>
					<label for="plannedLeads">Lead Date</label>
					<div>
						<form:input path="plannedLeads" />
					</div>
				</div>
				<div>
					<label for="commitedLeads">Lead Date</label>
					<div>
						<form:input path="commitedLeads" />
					</div>
				</div>
				<div>
					<label for="plannedSales">Lead Date</label>
					<div>
						<form:input path="plannedSales" />
					</div>
				</div>
				<div>
					<label for="closedSales">Lead Date</label>
					<div>
						<form:input path="closedSales" />
					</div>
				</div>
				<div>
					<label for="totalSalesAmount">Lead Date</label>
					<div>
						<form:input path="totalSalesAmount" />
					</div>
				</div>
				
			</form:form>
</div>
</body>
</html>