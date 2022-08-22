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
					<th>Account Type</th>
					<th>Marketer Name</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allaccount" items="${allaccount}" varStatus="status">
			   <tr>
			   	  <td>${allaccount.companyName}</td>
			   	  <td>${allaccount.contactPerson}</td>
			   	  <td>${allaccount.contactPersonRole}</td>
			   	  <td>${allaccount.email}</td>
			   	  <td>${allaccount.contactPersonPhone}</td>
			   	  <td>${allaccount.accountType}</td>
                  <td><a href="/employee/getaccountsemployee?id=${allaccount.employeeId}">${employeeName[status.index]}</a></td>
			   	  <td id="view"><a href="/account/getaccount?id=${allaccount.accountId}"><button>View</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>