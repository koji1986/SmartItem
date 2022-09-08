package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

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
			boolean isError = false; 
			
		String loginName =request.getParameter("login_name");
		
		if (loginName.isBlank()) {
			 // エラーメッセージの作成
			 request.setAttribute("nameError", "名前が未入力です。");
			 isError = true; // 入力に不備ありと判定
			 } 
		
		String loginPhoneNumber =request.getParameter("login_phone_number");
		
		if (loginPhoneNumber.isBlank()) {
			 // エラーメッセージの作成
			 request.setAttribute("loginPhoneNumberError", "電話番号が未入力です。");
			 isError = true; // 入力に不備ありと判定
			 } 
		
		String loginEmail =request.getParameter("login_email");
		if (loginEmail.isBlank()) {
			 // エラーメッセージの作成
			 request.setAttribute("loginEmailError", "メールアドレスが未入力です。");
			 isError = true; // 入力に不備ありと判定
			 } 
		String loginId =request.getParameter("login_id");
		if (loginId.isBlank()) {
			 // エラーメッセージの作成
			 request.setAttribute("loginIdError", "ログインIDが未入力です。");
			 isError = true; // 入力に不備ありと判定
			 } 
		String loginPass =request.getParameter("login_pass");
		if (loginPass.isBlank()) {
			 // エラーメッセージの作成
			 request.setAttribute("loginPassError", "ログインパスワードが未入力です。");
			 isError = true; // 入力に不備ありと判定
			 } 
		String loginPass2 =request.getParameter("login_pass2");
		
		
		if (!(loginPass.equals(loginPass2))) {
			 // エラーメッセージの作成
			 request.setAttribute("loginPass2Error", "確認用のパスワードが違います。");
			 isError = true; // 入力に不備ありと判定
			 } 
		
		String hashed = BCrypt.hashpw
				(loginPass, BCrypt.gensalt());
		Admins admins = new Admins();
		admins.setLoginName(loginName);
		admins.setLoginPhoneNumber(loginPhoneNumber);
		admins.setLoginEmail(loginEmail);
		admins.setLoginId(loginId);
		admins.setLoginPass(hashed);
		
		if (isError == true) {
			 request.getRequestDispatcher("/WEB-INF/view/admin/accountCreate.jsp")
			 .forward(request, response);
			 return;
			 } 
		
		AdminsDao adminsDao = DaoFactory.createAdminsDao();
			adminsDao.insert(admins);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		response.sendRedirect("login");
		
		
		
		
	}

}
