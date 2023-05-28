<%@page import="com.flyaway.entities.FlightsDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to FlyWare</title>
</head>
<h1>Payment Processing</h1>
<br>

<body>
	<%-- 	<%
	if (request.getParameter("error") != null)
		out.println("<b>Your session has expired or credentials are invalid.</b><br>");
		response.sendRedirect("index.jsp?error=1");
	%> --%>


	<div>You are about to book the following flight:</div>
	
	<jsp:useBean id="reservation" class="com.flyaway.entities.TicketsReservation" scope="session"></jsp:useBean>
	<%if (reservation.getBookingID()!=null){ %>
	Your Booking ID is : <jsp:getProperty property="bookingID" name="reservation" /><br>
	You have reserved  :			<%out.println(session.getAttribute("reservedtickets"));%> ticket(s)<br>
	The total price is :		  $	<%out.println(session.getAttribute("total"));%><br>
	Current payment balance is  : $	<%out.println(session.getAttribute("balance"));%><br><br>
	You will be charged: 		  $	<%out.println(session.getAttribute("balance"));%><br><br>
	<%} %><br><br><br>
	
	<form action="PaymentProcessing" method="post">

		<div style="padding-left: 0px; padding-bottom: 10px">
			Card Holder First Name &nbsp; &ensp; <input name="cardfname" id="cardfname" maxlength=40>
		</div>
		<div style="padding-left: 0px; padding-bottom: 10px">
			Card Holder Last Name &nbsp; &ensp; <input name="cardlname" id="cardlname" maxlength=40>
		</div>		
		<div style="padding-left: 0px; padding-bottom: 10px">
			Credit Card Number &ensp; &nbsp; &ensp; &ensp;<input name="card" id="card" maxlength=40>
		</div>
		<div style="padding-left: 0px; padding-bottom: 10px">
			Expiration Month &emsp; &emsp; &ensp; &ensp;<input name="cardmonth" id="cardmonth" maxlength=2>
		</div>
		<div style="padding-left: 0px; padding-bottom: 10px">
			Expiration year &emsp; &emsp;&emsp; &ensp; &nbsp;<input name="cardyear" id="cardyear" maxlength=4>
		</div>

		<div style="padding-left: 0px; padding-bottom: 10px">
			Billing Address &emsp; &emsp;&emsp; &ensp; &nbsp;<input name="address" id="address" maxlength=100>
		</div>

		<%--  <input type="hidden" id="flightID" name="flightID" value=<%=flight.getId().toString()%>> --%>
		<div style="padding-left: 295px; padding-bottom: 10px">
			<button>Submit</button>
		</div>

	</form>
	
	
