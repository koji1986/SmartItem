package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PicRankDao;
import dao.ShopInfDao;
import domain.PicRank;
import domain.ShopInf;

/**
 * Servlet implementation class AdminPicRankServlet
 */
@WebServlet("/admin/picRank")
public class AdminPicRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminPicRankServlet() {
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
			PicRankDao picRankDao = DaoFactory.createPicRankDao();
			ShopInfDao shopInfDao = DaoFactory.createShopInfDao();

			List<PicRank> picRankList = picRankDao.findAll();
			List<ShopInf> shopInfList = shopInfDao.findAll();
			request.setAttribute("picRankList", picRankList);
			request.setAttribute("shopInfList", shopInfList);
			request.getRequestDispatcher("/WEB-INF/view/admin/picRank.jsp").forward(request, response);

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
			if (request.getParameter("update") != null) {
				// 更新

				Integer shopInfId = Integer.parseInt(request.getParameter("shopInf_id"));
				String picRankName = request.getParameter("picRank_name");

				Integer picRankFee = Integer.parseInt(request.getParameter("picRank_fee"));

				Integer picRankRow = Integer.parseInt(request.getParameter("picRank_row"));

				Integer picRankId = Integer.parseInt(request.getParameter("id"));
				PicRank picRank = new PicRank();
				picRank.setShopInfId(shopInfId);
				picRank.setPicRankName(picRankName);
				picRank.setPicRankFee(picRankFee);
				picRank.setPicRankRow(picRankRow);
				picRank.setId(picRankId);

				PicRankDao picRankDao = DaoFactory.createPicRankDao();
				picRankDao.update(picRank);
				response.sendRedirect("picRank");
			} else {
				// 削除
				Integer picRankId = Integer.parseInt(request.getParameter("id"));
				PicRank picRank = new PicRank();

				picRank.setShopInfId(1);
				picRank.setId(picRankId);
				picRank.setPicRankName(null);
				picRank.setPicRankFee(0);
				picRank.setPicRankRow(0);
				// 削除
				PicRankDao picRankDao = DaoFactory.createPicRankDao();
				picRankDao.update(picRank);
				response.sendRedirect("picRank");
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
