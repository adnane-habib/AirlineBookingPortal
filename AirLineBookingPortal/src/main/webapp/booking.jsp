<%@page import="com.flyaway.entities.FlightsDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to FlyWare</title>
</head>
<h1>Select Your Flight</h1>
<br><br><br>

<body>
<%-- 	<%
	if (request.getParameter("error") != null)
		out.println("<b>Your session has expired or credentials are invalid.</b><br>");
		response.sendRedirect("index.jsp?error=1");
	%> --%>
	
	
	
	<%
		FlightsDetails string =(FlightsDetails) session.getAttribute("flight");
		out.println(session.getAttribute("flight"));%>
		<br><%
		out.println("Value is "+string.toString());
	%>


	
	

	