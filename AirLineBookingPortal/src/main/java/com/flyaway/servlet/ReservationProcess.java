package com.flyaway.servlet;
import com.flyaway.entities.FlightsDetails;
import com.flyaway.entities.TicketsReservation;
import com.flyaway.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
  

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Servlet implementation class ReservationProcess
 */

public class ReservationProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final String RESERVED = com.flyaway.entities.TicketsReservation.STATUSRESERVED;
	final String PAID = com.flyaway.entities.TicketsReservation.STATUSPAID;
	final String CANCELLED = com.flyaway.entities.TicketsReservation.STATUSCANCELLED;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		
		HttpSession httpsession = request.getSession(false);//false = do not create new session
		
		if(httpsession==null) {
			out.println("HTTP session not found");
			response.sendRedirect("index.jsp");
			
		} else {
		
		
			FlightsDetails flight = (FlightsDetails) httpsession.getAttribute("flight");
			String reservationCode = (String) httpsession.getAttribute("reservationCode");
			
			out.println("<html><body>");
		
			out.println(httpsession.getAttribute("flight"));
		
			SessionFactory factory = HibernateUtil.getSessionFactory();
		
			//open a connection to DB
			Session session = factory.openSession();
		
			Criteria crFlight = session.createCriteria(FlightsDetails.class);
			Criteria crReservation = session.createCriteria(TicketsReservation.class);
		

			//Long id = Long.parseLong(request.getParameter("id"));//2;		
			//String flightId = request.getParameter("flightID");
			String fName = request.getParameter("fname");
			String lName = request.getParameter("lname");
			String bDate = request.getParameter("bdate");
			String expdate = request.getParameter("expdate");
	
			String idnumber = request.getParameter("idnumber");
			String citizenship = request.getParameter("citizenship");
			String phone = request.getParameter("phone");
			
			Long flightID = flight.getId();
			
			if (reservationCode==null ) {
				reservationCode = lName + flightID.toString() + flightID;
			}
			
			TicketsReservation reservation = new TicketsReservation(flight.getMonth(), flight.getDay(), reservationCode, flightID, 
					fName, lName, bDate, expdate, phone, idnumber, citizenship, flight.getAirLine()+flight.getFlightNumber().toString(), 
					flight.getScheduledTime(), RESERVED, flight.getTicketPrice());
		
			Transaction tx = null;
		
			try {
		
			out.println("<br>"+reservation.toString());
			out.println("<br>"+flightID);
			//out.println(flightId);
			out.println("<br>Before Update "+flight.getFreeSeats());
			tx = session.beginTransaction();
			flight.setFreeSeats(flight.getFreeSeats()-1);
			session.merge(flight);
			session.persist(reservation);
			
			tx.commit();
			out.println(reservation.toString());
			httpsession.setAttribute("flight", flight);
			httpsession.setAttribute("reservationCode", reservation.getBookingID());
			httpsession.setAttribute("lastName", reservation.getLastName());
			httpsession.setAttribute("reservation", reservation);
			
			out.println("<br>After Update "+flight.getFreeSeats());
			} catch (Exception e) {
				tx.rollback();
			}
			finally {
			session.close();
			
			out.println("<br><br><a href = booking.jsp>Back Home</a>");
			
			out.println("</body></html>");	
		
			response.sendRedirect("BookingManagement");
		
			}
		
		
	}}

}
