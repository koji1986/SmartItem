package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.StaffDao;
import domain.Staff;

/**
 * Servlet implementation class AdminStaffServlet
 */
@WebServlet("/admin/staff")
public class AdminStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminStaffServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			StaffDao staffDao = DaoFactory.createStaffDao();
			List<Staff> staffList = staffDao.findAll();
			request.setAttribute("staffList", staffList);

			request.getRequestDispatcher("/WEB-INF/view/admin/staff.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("update") != null) {
			// 更新
			try {

				String staffName = request.getParameter("staff_name");

				Integer staffRow = Integer.parseInt(request.getParameter("staff_row"));

				Integer staffId = Integer.parseInt(request.getParameter("id"));
				Staff staff = new Staff();

				staff.setStaffName(staffName);

				staff.setStaffRow(staffRow);
				staff.setId(staffId);

				StaffDao staffDao = DaoFactory.createStaffDao();
				staffDao.update(staff);
				response.sendRedirect("staff");
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else {
			// 削除
		}

	}
}
