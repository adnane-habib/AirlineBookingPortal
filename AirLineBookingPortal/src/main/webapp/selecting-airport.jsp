<%@page import="com.flyaway.entities.AirportsDetails"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Select Departure and Arrival Airports</h2>
	<h3>
		For Departure City
		<%
	out.println(session.getAttribute("origin"));
	%>, we have the following
		airport(s)
	</h3>
	<%
	List<AirportsDetails> origins = (List<AirportsDetails>) session.getAttribute("origins");
	for (AirportsDetails origin : origins) {
		out.println("Airport Code <b>" + origin.getIataCode() + "</b> and Airport name <b>" + origin.getAirportName()+"</b> &emsp; &emsp;");
		out.println("&nbsp;<a href=\"selecting-airport.jsp?origincode=" + origin.getIataCode()
		+ "\">click here to select this airport</a>");
	%><br>
	<%
	}
	%><br>

		<%!String originIata = null;%>
		<%
		if (request.getParameter("origincode") != null) {
			
			session.setAttribute("originiata", request.getParameter("origincode"));}
		%>


	<h3>
		For Arrival City
		<%
	out.println(session.getAttribute("destination"));
	%>, we have the
		following airports
	</h3>
	<%
	List<AirportsDetails> destinations = (List<AirportsDetails>) session.getAttribute("destinations");
	for (AirportsDetails destination : destinations) {
		out.println("Airport Code <b>" + destination.getIataCode() + "</b> and Airport name <b>" + destination.getAirportName()+"</b> &emsp; &emsp;");
		out.println("&nbsp;<a href=\"selecting-airport.jsp?arrivalcode=" + destination.getIataCode()
		+ "\">click here to select this airport</a>");
	%><br>
	<%
	}
	%><br>
			<%!String arrivalIata = null;%>
		<%
		if (request.getParameter("arrivalcode") != null) {
			
			session.setAttribute("arrivaliata", request.getParameter("arrivalcode"));}
		%>
	
		<br>
	<%originIata = (String) session.getAttribute("originiata");
	arrivalIata = (String) session.getAttribute("arrivaliata");%>
	
	
	
	<h3>Select a date to continue</h3>
	<form action="FlightsListCriteria" method="post">


		<div style="padding-left: 5px; padding-bottom: 10px"><%="Departure Airport is &emsp;<b>" + originIata+"</b>"%><input
				type="hidden" name="origin" id="origin" value=<%=originIata%>>
		</div>
		
		<div style="padding-left: 5px; padding-bottom: 10px"><%="Arrival Airport is &emsp;<b>" + arrivalIata+"</b>"%><input
				type="hidden" name="destination" id="destination"
				value=<%=arrivalIata%>>
		</div>

		<div style="padding-left: 5px; padding-bottom: 10px">
			Departure Date Month (1 to 3) <input name="month" id="month"
				maxlength=2>
		</div>
		<div style="padding-left: 5px; padding-bottom: 10px">
			Departure Date Day (1 to 31) &ensp;<input name="day" id="day"
				maxlength=2>
		</div>
		<%if(originIata!=null && arrivalIata!=null ) {%>
		<div style="padding-left: 325px; padding-bottom: 10px">
			<button>Submit</button>
		</div>
		<%}%>

	</form>

</body>
</html>