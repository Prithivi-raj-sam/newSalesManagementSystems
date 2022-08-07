<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales Income</title>
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
					<form:button>Get total Sales</form:button>
				</div>
				</form:form>
</div>
</body>
</html>