<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales man Page</title>
<style>
<%@include file="/WEB-INF/css/employee.css"%>
#emp1{
float:right
}

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
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="/home/salesmanTarget">Target</a></li>
			<li><a href="/home/salesmanSales">Sales</a></li>
			<li><a href="/home/salesmanLeads">Leads</a></li>
		</ul>
		<div>
</div>
	  <div id="sale1"><iframe id="salesman" class="iframe" title='All Sales' src='/home/getallSales' 
	   style='border:10px solid #25195c' ></iframe></div>
	  </div>
</body>
</html>