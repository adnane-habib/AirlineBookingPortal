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
public class FlightsListCriteria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightsListCriteria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		 * PrintWriter out = response.getWriter();
		 * 
		 * HttpSession httpsession = request.getSession(false);//false = do not create
		 * new session
		 * 
		 * if(httpsession==null) { out.println("HTTP session not found");
		 * response.sendRedirect("error.html");
		 * 
		 * } else {
		 * 
		 * 
		 * out.println("<html><body>"); SessionFactory factory =
		 * HibernateUtil.getSessionFactory();
		 * 
		 * //open a connection to DB Session session = factory.openSession();
		 * 
		 * Criteria cr = session.createCriteria(FlightsDetails.class);
		 * 
		 * 
		 * String origin = (String) httpsession.getAttribute("origin");//"ANC"; String
		 * destination = (String) httpsession.getAttribute("destination");//"SEA";
		 * Integer month = (Integer) httpsession.getAttribute("month");//2; Integer day
		 * = (Integer) httpsession.getAttribute("day");//21;
		 * 
		 * cr.add(Restrictions.eq("originAirport", origin));
		 * cr.add(Restrictions.eq("destinationAirport", destination));
		 * cr.add(Restrictions.eq("month", month)); cr.add(Restrictions.eq("day", day));
		 * 
		 * // Hibernate commands to get all the product from the DB
		 * out.println("PRODUCT LIST<br><br>"); out.
		 * println("<table border=1><th>ID<th>Departure From<th>Flying to<th>DATE<th>Price (USD) </th>"
		 * ); List<FlightsDetails> flightsList = cr.list(); for(FlightsDetails flight :
		 * flightsList) { out.println( "<tr><td>"+flight.getId()+
		 * "<td>"+flight.getOriginAirport()+ "<td>"+flight.getDestinationAirport()+
		 * "<td>"+flight.getMonth()+"//"+flight.getDay()+
		 * "<td>"+String.format("$ %.2f",flight.getTicketPrice())+ "</tr>"); }
		 * request.setAttribute("result", flightsList);
		 * 
		 * session.close(); out.println("</table><br><br>");
		 * out.println("<a href = index.jsp>Back Home</a>");
		 * 
		 * out.println("</body></html>"); }
		 */
		
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
		
		
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//open a connection to DB
		Session session = factory.openSession();
		
		Criteria cr = session.createCriteria(FlightsDetails.class);
		
		//Get Attribute if data is passed from session
		/*
		String origin = (String) httpsession.getAttribute("origin");//"ANC";
		String destination = (String) httpsession.getAttribute("destination");//"SEA";
		Integer month = (Integer) httpsession.getAttribute("month");//2;
		Integer day = (Integer) httpsession.getAttribute("day");//21;
		*/
		//Get Paramater if data is collected from get() or post() 
		String origin = request.getParameter("origin");//"ANC";
		String destination = request.getParameter("destination");//"SEA";
		Integer month = Integer.parseInt(request.getParameter("month"));//2;
		Integer day = Integer.parseInt(request.getParameter("day"));//21;
		
		
		
		
		
		
		cr.add(Restrictions.eq("originAirport", origin));
		cr.add(Restrictions.eq("destinationAirport", destination));
		cr.add(Restrictions.eq("month", month));
		cr.add(Restrictions.eq("day", day));
		
		// Hibernate commands to get all the product from the DB
		//out.println(origin+" "+destination+" "+month+" "+day);
		out.println("LIST of FLIGHTS<br><br>");
		out.println("<table border=1><th>ID<th>Departure From<th>Flying to<th>DATE<th>Price (USD)<th> Booking URL </th>");
		List<FlightsDetails> flightsList = cr.list();
		for(FlightsDetails flight : flightsList) {
			out.println(
					"<tr><td>"+flight.getId()+
					"<td>"+flight.getOriginAirport()+
					"<td>"+flight.getDestinationAirport()+
					"<td>"+flight.getMonth()+"//"+flight.getDay()+
					"<td>"+String.format("$ %.2f",flight.getTicketPrice())+
					"<td><a href=\"FlightsList?id="+flight.getId()+"\"> book here </a>"+
					"</tr>");
		}
		httpsession.setAttribute("result", flightsList);
		
		session.close();
		out.println("</table><br><br>");
		out.println("<a href = index.jsp>Back Home</a>");
		
		out.println("</body></html>");	
	}
	}

}
