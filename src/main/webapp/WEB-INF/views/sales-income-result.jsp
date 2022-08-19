<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="/WEB-INF/css/allemployee.css" %>
<%@include file="/WEB-INF/css/getemployeebyid.css" %>
</style>
</head>
<body>
	<div>
		<form:form action="" method="post" modelAttribute="salesIncome">
			<div class="form">
				<table>
				<caption></caption>
					<tr>
					<th></th></tr>
					<tbody>
						<tr>
							<td><label for="fromDate">From Date</label></td>
							<td><form:input path="fromDate" readonly="true" /></td>
						</tr>
						<tr>
							<td><label for="toDate">To Date</label></td>
							<td><form:input path="toDate" readonly="true" /></td>
						</tr>
						<tr>
							<td><label for="plannedLeads">Planned Lead</label></td>
							<td><form:input path="plannedLeads" readonly="true" /></td>
						</tr>
						<tr>
							<td><label for="commitedLeads">Committed Leads</label></td>
							<td><form:input path="commitedLeads" readonly="true" /></td>
						</tr>
						<tr>
							<td><label for="plannedSales">Planned Sales</label></td>
							<td><form:input path="plannedSales" readonly="true" /></td>
						</tr>
						<tr>
							<td><label for="closedSales">Closed Sales</label></td>
							<td><form:input path="closedSales" readonly="true" /></td>
						</tr>
						<tr>
							<td><label for="totalSalesAmount">Total Sales Amount</label>
							</td>
							<td><form:input path="totalSalesAmount" readonly="true" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form:form>
	</div>
	<div class="table">
	<table>
		<thead>
			<tr style="width: 100%, height:100%">
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