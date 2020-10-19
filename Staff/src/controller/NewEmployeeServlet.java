package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

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
		response.getWriter().append("NewEmployeeServlet Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeHelper eh = new EmployeeHelper();
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
			eh.addEmployee(empToAdd);
		}
		request.setAttribute("errMsg", errMsg);
		System.out.println();
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
