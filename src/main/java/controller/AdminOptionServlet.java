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
import dao.ShopInfDao;
import domain.Option;
import domain.ShopInf;

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
			ShopInfDao shopInfDao = DaoFactory.createShopInfDao();
			List<Option> optionList = optionDao.findAll();
			List<ShopInf> shopInfList = shopInfDao.findAll();
			request.setAttribute("optionList", optionList);
			request.setAttribute("shopInfList", shopInfList);

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
		try {
			Option option = new Option();
			OptionDao optionDao = DaoFactory.createOptionDao();
			if (request.getParameter("update") != null) {
				// 更新

				Integer shopInfId = Integer.parseInt(request.getParameter("shopInf_id"));
				String optionName = request.getParameter("option_name");

				Integer optionFee = Integer.parseInt(request.getParameter("option_fee"));

				Integer optionRow = Integer.parseInt(request.getParameter("option_row"));

				Integer optionId = Integer.parseInt(request.getParameter("id"));
				
				option.setShopInfId(shopInfId);
				option.setOptionName(optionName);
				option.setOptionFee(optionFee);

				option.setOptionRow(optionRow);
				option.setId(optionId);

				
				optionDao.update(option);
				response.sendRedirect("option");
			} else if (request.getParameter("new") != null){
				
				
				
				Integer shopInfId = Integer.parseInt(request.getParameter("shopInf_id"));
				String optionName = request.getParameter("option_name");
				Integer optionFee = Integer.parseInt(request.getParameter("option_fee"));
			
				Integer optionRow = Integer.parseInt(request.getParameter("option_row"));

				option.setShopInfId(shopInfId);
				option.setOptionName(optionName);
				option.setOptionFee(optionFee);
			
				option.setOptionRow(optionRow);

				optionDao.insert(option);
				response.sendRedirect("option");
			}else {
				// 削除
				Integer optionId = Integer.parseInt(request.getParameter("id"));

				option.setId(optionId);
				optionDao.delete(option);
				response.sendRedirect("option");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
