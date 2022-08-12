<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Target</title>
</head>
<body style="background-color:#3d403d; color:white;">
	<div id="table root">
		<table>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Target Id</th>
					<th>Target Date</th>
					<th>Planned Target</th>
					<th>closed Target</th>
					<th>Employee Id</th>
					<th>Manager Comment</th>
					<th>Target Month</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="alltargets" items="${alltargets}">
			   <tr>
			   	  <td>${alltargets.targetId}</td>
			   	  <td>${alltargets.targetDate}</td>
			   	  <td>${alltargets.plannedTarget}</td>
			   	  <td>${alltargets.closedTarget}</td>
			   	  <td>${alltargets.employeeId}</td>
			   	  <td>${alltargets.managerComment}</td>
			   	  <td>${alltargets.targetSetDate}</td>
			   	  <td><a href="/target/gettarget?targetId=${alltargets.targetId}"><button>view</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>