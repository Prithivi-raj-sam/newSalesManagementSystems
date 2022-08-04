<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all-sales</title>
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
			   	  <td>${allsales.sellerId}</td>
			   	  <td>${allsales.leadId}</td>
			   	  <td>${allsales.salesDate}</td>
			   	  <td>${allsales.amount}</td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>