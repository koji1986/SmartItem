package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CashDao;
import dao.DaoFactory;
import dao.SalesDao;
import domain.Cash;
import domain.Sales;

/**
 * Servlet implementation class AdminCashServlet
 */
@WebServlet("/admin/cash")
public class AdminCashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCashServlet() {
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

			CashDao cashDao = DaoFactory.createCashDao();
			SalesDao salesDao = DaoFactory.createSalesDao();
			
			List<Cash> cashList;

			// Getパラメータの日付を取得
			if (request.getParameter("cash_day") != null) {

				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				Date cashDay = sdfDate.parse(request.getParameter("cash_day"));

				cashList = cashDao.findByDate(cashDay);
				
			
				
			}
			else {
				cashList = cashDao.findAll();

				List<Sales> salesList = salesDao.findAll();

				request.setAttribute("salesList", salesList);
			}
			
			request.setAttribute("cashList", cashList);
			request.getRequestDispatcher("/WEB-INF/view/admin/cash.jsp").forward(request, response);

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
				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				Date cashDate = sdfDate.parse(request.getParameter("cash_date"));

				Integer cashChange = Integer.parseInt(request.getParameter("cash_change"));
				Integer staffId = Integer.parseInt(request.getParameter("staff_id"));
				Integer cashCost = Integer.parseInt(request.getParameter("cash_cost"));

				Integer cashId = Integer.parseInt(request.getParameter("id"));
				Cash cash = new Cash();
				cash.setCashDate(cashDate);
				cash.setCashChange(cashChange);
				cash.setStaffId(staffId);
				cash.setCashCost(cashCost);

				cash.setId(cashId);

				CashDao cashDao = DaoFactory.createCashDao();
				cashDao.update(cash);
				response.sendRedirect("cash");
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else {
			// 削除
		}

	}
}
