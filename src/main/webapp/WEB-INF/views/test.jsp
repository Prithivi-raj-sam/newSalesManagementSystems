<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>test</title>
</head>
<body>
<h1>Success</h1>
	<form action="SessionDemo.jsp">
		Add New Todo: <input type = "text" name="todo" />
		<input type = "submit" value="Submit" />
	</form>
	<% 
	    Set<String> todos = (Set<String>) session.getAttribute("todos");
	
	if(todos == null) {
		todos = new HashSet<String>();
		session.setAttribute("todos", todos);
	}
	String todo = request.getParameter("todo");
	if(todo != null) {
		todos.add(todo);
	}
	%>
	
	<br/><br/>
	<b>My upcoming todos:</b>
	<ol>
		<%
			for(String temp : todos) {
				out.println("<li>"+temp+"</li>");
			}
		%>
	</ol>
</body>
</html>