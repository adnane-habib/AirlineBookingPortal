package com.flyaway.servlet;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jakartaee.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.entities.TicketsReservation;
import com.flyaway.entities.PaymentTable;
import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class PaymentProcessing
 */
public class PaymentProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final String RESERVED = com.flyaway.entities.TicketsReservation.STATUSRESERVED;
	final String PAID = com.flyaway.entities.TicketsReservation.STATUSPAID;
	final String CANCELLED = com.flyaway.entities.TicketsReservation.STATUSCANCELLED;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentProcessing() {
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
		PrintWriter out = response.getWriter();
		
		HttpSession httpsession = request.getSession(false);//false = do not create new session
		
		if(httpsession==null) {
			out.println("HTTP session not found");
			response.sendRedirect("index.jsp");
			
		} else {
			
			//open a connection to DB			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			
			String bookingID = (String) httpsession.getAttribute("reservationCode");
			float balance = (float) httpsession.getAttribute("balancefloat");
			List<TicketsReservation> bookings = (List<TicketsReservation>) httpsession.getAttribute("bookings");
			Transaction tx = null;
			
			out.println("<html><body>");
			out.println(bookingID);
			out.println("<br>");
			out.println(balance);
			out.println("<br>");
			out.println(request.getParameter("cardfname"));
			out.println("<br>");
			out.println(request.getParameter("cardlname"));
			out.println("<br>");
			out.println(request.getParameter("card"));
			out.println("<br>");
			out.println(request.getParameter("cardmonth"));
			out.println("<br>");
			out.println(request.getParameter("cardyear"));
			out.println("<br>");
			out.println(request.getParameter("address"));
			out.println("<br>");
			out.println(new Timestamp(System.currentTimeMillis()));
			out.println("<br>");
			PaymentTable transaction = new PaymentTable(bookingID, request.getParameter("cardfname"), request.getParameter("cardlname"), 
					bookingID+request.getParameter("cardlname"),	StringUtils.right(request.getParameter("card"),4), 
					PAID, BigDecimal.valueOf(balance),new Timestamp(System.currentTimeMillis()));
			try {
				tx = session.beginTransaction();
			for (TicketsReservation booking : bookings) {
				out.println(booking.toString());
				booking.setStatus(PAID);
				session.merge(booking);
				session.persist(transaction);
				out.println("<br>");
			}tx.commit();
			httpsession.setAttribute("transaction", transaction);
			}catch (Exception e) {
				tx.rollback();
				response.sendRedirect("process-payment.jsp");
			}
			finally {
				response.sendRedirect("payment-confirmation.jsp");
				out.println("</body></html>");
			}
			
			
			
		}
	}

}
