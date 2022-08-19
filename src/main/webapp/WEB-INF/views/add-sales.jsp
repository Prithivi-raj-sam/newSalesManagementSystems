<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add leads to sales</title>
<style>
<%@include file="/WEB-INF/css/allemployee.css" %>
</style>
</head>
<body>
<h1>Adding To Sales</h1>
	<div class="table-root">
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
					<th>Close</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allLeads" items="${leadList}">
			   <tr>
			   	  <td>${allLeads.leadId}</td>
			   	  <td>${allLeads.accountId}</td>
			   	  <td>${allLeads.status}</td>
			   	  <td>${allLeads.employeeId}</td>
			   	  <td>${allLeads.leadDate}</td>
			   	  <td>${allLeads.stages}</td>
			   	  <td>${allLeads.propability}</td>
			   	  <td><a href="/sales/addsalesform?id=${allLeads.leadId}&empId=${empId}"><button>AddToSales</button></a></td>
			   	  <td><a href="/leads/closeleads?id=${allLeads.leadId}&empId=${empId}"><button>Close</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>