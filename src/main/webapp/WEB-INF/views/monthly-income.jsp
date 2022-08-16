<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<form:form action="monthlysales" method="post" modelAttribute="salesIncome">
	           <div>
					<label for="fromDate">From Date</label>
					<div>
						<form:input path="fromDate" type="date"/>
					</div>
				</div>
				<div>
					<label for="toDate">To Date</label>
					<div>
						<form:input path="toDate" type="date"/>
					</div>
				</div>
				<div>
					<form:button>Get total Sales</form:button>
				</div>
				</form:form>
</div>
</body>
</html>