<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
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
			<c:forEach var="salesList" items="${salesList}">
			   <tr>
			   	  <td>${salesList.salesId}</td>
			   	  <td>${salesList.employeeId}</td>
			   	  <td>${salesList.leadId}</td>
			   	  <td>${salesList.salesDate}</td>
			   	  <td>${salesList.amount}</td>
			   	  <td><a href="/sales/getSales?id=${salesList.salesId}&empId=${salesList.employeeId}"><button>view</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>