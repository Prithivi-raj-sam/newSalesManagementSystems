<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
			<form:form action="" method="post" modelAttribute="salesIncome">
	           <div>
					<label for="fromDate">From Date</label>
					<div>
						<form:input path="fromDate" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="toDate">To Date</label>
					<div>
						<form:input path="toDate" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="plannedLeads">Planned Lead</label>
					<div>
						<form:input path="plannedLeads" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="commitedLeads">Committed Leads</label>
					<div>
						<form:input path="commitedLeads" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="plannedSales">Planned Sales</label>
					<div>
						<form:input path="plannedSales" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="closedSales">Closed Sales</label>
					<div>
						<form:input path="closedSales" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="totalSalesAmount">Total Sales Amount</label>
					<div>
						<form:input path="totalSalesAmount" readonly="true"/>
					</div>
				</div>
			</form:form>
</div>

		<table>
			<thead>
				<tr style="width:100% , height:100%">
					<th>From Date</th>
					<th>To Date</th>
					<th>Planned Leads</th>
					<th>Committed Leads</th>
					<th>Planned Sales</th>
					<th>Closed Sales</th>
					<th>Total Amount</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="salesList" items="${salesIncomeList}">
			   <tr>
			   	  <td>${salesList.fromDate}</td>
			   	  <td>${salesList.toDate}</td>
			   	  <td>${salesList.plannedLeads}</td>
			   	  <td>${salesList.commitedLeads}</td>
			   	  <td>${salesList.plannedSales}</td>
			   	  <td>${salesList.closedSales}</td>
			   	  <td>${salesList.totalSalesAmount}</td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>

</body>
</html>