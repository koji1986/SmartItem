package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import dao.DaoFactory;
import domain.Cost;

/**
 * Servlet implementation class AdminCostAServlet
 */
@WebServlet("/admin/costA")
public class AdminCostAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCostAServlet() {
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

			CostDao costDao = DaoFactory.createCostDao();

			List<Cost> costList = costDao.findAll();

			request.setAttribute("costList", costList);

			request.getRequestDispatcher("/WEB-INF/view/admin/costA.jsp").forward(request, response);
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
		Cost cost = new Cost();
		cost.setId(id);
		try {
			// データの削除
			CostDao costDao = DaoFactory.createCostDao();
			costDao.delete(cost);
			response.sendRedirect("costA");

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
