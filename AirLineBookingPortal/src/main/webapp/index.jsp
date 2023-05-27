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
	<%
	if (request.getParameter("error") != null)
		out.println("<b>Your session has expired or credentials are invalid.</b><br>");
	%>

<!-- 	<form action="list-of-flights.jsp" method="post"> -->
	<form action="FlightsListCriteria" method="post">
	
		<div style="padding-left:88px; padding-bottom:10px">Departure Airport <input name=origin id="origin" maxlength=40></div>
		<div style="padding-left:77px; padding-bottom:10px">Destination Airport <input name=destination id="destination" maxlength=40></div>
		<div style="padding-left:5px; padding-bottom:10px">Departure Date Month (1 to 3) <input name="month" id="month" maxlength=2></div>
		<div style="padding-left:13px; padding-bottom:10px">Departure Date Day (1 to 31) <input name="day" id="day" maxlength=2></div>
		<div style="padding-left:325px; padding-bottom:10px"><button>Submit</button></div>

	</form>
	
	
	

	