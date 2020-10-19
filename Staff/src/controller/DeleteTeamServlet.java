package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class DeleteTeamServlet
 */
@WebServlet("/deleteTeamServlet")
public class DeleteTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTeamServlet() {
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

		String path = "/viewTeamServlet";

		String errMsg = "";

		try {
			Integer tempId = Integer.parseInt(request.getParameter("idToDelete"));
			Team teamToDelete = th.findTeamById(tempId);
			System.out.println();
			th.deleteTeam(teamToDelete);
		} catch (Exception e) {
			errMsg = "cant delete team that has employees associtated";
		}

		request.setAttribute("errMsg", errMsg);
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
