<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Employees Target</title>
<style type="text/css">
<%@include file="/WEB-INF/css/allemployee.css"%>
</style>
</head>
<body>
<h1>Target List Of Employees</h1>
	<div class="employeetarget-table">
		<table>
		<caption></caption>
			<thead>
				<tr style="width:100% , height:100%">
					<th>Target Date</th>
					<th>Planned Target</th>
					<th>closed Target</th>
					<th>Manager Comment</th>
					<th>Target Set Date</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="targetList" items="${targetList}">
			   <tr>
			   	  <td>${targetList.targetDate}</td>
			   	  <td>${targetList.plannedTarget}</td>
			   	  <td>${targetList.closedTarget}</td>
			   	  <td>${targetList.managerComment}</td>
			   	  <td>${targetList.targetSetDate}</td>
			   </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>