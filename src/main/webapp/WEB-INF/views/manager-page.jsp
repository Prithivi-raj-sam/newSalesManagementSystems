<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Page</title>
<style>
*{
margin: 0;
padding: 0;
}
body
 {
    background-image:
        url("https://images.hdqwalls.com/download/jeep-extreme-mudder-aw-1366x768.jpg");
    height: 768px;
    width: 1366px;
    background-position: center top;
    background-repeat: no-repeat;
    background-size: cover;
    position: relative;
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
float: left;
height: 70px;
}
ul{
float: left;
display: flex;
justify-content: center;
align-items: center;
}
ul li{
list-style: none;
margin-left: 62px;
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
			<li><a href="">Employee</a></li>
			<li><a href="">Target</a></li>
			<li><a href="">Leads</a></li>
			<li><a href="">Territory</a></li>
		</ul>
		<div>
			<a href="addemployeeform">Add Employee</a>
		</div>
		<div>
			<button onclick="addemployeeform"></button>
		</div>
		<div>
			<a href="updateemployee">update Employee</a>
		</div>
		<div>
			<a href="deleteemplyee">Delete Employee</a>
		</div>
		<div>
			<a href="getemployee">Get Employee</a>
		</div>
		<div>
			<button onclick="getemployee"></button>
		</div>
		<div>
			<a href="getallemplyee">All Employees</a>
		</div>

		<div>
			<a href="addTarget">Add Target</a>
		</div>
		<div>
			<a href="updatetarget">Update Target</a>
		</div>
		<div>
			<a href="getalltarget">All Target</a>
		</div>
		<div>
			<a href="gettarget">Get Target</a>
		</div>
		<div>
			<a href="deletetarget">Delete Target</a>
		</div>

		<div>
			<a href="getleads">Get Leads</a>
		</div>
		<div>
			<a href="getSales">Get Sales</a>
		</div>
		<div>
			<a href="getallSales">All Sales</a>
		</div>
		<div>
			<a href="getaccount">Get Account</a>
		</div>
		<div>
			<a href="getallaccount">All Account</a>
		</div>

		<div>
			<a href="getterritory">Get Territory</a>
		</div>
		<div>
			<a href="getallterritory">All Territory</a>
		</div>
	</div>

</body>
</html>


