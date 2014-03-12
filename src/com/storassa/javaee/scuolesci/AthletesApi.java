package com.storassa.javaee.scuolesci;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Servlet implementation class AthletesApi
 */
@WebServlet("/athletes")
public class AthletesApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AthleteEJB athleteEjb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AthletesApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Athlete> listAthlete = new ArrayList<Athlete>();

		// get all the athletes in the DB
		listAthlete = athleteEjb.findAthlete();

		// create the JSON file
		JSONArray array = new JSONArray(listAthlete);
		response.getWriter().append(array.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
