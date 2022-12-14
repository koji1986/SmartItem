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
				List<Sales> salesOderAdList;
				List<Cost> costList;
				List<Sales> adList;

				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				Date salesDay = sdfDate.parse(request.getParameter("sales_day"));
				salesList = salesDao.findByDate(salesDay);
				costList = costDao.findByCostDate(salesDay);
				adList = salesDao.findByDateAd(salesDay);
				salesOderAdList = salesDao.findByDateOderAd(salesDay);
				int totalSales = 0;
				int totalSalary = 0;
				int totalCashCost = 0;
				for (Sales s : salesList) {
					if(s.getSalesAmount()==null) {
						
					}else {
					totalSales += s.getSalesAmount();
					totalSalary += s.getSalesSalary();
					totalCashCost += s.getCashCost();
					}
					// TODO広告のList作ったけど、やりかたわからない。
					/*
					 * List<Sales> dateAdList; Integer AdId =
					 * Integer.parseInt(request.getParameter("ad_id")); dateAdList
					 * =salesDao.findByDateAd(salesDay,AdId );
					 */

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
				int totalFree = 0;
				int totalNetNomination = 0;
				int totalNomination = 0;
				for (Sales i : salesList) {
					if (i.getSalesNomination().equals("フリー")) {
						totalFree++;
					} else if (i.getSalesNomination().equals("NET指名")) {
						totalNetNomination++;
					} else if (i.getSalesNomination().equals("本指名")) {
						totalNomination++;
					} else {
					}
				}

				// TODO ADのMAP作ったけど、やり方わからない。
				/*
				 * Map<String, Integer> salesMap = new HashMap<>();
				 * System.out.println(salesMap); for (Sales s : salesList) {
				 * System.out.println(s.getAdName()); System.out.println((Integer)
				 * salesMap.get(s.getAdName())); salesMap.put(s.getAdName(),
				 * salesMap.get(s.getAdName()) + 1); }
				 */

				request.setAttribute("totalFree", totalFree);
				request.setAttribute("totalNetNomination", totalNetNomination);
				request.setAttribute("totalNomination", totalNomination);

				request.setAttribute("totalNewMember", totalNewMember);
				request.setAttribute("totalMember", totalMember);

				request.setAttribute("totalCredit", totalCredit);

				request.setAttribute("salesList", salesList);
				request.setAttribute("adList", adList);
				request.setAttribute("salesOderAdList", salesOderAdList);
				request.setAttribute("date", salesDay);

			} else {

				SalesDao salesDao = DaoFactory.createSalesDao();
				CostDao costDao = DaoFactory.createCostDao();
				List<Sales> salesList;
				List<Sales> salesOderAdList;
				List<Cost> costList;
				List<Sales> adList;
				Date date = new Date();
				salesList = salesDao.findByDate(date);
				costList = costDao.findByCostDate(date);
				adList = salesDao.findByDateAd(date);
				salesOderAdList = salesDao.findByDateOderAd(date);

				int totalSales = 0;
				int totalSalary = 0;
				int totalCashCost = 0;
				for (Sales s : salesList) {
					if(s.getSalesAmount()==null) {}
					else {
					totalSales += s.getSalesAmount();
					totalSalary += s.getSalesSalary();
					totalCashCost += s.getCashCost();
					}
					// TODO広告のList作ったけど、やりかたわからない。
					/*
					 * List<Sales> dateAdList; Integer AdId =
					 * Integer.parseInt(request.getParameter("ad_id")); dateAdList
					 * =salesDao.findByDateAd(salesDay,AdId );
					 */

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
					if (s.getSalesPayment()==null) {
						
					} else if(s.getSalesPayment().equals("クレジットカード")) {
						totalCredit += s.getSalesAmount();
					}else {
				}}

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
				int totalFree = 0;
				int totalNetNomination = 0;
				int totalNomination = 0;
				for (Sales i : salesList) {
					if (i.getSalesNomination().equals("フリー")) {
						totalFree++;
					} else if (i.getSalesNomination().equals("NET指名")) {
						totalNetNomination++;
					} else if (i.getSalesNomination().equals("本指名")) {
						totalNomination++;
					} else {
					}
				}

				// TODO ADのMAP作ったけど、やり方わからない。
				/*
				 * Map<String, Integer> salesMap = new HashMap<>();
				 * System.out.println(salesMap); for (Sales s : salesList) {
				 * System.out.println(s.getAdName()); System.out.println((Integer)
				 * salesMap.get(s.getAdName())); salesMap.put(s.getAdName(),
				 * salesMap.get(s.getAdName()) + 1); }
				 */

				request.setAttribute("totalFree", totalFree);
				request.setAttribute("totalNetNomination", totalNetNomination);
				request.setAttribute("totalNomination", totalNomination);

				request.setAttribute("totalNewMember", totalNewMember);
				request.setAttribute("totalMember", totalMember);

				request.setAttribute("totalCredit", totalCredit);

				request.setAttribute("salesList", salesList);
				request.setAttribute("adList", adList);
				request.setAttribute("salesOderAdList", salesOderAdList);
				request.setAttribute("date", date);
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
