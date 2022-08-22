<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Target</title>
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
					<th>Target Date</th>
					<th>Planned Target</th>
					<th>closed Target</th>
					<th>Employee Name</th>
					<th>Manager Comment</th>
					<th>Target Month</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="alltargets" items="${alltargets}" varStatus="status">
			   <tr>
			   	  <td>${alltargets.targetDate}</td>
			   	  <td>${alltargets.plannedTarget}</td>
			   	  <td>${alltargets.closedTarget}</td>
			   	  <td>${employeeName[status.index]}</td>
			   	  <td>${alltargets.managerComment}</td>
			   	  <td>${alltargets.targetSetDate}</td>
			   	  <td id="view"><a href="/target/gettarget?targetId=${alltargets.targetId}"><button>View</button></a></td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>