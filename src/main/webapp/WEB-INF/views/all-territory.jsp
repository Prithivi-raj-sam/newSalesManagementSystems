<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Territory</title>
<style>
<%@include file="/WEB-INF/css/allemployee.css" %>
</style>
</head>
<body>
	<div class="table">
		<table>
		<caption></caption>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Territory Name</th>
					<th>No Of Customer</th>
					<th>view Account</th>
					<th>view Employee</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allteritory" items="${allteritory}">
			   <tr>
			   	  <td id="get"><a href="/territory/getterritory?id=${allteritory.territoryId}&empId=${empId}">${allteritory.territoryName}</a></td>
			   	  <td>${allteritory.noOfCustomer}</td>
			   	  <td id="get2"><a href="/territory/getaccountsandterritory?id=${allteritory.territoryId}&empId=${empId}"><button>view Account</button></a></td>
			   	  <td id="view"><a href="/territory/getemployeeandterritory?id=${allteritory.territoryId}&empId=${empId}"><button>view Employee</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>