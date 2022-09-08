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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			boolean isError = false;
			String loginId = request.getParameter("login_id");

			if (loginId.isBlank()) {
				// エラーメッセージの作成
				request.setAttribute("loginIdError", "ログインIDが未入力です。");
				isError = true; // 入力に不備ありと判定
			}

			String loginPass = request.getParameter("login_pass");
			if (loginPass.isBlank()) {
				// エラーメッセージの作成
				request.setAttribute("loginPassError", "ログインパスワードが未入力です。");
				isError = true; // 入力に不備ありと判定
			}

			if (isError == true) {
				request.getRequestDispatcher("/WEB-INF/view/admin/login.jsp").forward(request, response);
				return;
			}

			AdminsDao adminDao = DaoFactory.createAdminsDao();
			Admins admin = adminDao.findByLoginIdAndLoginPass(loginId, loginPass);
			if (admin != null) {
				request.getSession().setAttribute("admin", admin);
				response.sendRedirect("sales");
			} else {
				request.setAttribute("error", "IDかパスワードが違います。");
				request.getRequestDispatcher("/WEB-INF/view/admin/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
