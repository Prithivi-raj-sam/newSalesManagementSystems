<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Monthly Employee Sale</title>
<style>
<%@include file="/WEB-INF/css/allemployee.css"%>
</style>
</head>
<body>
<div class="allsales-table">
		<table>
		<caption></caption>
			<thead>
				<tr>
					<th>Seller Name</th>
					<th>Amount</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
	<c:forEach var="employeeSales" items="${monthlyEmployeeSales}" varStatus="status">
		 <tr>
			   	  <td id="get"><a >${employeeName[status.index]}</a></td>
			   	  <td>${employeeSales.amount}</td>
			   	  <td id="view"><a href="/employee/getsalesandemployee?id=${employeeSales.employeeId}"><button>View</button></a></td>
			   </tr>
	</c:forEach>
	</tbody></table></div>
</body>
</html>