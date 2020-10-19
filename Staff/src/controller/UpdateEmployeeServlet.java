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
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/updateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeHelper eh = new EmployeeHelper();
		Integer id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String title = request.getParameter("title");
		LocalDate startDate = LocalDate.parse(request.getParameter("startdate"));

		String path = "/viewEmployeeServlet";
		String errMsg = "";
		
		Employee empToEdit = eh.findEmployeeById(id);

		if (firstName.isEmpty() || lastName.isEmpty()) {
			request.setAttribute("empToEdit", empToEdit);
			path = "/edit-employee.jsp";
			errMsg = "please enter a first AND last name";
		} else {
			empToEdit.setFirstName(firstName);
			empToEdit.setLastName(lastName);
			empToEdit.setTitle(title);
			empToEdit.setStartDate(startDate);
			eh.editEmployee(empToEdit);
		}
		request.setAttribute("errMsg", errMsg);
		System.out.println();
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
