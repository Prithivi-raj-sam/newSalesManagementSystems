<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Account</title>
<style type="text/css">
<%@include file="/WEB-INF/css/allemployee.css" %>
</style>

</head>
<body>
	<div id="table root">
		<table>
		<caption></caption>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Company Name</th>
					<th>Contact Person</th>
					<th>Contact Person Role</th>
					<th>Email</th>
					<th>Contact Person Phone</th>
					<th>Address</th>
					<th>Account Type</th>
					<th>Market Id</th>
					<th>Lead Through Channel</th>
					<th>Customer Join Date</th>
					<th>Territory Id</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allaccount" items="${allaccount}">
			   <tr>
			   	  <td>${allaccount.companyName}</td>
			   	  <td>${allaccount.contactPerson}</td>
			   	  <td>${allaccount.contactPersonRole}</td>
			   	  <td>${allaccount.email}</td>
			   	  <td>${allaccount.contactPersonPhone}</td>
			   	  <td>${allaccount.accountType}</td>
			   	  <td id="get"><a href="/employee/getaccountsemployee?id=${allaccount.employeeId}">${allaccount.employeeId}</a></td>
			   	  <td>${allaccount.leadThroughChannel}</td>
			   	  <td id="view"><a href="/account/getaccount?id=${allaccount.accountId}&empId=${empId}"><button>View</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>