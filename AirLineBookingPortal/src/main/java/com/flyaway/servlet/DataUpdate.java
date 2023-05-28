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

public class DataUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STATUS = "RESERVED";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataUpdate() {
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




		FlightsDetails flight = (FlightsDetails) httpsession.getAttribute("flight");


		out.println("<html><body>");

		out.println(httpsession.getAttribute("flight"));

		SessionFactory factory = HibernateUtil.getSessionFactory();

		//open a connection to DB
		Session session = factory.openSession();

		//out.println(flightId);
		out.println("<br>Before Update "+flight.getFreeSeats());

		
		
		
		Transaction tx = null;
		try {
			flight.setFreeSeats(flight.getFreeSeats()-1);
			tx = session.beginTransaction();
			session.merge(flight);
			//session.save(updatedFlight);
			tx.commit();
		
		//session.update(flight);



		httpsession.setAttribute("flight", flight);

		out.println("<br>After Update "+flight.getFreeSeats());
		} catch (Exception e)
		{
			tx.rollback();
			
		} finally {
		
		session.close();

		out.println("<br><br><a href = booking.jsp>Back Home</a>");

		out.println("</body></html>");	}

		//response.sendRedirect("booking.jsp");




	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	}

}
