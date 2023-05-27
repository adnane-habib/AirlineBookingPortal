package com.flyaway.servlet;
import com.flyaway.entities.FlightsDetails;

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

import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class FlightsList
 */
public class FlightsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		


		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		
		HttpSession httpsession = request.getSession(false);//false = do not create new session
		
		if(httpsession==null) {
			out.println("HTTP session not found");
			response.sendRedirect("index.jsp");
			
		} else {
		
		
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//open a connection to DB
		Session session = factory.openSession();
		
		Criteria cr = session.createCriteria(FlightsDetails.class);
		

		Long id = Long.parseLong(request.getParameter("id"));//2;		
		
		
		
		cr.add(Restrictions.eq("id", id));

		
		// Hibernate commands to get all the product from the DB
		//out.println(origin+" "+destination+" "+month+" "+day);

		FlightsDetails flight = (FlightsDetails) cr.uniqueResult();
		
		out.println(flight.toString());
		
		request.getSession().setAttribute("flight", flight);
		

		
		response.sendRedirect("booking.jsp");
		
		session.close();
		
		out.println("<br><br><a href = booking.jsp>Back Home</a>");
		
		out.println("</body></html>");	
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	}


