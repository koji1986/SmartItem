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
			Date date;
			List<Cash> cashList;

			// Getパラメータの日付を取得
			if (request.getParameter("cash_day") != null) {

				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				date = sdfDate.parse(request.getParameter("cash_day"));

				cashList = cashDao.findByDate(date);

			} else {
				
				date = new Date();
				cashList = cashDao.findByDate(date);
				
				
				List<Sales> salesList = salesDao.findAll();

				request.setAttribute("salesList", salesList);
			}

			request.setAttribute("cashList", cashList);
			int totalSales = 0;
			int totalSalary = 0;
			int totalChange = 0;
			int totalCost = 0;
			
			for(Cash c : cashList) {
				if(c.getSalaryDone()==1) {
				}
				else {
				totalSales += c.getSalesAmount();
				totalSalary += c.getSalesSalary();
				totalChange += c.getCashChange();
				totalCost += c.getCashCost();
				}
			}
			
			 int totalCash = 100000 + totalSales -totalSalary - totalChange -totalCost;
		
			 
			 request.setAttribute("date", date);
			request.setAttribute("totalCash", totalCash);
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

				Integer cashChange = Integer.parseInt(request.getParameter("cash_change"));

				Integer cashCost = Integer.parseInt(request.getParameter("cash_cost"));

				Integer cashId = Integer.parseInt(request.getParameter("id"));
				Integer salaryDone = Integer.parseInt(request.getParameter("salary_done"));
				Cash cash = new Cash();

				cash.setCashChange(cashChange);

				cash.setCashCost(cashCost);

				cash.setId(cashId);

				cash.setSalaryDone(salaryDone);

				CashDao cashDao = DaoFactory.createCashDao();
				cashDao.update(cash);
				
				
				SalesDao salesDao = DaoFactory.createSalesDao();
				Date date;
				List<Cash> cashList;
				

				// Getパラメータの日付を取得
				if (request.getParameter("cash_day") != null) {

					SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
					date = sdfDate.parse(request.getParameter("cash_day"));

					cashList = cashDao.findByDate(date);

				} else {
					
					date = new Date();
					cashList = cashDao.findByDate(date);
					
					
					List<Sales> salesList = salesDao.findAll();

					request.setAttribute("salesList", salesList);
				}
				
				request.setAttribute("cashList", cashList);
				int totalSales = 0;
				int totalSalary = 0;
				int totalChange = 0;
				int totalCost = 0;
				
				for(Cash c : cashList) {
					if(c.getSalaryDone()==1) {
					}
					else {
					totalSales += c.getSalesAmount();
					totalSalary += c.getSalesSalary();
					totalChange += c.getCashChange();
					totalCost += c.getCashCost();
					}
				}
				
				 int totalCash = 100000 + totalSales -totalSalary - totalChange -totalCost;
			
				 
				 request.setAttribute("date", date);
				request.setAttribute("totalCash", totalCash);
				
				response.sendRedirect("cash?cash_day="+request.getParameter("cash_day"));
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else {
			// 削除
			try {
				Integer cashId = Integer.parseInt(request.getParameter("id"));
				Cash cash = new Cash();
				cash.setId(cashId);
				cash.setCashCost(0);
				cash.setCashChange(0);
				cash.setSalaryDone(1);
				// 削除
				CashDao cashDao = DaoFactory.createCashDao();
				cashDao.update(cash);
				response.sendRedirect("cash");
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}
}
