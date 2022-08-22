package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.SalesDao;
import domain.Sales;

/**
 * Servlet implementation class AdminSalesDeleteServlet
 */
@WebServlet("/admin/sales/delete")
public class AdminSalesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSalesDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get パラメータの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		try {
			// 削除する会員データの取得
			SalesDao salesDao = DaoFactory.createSalesDao();
			Sales sales = salesDao.findById(id);
			// 削除ページの表示
			request.setAttribute("sales", sales);
			request.getRequestDispatcher("/WEB-INF/view/admin/sales/delete.jsp").forward(request, response);
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
		// Get パラメータの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		// 削除メソッドの引数用に Member オブジェクトを作成
		Sales sales = new Sales();
		sales.setId(id);
		try {
			// データの削除
			SalesDao salesDao = DaoFactory.createSalesDao();
			salesDao.delete(sales);
			// 削除完了ページの表示
			response.sendRedirect("../sales");
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
