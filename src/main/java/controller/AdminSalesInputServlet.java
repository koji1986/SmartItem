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
 * Servlet implementation class AdminSalesInputServlet
 */
@WebServlet("/admin/sales/input")
public class AdminSalesInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSalesInputServlet() {
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
			SalesDao salesDao = DaoFactory.createSalesDao();

			request.setAttribute("shopInfList", salesDao.findAllShopInf());
			request.setAttribute("customerCategolyList", salesDao.findAllCustomerCategoly());
			request.setAttribute("customerList", salesDao.findAllCustomer());
			request.setAttribute("picList", salesDao.findAllPic());
			request.setAttribute("courseList", salesDao.findAllCourse());
			request.setAttribute("optionList", salesDao.findAllOption());
			request.setAttribute("staffList", salesDao.findAllStaff());
			request.setAttribute("adList", salesDao.findAllAd());
			request.setAttribute("discountList", salesDao.findAllDiscount());

			request.getRequestDispatcher("/WEB-INF/view/admin/sales/input.jsp").forward(request, response);
		} catch (Exception e) {

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
			Integer salesAmount = Integer.parseInt(request.getParameter("sales_amount"));

			Integer salesCarfare = Integer.parseInt(request.getParameter("sales_carfare"));
			Integer salesSalary = Integer.parseInt(request.getParameter("sales_salary"));
			Integer salesCost = Integer.parseInt(request.getParameter("sales_cost"));
			Integer adId = Integer.parseInt(request.getParameter("ad_id"));
			Integer discountId = Integer.parseInt(request.getParameter("discount_id"));
			Integer salesDiscountFee = Integer.parseInt(request.getParameter("sales_discount_fee"));

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
			sales.setSalesAmount(salesAmount);
			sales.setSalesCarfare(salesCarfare);
			sales.setSalesSalary(salesSalary);
			sales.setSalesCost(salesCost);
			sales.setAdId(adId);
			sales.setDiscountId(discountId);
			sales.setSalesDiscountFee(salesDiscountFee);

			SalesDao salesDao = DaoFactory.createSalesDao();
			salesDao.insert(sales);
			response.sendRedirect("../sales");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
