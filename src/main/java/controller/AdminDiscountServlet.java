package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.DiscountDao;
import dao.ShopInfDao;
import domain.Discount;
import domain.ShopInf;

/**
 * Servlet implementation class AdminDiscountServlet
 */
@WebServlet("/admin/discount")
public class AdminDiscountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDiscountServlet() {
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
			DiscountDao discountDao = DaoFactory.createDiscountDao();
			ShopInfDao shopInfDao = DaoFactory.createShopInfDao();
			List<Discount> discountList = discountDao.findAll();
			List<ShopInf> shopInfList = shopInfDao.findAll();
			request.setAttribute("discountList", discountList);
			request.setAttribute("shopInfList", shopInfList);
			request.getRequestDispatcher("/WEB-INF/view/admin/discount.jsp").forward(request, response);

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

		try {
			Discount discount = new Discount();
			DiscountDao discountDao = DaoFactory.createDiscountDao();
			if (request.getParameter("update") != null) {
				// 更新

				Integer shopInfId = Integer.parseInt(request.getParameter("shopInf_id"));
				String discountName = request.getParameter("discount_name");

				Integer discountFee = Integer.parseInt(request.getParameter("discount_fee"));

				Integer discountRow = Integer.parseInt(request.getParameter("discount_row"));

				Integer discountId = Integer.parseInt(request.getParameter("id"));

				discount.setShopInfId(shopInfId);
				discount.setDiscountName(discountName);
				discount.setDiscountFee(discountFee);

				discount.setDiscountRow(discountRow);
				discount.setId(discountId);

				discountDao.update(discount);
				response.sendRedirect("discount");
			} else if (request.getParameter("new") != null) {

				Integer shopInfId = Integer.parseInt(request.getParameter("shopInf_id"));
				String discountName = request.getParameter("discount_name");

				Integer discountFee = Integer.parseInt(request.getParameter("discount_fee"));
				Integer discountRow = Integer.parseInt(request.getParameter("discount_row"));

				discount.setShopInfId(shopInfId);
				discount.setDiscountName(discountName);
				discount.setDiscountFee(discountFee);

				discount.setDiscountRow(discountRow);

				discountDao.insert(discount);
				response.sendRedirect("discount");

			}

			else {
				// 削除
				Integer discountId = Integer.parseInt(request.getParameter("id"));

				discount.setId(discountId);

				discountDao.delete(discount);
				response.sendRedirect("discount");

			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
