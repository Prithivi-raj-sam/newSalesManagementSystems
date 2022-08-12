<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Territory</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="table root">
		<table>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Territory Id</th>
					<th>Territory Name</th>
					<th>No Of Customer</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allteritory" items="${allteritory}">
			   <tr>
			   	  <td>${allteritory.territoryId}</td>
			   	  <td>${allteritory.territoryName}</td>
			   	  <td>${allteritory.noOfCustomer}</td>
			   	  <td><a href="/territory/getaccountsandterritory?id=${allteritory.territoryId}&empId=${empId}"><button>view Account</button></a></td>
			   	  <td><a href="/territory/getemployeeandterritory?id=${allteritory.territoryId}&empId=${empId}"><button>view Employee</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>