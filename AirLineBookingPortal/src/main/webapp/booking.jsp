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
<br>

<body>
	<%-- 	<%
	if (request.getParameter("error") != null)
		out.println("<b>Your session has expired or credentials are invalid.</b><br>");
		response.sendRedirect("index.jsp?error=1");
	%> --%>


	<div>You are about to book the following flight:</div>
	<br>
	<%
	FlightsDetails flight = (FlightsDetails) session.getAttribute("flight");

	out.println("Flight Number " + flight.getAirLine() + flight.getFlightNumber());
	%><br>
	<%
	out.println("From: " + flight.getOriginAirport() + " TO : " + flight.getDestinationAirport());
	%><br>
	<%
	out.println("Traveling on " + String.format("%02d", flight.getMonth()) + "/" + String.format("%02d", flight.getDay())
			+ " AT " + String.format("%04d", flight.getScheduledDeparture()));
	%><br>
	<%
	out.println("Ticket Cost is " + String.format("%.2f", flight.getTicketPrice()) + "US$");
	%><br>
	<h2>To Book a seat, fill out the following information</h2>
	<%
	session.setAttribute("flight", flight);
	String flightid = flight.getId().toString();
	%>
	
	<jsp:useBean id="reservation" class="com.flyaway.entities.TicketsReservation" scope="session"></jsp:useBean>
	<%if (reservation.getBookingID()!=null){ %>
	Your Booking ID is : <jsp:getProperty property="bookingID" name="reservation" /><br>
	You have reserved  :			<%out.println(session.getAttribute("reservedtickets"));%> ticket(s)<br>
	The total price is :		  $	<%out.println(session.getAttribute("total"));%><br>
	Current payment balance is  : $	<%out.println(session.getAttribute("balance"));%><br><br>
	<a href=process-payment.jsp>Process your payment</a><br><br>Or book another seat:<br>
	<%} %><br><br><br>
	
	<form action="ReservationProcess" method="post">

		<div style="padding-left: 30px; padding-bottom: 10px">
			Passenger First Name <input name="fname" id="fname" maxlength=40>
		</div>
		<div style="padding-left: 32px; padding-bottom: 10px">
			Passenger Last Name <input name="lname" id="lname" maxlength=40>
		</div>
		<div style="padding-left: 86px; padding-bottom: 10px">
			Date of Birth <input type="date" name="bdate" id="bdate" maxlength=40>
		</div>
		<div style="padding-left: 22px; padding-bottom: 10px">
			ID or Passport Number <input name="idnumber" id="idnumber"
				maxlength=40>
		</div>
		<div style="padding-left: 70px; padding-bottom: 10px">
			ID Expiry Date <input type="date" name="expdate" id="expdate"
				maxlength=40>
		</div>
		<div style="padding-left: 97px; padding-bottom: 10px">
			Citizenship <input name="citizenship" id="citizenship" maxlength=40>
		</div>
		<div style="padding-left: 75px; padding-bottom: 10px">
			Phone Number <input type="tel" name="phone" id="phone" maxlength=40>
		</div>
		<%--  <input type="hidden" id="flightID" name="flightID" value=<%=flight.getId().toString()%>> --%>
		<div style="padding-left: 295px; padding-bottom: 10px">
			<button>Submit</button>
		</div>

	</form>
	
	
