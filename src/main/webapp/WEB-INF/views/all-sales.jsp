<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>all-sales</title>
<style>
<%@include file="/WEB-INF/css/allemployee.css" %>
</style>
</head>
<body>
<h1>All Sales List</h1>
	<div class="allsales-table">
		<table>
		<caption></caption>
			<thead>
				<tr>
					<th>Seller Name</th>
					<th>Account Name</th>
					<th>Sales Date</th>
					<th>Amount</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allsales" items="${allSales}" varStatus="status">
			   <tr>
			   	  <td id="get"><a href="/employee/getsalesandemployee?id=${allsales.employeeId}">${employeeName[status.index]}</a></td>
			   	  <td id="get2"><a href="/leads/getleadsandsales?id=${allsales.leadId}">${accountName[status.index]}</a></td>
			   	  <td>${allsales.salesDate}</td>
			   	  <td>${allsales.amount}</td>
			   	  <td id="view"><a href="/sales/getSales?id=${allsales.salesId}&empId=${empId}"><button>View</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	</body>
</html>