<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Monthly Account Count Of Employees</title>
<style>
<%@include file="/WEB-INF/css/allemployee.css"%>
</style>
</head>
<body>
	<div id="table root">
		<table>
		<caption></caption>
			<thead>
				<tr style="width:100% , height:100%">
					
					<th>Marketer Name</th>
					<th>Account Count</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="accountcount" items="${accountList}" varStatus="status">
			   <tr>
                  <td>${employeeName[status.index]}</td>
			   	  <td>${accountcount.accountId}</td>
			   	  <td id="view"><a href="/employee/getaccountsemployee?id=${accountcount.employeeId}"><button>View</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
					
					
					
					
					
					