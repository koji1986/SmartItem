package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminsDao;
import dao.DaoFactory;
import domain.Admins;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			 String loginId = request.getParameter("loginId");
			 String loginPass = request.getParameter("loginPass");
			 AdminsDao adminDao = DaoFactory.createAdminsDao();
			 Admins admin =
			 adminDao.findByLoginIdAndLoginPass(loginId, loginPass);
			 if (admin != null) {
			 request.getSession().setAttribute("loginId",
			 admin.getLoginId());
			 response.sendRedirect("listMember");
			 } else {
			 request.setAttribute("error", true);
			 request.getRequestDispatcher("/WEB-INF/view/admin/login.jsp")
			 .forward(request, response);
			 }
			 } catch (Exception e) {
			 throw new ServletException(e);
			 } 
		
		
	}

}
