<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Leads</title>
<style type="text/css">
<%@include file="/WEB-INF/css/allemployee.css" %>
</style>
</head>
<body>
	<div class="table">
		<table>
		<caption></caption>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Account Name</th>
					<th>Status</th>
					<th>Seller Name</th>
					<th>Lead Date</th>
					<th>Stages</th>
					<th>Probability</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allLeads" items="${allLeads}">
			
			   <tr>
			   	  <td id="get"><a href="/account/getacountandleads?id=${allLeads.accountId}">${allLeads.accountName}</a></td>
			   	  <td>${allLeads.status}</td>
			   	  <td id="get2"><a href="/employee/getleadsandemployee?id=${allLeads.employeeId}">${allLeads.employeeName}</a></td>
			   	  <td>${allLeads.leadDate}</td>
			   	  <td>${allLeads.stages}</td>
			   	  <td>${allLeads.probablity}</td>
			   	  <td id="view"><a href="/leads/getlead?id=${allLeads.leadId}&empId=${empId}"><button>view</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>