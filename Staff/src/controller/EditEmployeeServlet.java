package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/editEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
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
		
		String action = request.getParameter("action");
		
		String path = "/viewEmployeeServlet";
		
		String errMsg = "";
		
			try {
				Integer tempId = Integer.parseInt(request.getParameter("idToEdit"));
				Employee empToEdit = eh.findEmployeeById(tempId);
				request.setAttribute("empToEdit", empToEdit);
				path = "/edit-employee.jsp";
			} catch (NumberFormatException e) {
				errMsg = "PLEASE MAKE A SELECTION FIRST";
			}
			
		request.setAttribute("errMsg", errMsg);
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
