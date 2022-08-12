<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Leads</title>
<style type="text/css">
table, th, td {
  border: 2px solid white;
}
a{
text-decoration:none;
color:white;
}
</style>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="table root">
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
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allLeads" items="${allLeads}">
			   <tr>
			   	  <td>${allLeads.leadId}</td>
			   	  <td><a href="/account/getacountandleads?id=${allLeads.accountId}">${allLeads.accountId}</a></td>
			   	  <td>${allLeads.status}</td>
			   	  <td><a href="/employee/getleadsandemployee?id=${allLeads.employeeId}">${allLeads.employeeId}</a></td>
			   	  <td>${allLeads.leadDate}</td>
			   	  <td>${allLeads.stages}</td>
			   	  <td>${allLeads.propability}</td>
			   	  <td><a href="/leads/getlead?id=${allLeads.leadId}&empId=${empId}"><button>view</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>