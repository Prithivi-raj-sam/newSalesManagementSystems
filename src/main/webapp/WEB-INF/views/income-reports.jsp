<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Income Reports</title>
<style>
	<%@include file="/WEB-INF/css/employee.css"%>
.iframe {
   position: absolute;
   top:65%;
   right: 0%;
   width: 1000px;
   height: 500px;
   margin-top: -400px;
   margin-right: 20px;
   z-index: 999;
   border-radius:20px;
}
</style>
<script>
var show = function() {
	var myElement = document.getElementById("total");
	if (myElement) myElement.style.display = "block";
	var myElement = document.getElementById("monthly");
	if (myElement) myElement.style.display = "block";
}
</script>
</head>
<body>
<div class="menu">
	<form:form action="" method="post" modelAttribute="salesIncome">
		<ul>
			<li><form:input path="fromDate" type="date" placeholder="Enter From Date"/></li>
			<li><form:input path="toDate" type="date"/></li>
			<li id="search" onclick="show()"><form:button>getResult</form:button></li>
		</ul>
		</form:form>
		</div>
<div>
	<div id="total" style="display: none;"><iframe id="totalIncome" class="iframeleft" title='Total Income' src='/sales/salesTotalAmount?fromDate=${salesIncome.fromDate}&toDate=${salesIncome.toDate}' 
	   style='border:10px solid #25195c' ></iframe></div>
</div>
<div>
	<div id="monthly" style="display: none;"><iframe id="monthlyIncome" class="iframe" title='Monthly Income' src='/sales/monthlysales?fromDate=${salesIncome.fromDate}&toDate=${salesIncome.toDate}' 
	   style='border:10px solid #25195c' ></iframe></div>
</div>
</body>
</html>