<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Confirmation</title>
</head>
<h1>Payment Confirmation</h1>
<body>

<jsp:useBean id="transaction" class="com.flyaway.entities.PaymentTable" scope="session"></jsp:useBean>

Booking ID: <jsp:getProperty property="bookingID" name="transaction" />
<br>
Total paid: $ <%out.println(session.getAttribute("balance"));%>
<br>
Transaction ID: <jsp:getProperty property="transactionId" name="transaction" />

<br>
<a href = "index.jsp">Go back to main page</a><br>



</body>
</html>