<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Page</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
*{
margin: 0;
padding: 0;
}
body
 {
    background-image:
        url("https://www.phpcrmsystem.com/wp-content/uploads/crm_customer_management.jpg");
    background-repeat: no-repeat;
    background-size: 1366px 768px;
}
#welcome{color:white;
text-align: center;
font-size: 40px;
font-family: Times;
}
#admin{color:orange;
text-align: center;
font-size: 30px;
font-family: Times;
}
#customer{color:orange;
text-align: center;
font-size: 30px;
font-family:Times;
}
.menu{
width: 400px;
float: right;
height: 70px;
}
ul{
float: right;
display: flex;
justify-content: center;
align-items: center;
}
ul #home{
	color:white;
	float:left;
	margin-left: 100px;
	
}
ul li{
list-style: none;
margin-right: 62px;
margin-top: 27px;
font-size: 20px; 
}
ul li a{
text-decoration: none;
color: #fff;
font-family: Arial;
font-weight: bold;
transition: 0.4s ease-in-out;
}
ul li a:hover{
color: #ff7200;
}

</style>
</head>
<body>
	<div class="menu">
		<ul>
			<li id="home" class="w3-xxxlarge"><i class="fa fa-home"></i></li>
			<li><a href="/home/employees">Employee</a></li>
			<li><a href="/home/targets">Target</a></li>
			<li><a href="/home/lead?empId=${empId}">Leads and Sales</a></li>
			<li><a href="/home/territorys?empId=${empId}">Territory</a></li>
			<li><a href="/sales/salesincome?">InCome</a></li>
		</ul>
	</div>
</body>
</html>


