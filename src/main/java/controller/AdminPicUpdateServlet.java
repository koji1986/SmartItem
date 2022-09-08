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

import dao.DaoFactory;
import dao.PicDao;
import dao.PicRankDao;
import domain.Pic;
import domain.PicRank;

/**
 * Servlet implementation class AdminPicUpdateServlet
 */
@WebServlet("/admin/pic/update")
public class AdminPicUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminPicUpdateServlet() {
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

		PicDao picDao = DaoFactory.createPicDao();
		PicRankDao picRankDao = DaoFactory.createPicRankDao();

		
		try {
			Pic pic = picDao.findById(id);
			List<PicRank> picRankList = picRankDao.findAll();
			request.setAttribute("picRankList", picRankList);
			request.setAttribute("picRankIdA", pic.getPicRankIdA());
			request.setAttribute("picNameA", pic.getPicNameA());
			request.setAttribute("picKanaA", pic.getPicKanaA());
			request.setAttribute("picRankIdB", pic.getPicRankIdB());
			request.setAttribute("picNameB", pic.getPicNameB());
			request.setAttribute("picKanaB", pic.getPicKanaB());
			request.setAttribute("picPhoneNumber", pic.getPicPhoneNumber());
			request.setAttribute("picEmail", pic.getPicEmail());
			request.setAttribute("picAddress", pic.getPicAddress());
			request.setAttribute("picEntryDay", pic.getPicEntryDay());
			request.setAttribute("picOutDay", pic.getPicOutDay());
			request.setAttribute("picMemo", pic.getPicMemo());

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/view/admin/pic/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			boolean isError = false; 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date picEntryDay =new Date();
			Date picOutDay =new Date();
			
			if(request.getParameter("pic_nameA").isBlank()) {
				request.setAttribute("picNameAError", "名前が未入力です。");
				 isError = true; // 入力に不備ありと判定
			}
			
			if (request.getParameter("pic_entry_day").isBlank()) {
				 // エラーメッセージの作成
				 request.setAttribute("entryDayError", "入社日が未入力です。");
				 isError = true; // 入力に不備ありと判定
				 } 
			else {picEntryDay = sdf.parse(request.getParameter("pic_entry_day"));}
			
			if (request.getParameter("pic_out_day").isBlank()) {
				picOutDay=null;
			} 
			else {picOutDay = sdf.parse(request.getParameter("pic_out_day"));}
			
			if (isError == true) {
				
				 request.getRequestDispatcher("/WEB-INF/view/admin/pic/update.jsp")
				 .forward(request, response);
				 return;
				 } 
			
			
			
			Integer picRankIdA = Integer.parseInt(request.getParameter("picRank_idA"));
			String picNameA = request.getParameter("pic_nameA");
			String picKanaA = request.getParameter("pic_kanaA");
			Integer picRankIdB = Integer.parseInt(request.getParameter("picRank_idB"));
			String picNameB = request.getParameter("pic_nameB");
			String picKanaB = request.getParameter("pic_kanaB");
			String picPhoneNumber = request.getParameter("pic_phone_number");

			String picEmail = request.getParameter("pic_email");
			String picAddress = request.getParameter("pic_address");

			
			

			String picMemo = request.getParameter("pic_memo");
			Integer picId = Integer.parseInt(request.getParameter("id"));

			Pic pic = new Pic();
			pic.setPicRankIdA(picRankIdA);
			pic.setPicNameA(picNameA);
			pic.setPicKanaA(picKanaA);
			pic.setPicRankIdB(picRankIdB);
			pic.setPicNameB(picNameB);
			pic.setPicKanaB(picKanaB);
			pic.setPicPhoneNumber(picPhoneNumber);
			pic.setPicEmail(picEmail);
			pic.setPicAddress(picAddress);
			pic.setPicEntryDay(picEntryDay);
			pic.setPicOutDay(picOutDay);
			pic.setPicMemo(picMemo);
			pic.setId(picId);

			PicDao picDao = DaoFactory.createPicDao();
			picDao.update(pic);
			response.sendRedirect("../pic");
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
