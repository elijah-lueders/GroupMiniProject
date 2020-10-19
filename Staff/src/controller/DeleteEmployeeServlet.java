package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/deleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteEmployeeServlet() {
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

		EmployeeHelper eh = new EmployeeHelper();

		String path = "/viewEmployeeServlet";

		String errMsg = "";

		try {
			Integer tempId = Integer.parseInt(request.getParameter("idToDelete"));
			Employee empToDelete = eh.findEmployeeById(tempId);
			eh.deleteEmployee(empToDelete);
		} catch (Exception e) {
			errMsg = "select a valid row to delete";
		}

		request.setAttribute("errMsg", errMsg);
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
