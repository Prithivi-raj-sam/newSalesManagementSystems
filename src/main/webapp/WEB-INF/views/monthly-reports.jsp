<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Monthly Reports</title>
</head>
<body>

	<div id="table root">
		<table>
		<caption></caption>
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
	</div>
</body>
</html>