package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import dao.DaoFactory;
import dao.SalesDao;
import domain.Cost;
import domain.Sales;

/**
 * Servlet implementation class AdminReportAServlet
 */
@WebServlet("/admin/reportA")
public class AdminReportAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminReportAServlet() {
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
			if (request.getParameter("sales_day") != null) {
				SalesDao salesDao = DaoFactory.createSalesDao();
				CostDao costDao = DaoFactory.createCostDao();
				List<Sales> salesList;
				List<Cost> costList;

				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				Date salesDay = sdfDate.parse(request.getParameter("sales_day"));
				salesList = salesDao.findByDate(salesDay);
				costList = costDao.findByCostDate(salesDay);
				int totalSales = 0;
				int totalSalary = 0;
				int totalCashCost = 0;
				for (Sales s : salesList) {
					totalSales += s.getSalesAmount();
					totalSalary += s.getSalesSalary();
					totalCashCost += s.getCashCost();
				}
				request.setAttribute("totalSales", totalSales);
				request.setAttribute("totalSalary", totalSalary);
				request.setAttribute("totalCashCost", totalCashCost);

				int totalCost = 0;
				for (Cost c : costList) {
					totalCost += c.getCostFee();
				}

				request.setAttribute("totalCost", totalCost);

				int totalCredit = 0;
				for (Sales s : salesList) {
					if (s.getSalesPayment().equals("クレジットカード")) {
						totalCredit += s.getSalesAmount();
					} else {
					}
				}

				int totalNewMember = 0;
				int totalMember = 0;
				for (Sales i : salesList) {
					if (i.getCustomerCategolyId() == 1) {
						totalNewMember++;
					} else if (i.getCustomerId() == 2) {
						totalMember++;
					} else {
					}
				}
				int totalFree =0;
				int totalNetNomination = 0;
				int totalNomination = 0;
				for (Sales i : salesList) {
					if (i.getSalesNomination().equals("フリー")) {
						totalFree++;
					} else if (i.getSalesNomination().equals("NET指名")) {
						totalNetNomination++;
					} else if (i.getSalesNomination().equals("本指名")) {
						totalNomination++;
					}else {}
					}
				Map<String, Integer> salesMap = new HashMap<>();
				System.out.println(salesMap);
				for(Sales s : salesList) {
					System.out.println(s.getAdName());
					System.out.println((Integer)salesMap.get(s.getAdName()));
					salesMap.put(s.getAdName(), salesMap.get(s.getAdName())+1);
					}
				
				
			
				
				
				request.setAttribute("salesAdList", salesAdList);
				
				
				
				
				request.setAttribute("totalFree", totalFree);
				request.setAttribute("totalNetNomination", totalNetNomination);
				request.setAttribute("totalNomination", totalNomination);

				request.setAttribute("totalNewMember", totalNewMember);
				request.setAttribute("totalMember", totalMember);

				request.setAttribute("totalCredit", totalCredit);

				request.setAttribute("salesList", salesList);

			} else {
			}

			request.getRequestDispatcher("/WEB-INF/view/admin/reportA.jsp").forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
