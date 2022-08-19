package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PicDao;
import dao.PicRankDao;
import domain.Pic;
import domain.PicRank;

/**
 * Servlet implementation class AdminPicServlet
 */
@WebServlet("/admin/pic")
public class AdminPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminPicServlet() {
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
			PicDao picDao = DaoFactory.createPicDao();
			PicRankDao picRankDao = DaoFactory.createPicRankDao();
			List<Pic> picList = picDao.findAll();
			List<PicRank> picRankList = picRankDao.findAll();
			request.setAttribute("picList", picList);
			request.setAttribute("picRankList", picRankList);

			request.getRequestDispatcher("/WEB-INF/view/admin/pic.jsp").forward(request, response);
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
		// Get パラメータの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		// 削除メソッドの引数用に Member オブジェクトを作成
		Pic pic = new Pic();
		pic.setId(id);
		try {
			// データの削除
			PicDao picDao = DaoFactory.createPicDao();
			picDao.delete(pic);
			response.sendRedirect("pic");

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
