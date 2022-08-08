package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dao.DaoFactory;
import domain.Customer;

/**
 * Servlet implementation class AdminCustomerUpdateServlet
 */
@WebServlet("/admin/customer/update")
public class AdminCustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCustomerUpdateServlet() {
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

		CustomerDao customerDao = DaoFactory.createCustomerDao();
		try {
			Customer customer = customerDao.findById(id);

			request.setAttribute("customerNo", customer.getCustomerNo());
			request.setAttribute("customerName", customer.getCustomerName());
			request.setAttribute("customerKana", customer.getCustomerKana());
			request.setAttribute("customerPhoneNumber1", customer.getCustomerPhoneNumber1());
			request.setAttribute("customerPhoneNumber2", customer.getCustomerPhoneNumber2());
			request.setAttribute("customerPhoneNumber3", customer.getCustomerPhoneNumber3());
			request.setAttribute("customerEmail", customer.getCustomerEmail());
			request.setAttribute("customerAddress1", customer.getCustomerAddress1());
			request.setAttribute("customerAddress2", customer.getCustomerAddress2());
			request.setAttribute("customerCreditNumber", customer.getCustomerCreditNumber());
			request.setAttribute("customerCreditDate", customer.getCustomerCreditDate());
			request.setAttribute("customerCreditCvv", customer.getCustomerCreditCvv());
			request.setAttribute("customerMemo", customer.getCustomerMemo());

			request.getRequestDispatcher("/WEB-INF/view/admin/customer/update.jsp").forward(request, response);
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
			String customerNo = request.getParameter("customer_no");
			String customerName = request.getParameter("customer_name");
			String customerKana = request.getParameter("customer_kana");
			String customerPhoneNumber1 = request.getParameter("customer_phone_number1");
			String customerPhoneNumber2 = request.getParameter("customer_phone_number2");
			String customerPhoneNumber3 = request.getParameter("customer_phone_number3");
			String customerEmail = request.getParameter("customer_email");
			String customerAddress1 = request.getParameter("customer_address1");
			String customerAddress2 = request.getParameter("customer_address2");
			String customerCreditNumber = request.getParameter("customer_credit_number");
			String customerCreditDate = request.getParameter("customer_credit_date");
			String customerCreditCvv = request.getParameter("customer_credit_cvv");
			String customerMemo = request.getParameter("customer_memo");
			Integer customerId = Integer.parseInt(request.getParameter("id"));

			Customer customer = new Customer();
			customer.setCustomerNo(customerNo);
			customer.setCustomerName(customerName);
			customer.setCustomerKana(customerKana);
			customer.setCustomerPhoneNumber1(customerPhoneNumber1);
			customer.setCustomerPhoneNumber2(customerPhoneNumber2);
			customer.setCustomerPhoneNumber3(customerPhoneNumber3);
			customer.setCustomerEmail(customerEmail);
			customer.setCustomerAddress1(customerAddress1);
			customer.setCustomerAddress2(customerAddress2);
			customer.setCustomerCreditNumber(customerCreditNumber);
			customer.setCustomerCreditDate(customerCreditDate);
			customer.setCustomerCreditCvv(customerCreditCvv);
			customer.setCustomerMemo(customerMemo);
			customer.setId(customerId);

			CustomerDao customerDao = DaoFactory.createCustomerDao();
			customerDao.update(customer);
			response.sendRedirect("../customer");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
