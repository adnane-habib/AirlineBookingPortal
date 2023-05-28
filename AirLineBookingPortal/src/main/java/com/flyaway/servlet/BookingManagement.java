package com.flyaway.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.flyaway.entities.TicketsReservation;
import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class BookingManagement
 */
public class BookingManagement extends HttpServlet {
	final String RESERVED = com.flyaway.entities.TicketsReservation.STATUSRESERVED;
	final String PAID = com.flyaway.entities.TicketsReservation.STATUSPAID;
	final String CANCELLED = com.flyaway.entities.TicketsReservation.STATUSCANCELLED;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		HttpSession httpsession = request.getSession(false);//false = do not create new session
		
		if(httpsession==null) {
			out.println("HTTP session not found");
			response.sendRedirect("index.jsp");
			
		} else {
		
		
			
			String bookingID = (String) httpsession.getAttribute("reservationCode");
			String lastName = (String) httpsession.getAttribute("lastName");
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			//open a connection to DB
			Session session = factory.openSession();
			
			Criteria cr = session.createCriteria(TicketsReservation.class);
			
			cr.add(Restrictions.eq("bookingID", bookingID));
			
			out.println("<html><body>");
			out.println(bookingID);
			out.println("<br>");
			out.println(lastName);
			out.println("<br><br><br>"); 
			float totalPrice = 0;
			float totalBalance = 0; 
			float totalPaid = 0;
			int bookingTotalCount = 0;
			int bookingReservedCount = 0; 
			int bookingPaidCount = 0; 	
			
			List<TicketsReservation> bookings = cr.list();
			for (TicketsReservation booking : bookings) {
				out.println(booking.toString());
				out.println("<br>");
				bookingTotalCount += 1;
				float price = booking.getTicketPrice().floatValue();
				totalPrice += price;
				if (booking.getStatus().equals(RESERVED)) {
					bookingReservedCount += 1;
					totalBalance += price;
					
				} else if (booking.getStatus().equals(PAID)) {
					bookingPaidCount += 1;
					totalPaid += price;
					
				}
				
			}
			
			out.println("<br>Total price is "+totalPrice);
			out.println("<br>Total balance is "+totalBalance);
			out.println("<br>Total reservedtickets is "+bookingReservedCount);
			out.println("<br>Total bookedtickets is "+bookingTotalCount);
			out.println("<br>");
			
			out.println("</body></html>");
			httpsession.setAttribute("bookings", bookings);
			httpsession.setAttribute("total", String.format("%.2f", totalPrice));
			httpsession.setAttribute("balance", String.format("%.2f", totalBalance));
			httpsession.setAttribute("balancefloat", totalBalance);
			httpsession.setAttribute("reservedtickets", bookingReservedCount);
			httpsession.setAttribute("bookedtickets", bookingTotalCount);
			response.sendRedirect("booking.jsp");
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
