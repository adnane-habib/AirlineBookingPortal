<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
String origin = request.getParameter("origin");
String destination = request.getParameter("destination");  
//String month = request.getParameter("month");
//String day = request.getParameter("day");
 int month = Integer.parseInt(request.getParameter("month"));
 int day = Integer.parseInt(request.getParameter("day"));
%>
	<br>
	<div style="color: red">
	Origin City is 
		<%
		out.println(origin.toUpperCase());
		%><br>
	Destination City is 
		<%
		out.println(destination.toUpperCase());
		%><br>
	Departure date is 
		<%
		out.println(month);
		%> / 
		<%
		out.println(day);
		%>
	</div>
	
	<%
	session.setAttribute("origin", origin);
	session.setAttribute("destination", destination);
	session.setAttribute("month", month);
	session.setAttribute("day", day);
	response.sendRedirect("FlightsListCriteria");	
	%>