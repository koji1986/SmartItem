package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.OptionDao;
import domain.Option;

/**
 * Servlet implementation class AdminOptionServlet
 */
@WebServlet("/admin/option")
public class AdminOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminOptionServlet() {
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
			OptionDao optionDao = DaoFactory.createOptionDao();
			List<Option> optionList = optionDao.findAll();
			request.setAttribute("optionList", optionList);

			request.getRequestDispatcher("/WEB-INF/view/admin/option.jsp").forward(request, response);

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

				Integer shopInfId = Integer.parseInt(request.getParameter("shopInf_id"));
				String optionName = request.getParameter("option_name");

				Integer optionFee = Integer.parseInt(request.getParameter("option_fee"));

				Integer optionRow = Integer.parseInt(request.getParameter("option_row"));

				Integer optionId = Integer.parseInt(request.getParameter("id"));
				Option option = new Option();
				option.setShopInfId(shopInfId);
				option.setOptionName(optionName);
				option.setOptionFee(optionFee);

				option.setOptionRow(optionRow);
				option.setId(optionId);

				OptionDao optionDao = DaoFactory.createOptionDao();
				optionDao.update(option);
				response.sendRedirect("option");
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else {
			// 削除
		}

	}

}
