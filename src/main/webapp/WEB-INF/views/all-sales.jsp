<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all-sales</title>
<style>
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
					<th>Sales Id</th>
					<th>Seller Id</th>
					<th>Lead Id</th>
					<th>Sales Date</th>
					<th>Amount</th>
					
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allsales" items="${allSales}">
			   <tr>
			   	  <td>${allsales.salesId}</td>
			   	  <td><a href="/employee/getsalesandemployee?id=${allsales.employeeId}">${allsales.employeeId}</a></td>
			   	  <td><a href="/leads/getleadsandsales?id=${allsales.leadId}">${allsales.leadId}</a></td>
			   	  <td>${allsales.salesDate}</td>
			   	  <td>${allsales.amount}</td>
			   	  <td><a href="/sales/getSales?id=${allsales.salesId}&empId=${empId}"><button>view</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</body>
</html>