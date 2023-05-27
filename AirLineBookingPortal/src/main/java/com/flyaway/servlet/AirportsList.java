package com.flyaway.servlet;
import com.flyaway.entities.AirportsDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.flyaway.util.HibernateUtil;

/**
 * Servlet implementation class AirportsList
 */
public class AirportsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AirportsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//open a connection to DB
		Session session = factory.openSession();
		
		// Hibernate commands to get all the product from the DB
		out.println("PRODUCT LIST<br><br>");
		out.println("<table border=1><th>ID<th>IATA CODE<th>CITY<th>AIRPORT NAME<th>COUNTRY CODE</th>");
		List<AirportsDetails> airportsList = session.createQuery("from AirportsDetails").list();
		for(AirportsDetails airport : airportsList) {
			out.println(
					"<tr><td>"+airport.getId()+
					"<td>"+airport.getIataCode()+
					"<td>"+airport.getCity()+
					"<td>"+airport.getAirportName()+
					"<td>"+airport.getCountryCode()+
					"</tr>");
		}
		
		
		session.close();
		out.println("</table><br><br>");
		out.println("<a href = index.jsp>Back Home</a>");
		
		out.println("</body></html>");	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
