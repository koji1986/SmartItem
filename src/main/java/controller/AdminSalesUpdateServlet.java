package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.SalesDao;
import domain.Sales;

/**
 * Servlet implementation class AdminSalesUpdateServlet
 */
@WebServlet("/admin/sales/update")
public class AdminSalesUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSalesUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		SalesDao salesDao = DaoFactory.createSalesDao();

		try {
			// 店舗の選択肢
			request.setAttribute("shopInfList", salesDao.findAllShopInf());
			request.setAttribute("customerCategolyList", salesDao.findAllCustomerCategoly());
			request.setAttribute("customerList", salesDao.findAllCustomer());
			request.setAttribute("picList", salesDao.findAllPic());
			request.setAttribute("courseList", salesDao.findAllCourse());
			request.setAttribute("optionList", salesDao.findAllOption());
			request.setAttribute("staffList", salesDao.findAllStaff());
			request.setAttribute("adList", salesDao.findAllAd());
			request.setAttribute("discountList", salesDao.findAllDiscount());
			Sales sales = salesDao.findById(id);

			request.setAttribute("salesDate", sales.getSalesDate());
			request.setAttribute("salesTime", sales.getSalesTime());
			request.setAttribute("shopInfId", sales.getShopInfId());
			request.setAttribute("customerCategolyId", sales.getCustomerCategolyId());
			request.setAttribute("customerId", sales.getCustomerId());
			request.setAttribute("customerName", sales.getCustomerName());
			request.setAttribute("picId", sales.getPicId());
			request.setAttribute("salesNomination", sales.getSalesNomination());
			request.setAttribute("salesPayment", sales.getSalesPayment());
			request.setAttribute("courseId", sales.getCourseId());
			request.setAttribute("optionId", sales.getOptionId());
			request.setAttribute("staffId", sales.getStaffId());
			request.setAttribute("salesCarfare", sales.getSalesCarfare());
			request.setAttribute("salesSalary", sales.getSalesSalary());
			request.setAttribute("salesCost", sales.getSalesCost());
			request.setAttribute("adId", sales.getAdId());
			request.setAttribute("discountId", sales.getDiscountId());
			request.setAttribute("salesDiscountFee", sales.getSalesDiscountFee());

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/view/admin/sales/update.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");

			Date salesTime = sdfTime.parse(request.getParameter("sales_time"));
			Date salesDate = sdfDate.parse(request.getParameter("sales_date"));

			Integer shopInfId = Integer.parseInt(request.getParameter("shopInf_id"));
			Integer customerCategolyId = Integer.parseInt(request.getParameter("customerCategoly_id"));
			Integer customerId = Integer.parseInt(request.getParameter("customer_id"));
			Integer picId = Integer.parseInt(request.getParameter("pic_id"));
			String salesNomination = request.getParameter("sales_nomination");
			String salesPayment = request.getParameter("sales_payment");
			Integer courseId = Integer.parseInt(request.getParameter("course_id"));
			Integer optionId = Integer.parseInt(request.getParameter("option_id"));
			Integer staffId = Integer.parseInt(request.getParameter("staff_id"));
			Integer salesCarfare = Integer.parseInt(request.getParameter("sales_carfare"));
			Integer salesSalary = Integer.parseInt(request.getParameter("sales_salary"));
			Integer salesCost = Integer.parseInt(request.getParameter("sales_cost"));
			Integer adId = Integer.parseInt(request.getParameter("ad_id"));
			Integer discountId = Integer.parseInt(request.getParameter("discount_id"));
			Integer salesDiscountFee = Integer.parseInt(request.getParameter("sales_discount_fee"));
			Integer salesId = Integer.parseInt(request.getParameter("id"));

			Sales sales = new Sales();
			sales.setSalesDate(salesDate);
			sales.setSalesTime(salesTime);
			sales.setShopInfId(shopInfId);
			sales.setCustomerCategolyId(customerCategolyId);
			sales.setCustomerId(customerId);
			sales.setPicId(picId);
			sales.setSalesNomination(salesNomination);
			sales.setSalesPayment(salesPayment);
			sales.setCourseId(courseId);
			sales.setOptionId(optionId);
			sales.setStaffId(staffId);
			sales.setSalesCarfare(salesCarfare);
			sales.setSalesSalary(salesSalary);
			sales.setSalesCost(salesCost);
			sales.setAdId(adId);
			sales.setDiscountId(discountId);
			sales.setSalesDiscountFee(salesDiscountFee);
			sales.setId(salesId);

			SalesDao salesDao = DaoFactory.createSalesDao();
			salesDao.update(sales);
			response.sendRedirect("../sales");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
