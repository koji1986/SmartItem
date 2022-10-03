package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dao.DaoFactory;
import domain.Customer;

/**
 * Servlet implementation class AdminCustomerServlet
 */
@WebServlet("/admin/customer")
public class AdminCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCustomerServlet() {
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

			CustomerDao customerDao = DaoFactory.createCustomerDao();
			List<Customer> customerList = customerDao.findAll();
			request.setAttribute("customerList", customerList);
			request.getRequestDispatcher("/WEB-INF/view/admin/customer.jsp").forward(request, response);

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
		CustomerDao customerDao = DaoFactory.createCustomerDao();
		if (request.getParameter("nameTelMember")==null) {
			if (request.getParameter("delete").isBlank()) {
			} else {
				// Get パラメータの取得
				String strId = request.getParameter("id");
				Integer id = Integer.parseInt(strId);
				// 削除メソッドの引数用に Member オブジェクトを作成
				Customer customer = new Customer();
				customer.setId(id);
				try {
					// データの削除

					customerDao.delete(customer);
					response.sendRedirect("customer");

				} catch (Exception e) {
					throw new ServletException(e);
				}
			}
		}

		else {
			try {
				String nameTelMember = request.getParameter("nameTelMember");
				List<Customer> customerList = customerDao.findByNammeTelMember(nameTelMember);
				request.setAttribute("customerList", customerList);
				request.getRequestDispatcher("/WEB-INF/view/admin/customer.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

	}

}
