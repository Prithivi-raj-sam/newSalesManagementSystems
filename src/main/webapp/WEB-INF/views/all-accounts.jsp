<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Account</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="table root">
		<table>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Account Id</th>
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
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allaccount" items="${allaccount}">
			   <tr>
			   	  <td>${allaccount.accountId}</td>
			   	  <td>${allaccount.companyName}</td>
			   	  <td>${allaccount.contactPerson}</td>
			   	  <td>${allaccount.contactPersonRole}</td>
			   	  <td>${allaccount.email}</td>
			   	  <td>${allaccount.contactPersonPhone}</td>
			   	  <td>${allaccount.address}</td>
			   	  <td>${allaccount.accountType}</td>
			   	  <td>${allaccount.employeeId}</td>
			   	  <td>${allaccount.leadThroughChannel}</td>
			   	  <td>${allaccount.customerJoinDate}</td>
			   	  <td>${allaccount.territoryId}</td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>