package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CashDao;
import dao.DaoFactory;
import domain.Cash;

/**
 * Servlet implementation class AdminCashUpdateServlet
 */
@WebServlet("/admin/cash/update")
public class AdminCashUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCashUpdateServlet() {
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
			Integer id = Integer.parseInt(request.getParameter("id"));

			CashDao cashDao = DaoFactory.createCashDao();
			Cash cash = cashDao.findById(id);
			request.setAttribute("cashChange", cash.getCashChange());
			request.setAttribute("cashCost", cash.getCashCost());
			request.getRequestDispatcher("/WEB-INF/view/admin/cash/update.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer cashChange = Integer.parseInt(request.getParameter("cash_change"));
			Integer cashCost = Integer.parseInt(request.getParameter("cash_cost"));
			Integer cashId = Integer.parseInt(request.getParameter("id"));

			Cash cash = new Cash();
			cash.setCashChange(cashChange);
			cash.setCashCost(cashCost);
			cash.setId(cashId);

			CashDao cashDao = DaoFactory.createCashDao();
			cashDao.update(cash);

			response.sendRedirect("../cash");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
