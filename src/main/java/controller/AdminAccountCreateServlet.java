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
 * Servlet implementation class AdminAccountCreateServlet
 */
@WebServlet("/admin/accountCreate")
public class AdminAccountCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAccountCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/accountCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String loginName =request.getParameter("login_name");
		String loginPhoneNumber =request.getParameter("login_phone_number");
		String loginEmail =request.getParameter("login_email");
		String loginId =request.getParameter("login_id");
		String loginPass =request.getParameter("login_pass");
		
		Admins admins = new Admins();
		admins.setLoginName(loginName);
		admins.setLoginPhoneNumber(loginPhoneNumber);
		admins.setLoginEmail(loginEmail);
		admins.setLoginId(loginId);
		admins.setLoginPass(loginPass);
		
		AdminsDao adminsDao = DaoFactory.createAdminsDao();
			adminsDao.insert(admins);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		response.sendRedirect("login");
		
		
		
		
	}

}
