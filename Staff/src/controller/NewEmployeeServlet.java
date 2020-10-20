package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.Team;

/**
 * Servlet implementation class NewEmployeeServlet
 */
@WebServlet("/newEmployeeServlet")
public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewEmployeeServlet() {
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
		TeamHelper th = new TeamHelper();
		
		List<Team> allTeams = th.getTeamList();
		request.setAttribute("allTeams", allTeams);	
	
		getServletContext().getRequestDispatcher("/new-employee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeHelper eh = new EmployeeHelper();
		TeamHelper th = new TeamHelper();
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String title = request.getParameter("title");
		LocalDate startDate = LocalDate.parse(request.getParameter("startdate"));
		
		String path = "/viewEmployeeServlet";
		String errMsg = "";

		if (firstName.isEmpty() || lastName.isEmpty()) {
			errMsg = "please enter a first AND last name";
			path = "/new-employee.jsp";
		} else {
			Employee empToAdd = new Employee(firstName, lastName, title, startDate);
			if (!request.getParameter("team").isEmpty()) {
				Integer teamId= Integer.parseInt(request.getParameter("team"));
				Team teamToAssign = th.findTeamById(teamId);
				empToAdd.setTeam(teamToAssign);
			}
			eh.addEmployee(empToAdd);
		}
		request.setAttribute("errMsg", errMsg);
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
