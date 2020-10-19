package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class NewTeamServlet
 */
@WebServlet("/newTeamServlet")
public class NewTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewTeamServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeamHelper th = new TeamHelper();
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		
		String errMsg = "";
		String path = "/viewTeamServlet";
		
		if (name.isEmpty()||location.isEmpty()) {
			errMsg = "ALL FIELDS ARE REQUIRED";
			path = "/new-team.jsp";
		}else {
			Team teamToAdd = new Team(name, location);
			th.addTeam(teamToAdd);
		}
		request.setAttribute("errMsg", errMsg);
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
