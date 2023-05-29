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
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.flyaway.entities.AirportsDetails;
import com.flyaway.entities.FlightsDetails;
import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class FindAirportCode
 */
public class FindAirportCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAirportCode() {
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
		out.println("<html><body>");
		
		String originCity = request.getParameter("origincity");//"ANC";
		String destinationCity = request.getParameter("destinationcity");//"SEA";
		
		//open a connection to DB
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		out.println("<br>Origin City is "+originCity);
		out.println("<br>Destination City is "+destinationCity);
		
		out.println("<br><br><br>Departure Airports");
		List<AirportsDetails> airports1 = getAirports(originCity, session);
		
		for(AirportsDetails airport : airports1) {
		out.println(" <br>"+originCity+" matches with "+airport.getCity()+" with airport code "+airport.getIataCode());
		}
		
		out.println("<br><br><br>Destination Airports");
		
		List<AirportsDetails> airports2 = getAirports(destinationCity, session);
		for(AirportsDetails airport : airports2) {
		out.println(" <br>"+destinationCity+" matches with "+airport.getCity()+" with airport code "+airport.getIataCode());
		}
		
		HttpSession httpsession = request.getSession(false);
		
		httpsession.setAttribute("origin", originCity);
		httpsession.setAttribute("destination", destinationCity);
		httpsession.setAttribute("origins", airports1);
		httpsession.setAttribute("destinations", airports2);
				
		session.close();
		out.println("</body></html>");
		response.sendRedirect("selecting-airport.jsp");
				
		
	}
	
	public static List<AirportsDetails> getAirports(String city, Session session){
		
		
		Criteria cr = session.createCriteria(AirportsDetails.class);
		cr.add(Restrictions.like("city", city, MatchMode.START));
		
		
		List<AirportsDetails> airports = cr.list();

		return airports;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
