package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdDao;
import dao.DaoFactory;
import domain.Ad;

/**
 * Servlet implementation class AdminAdServlet
 */
@WebServlet("/admin/ad")
public class AdminAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			AdDao adDao = DaoFactory.createAdDao();
			List<Ad> adList = adDao.findAll();
			request.setAttribute("adList", adList);

			request.getRequestDispatcher("/WEB-INF/view/admin/ad.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("update") != null) {
			// 更新
			try {
				String adName = request.getParameter("ad_name");
				Integer adRow = Integer.parseInt(request.getParameter("ad_row"));
				Integer adId = Integer.parseInt(request.getParameter("id"));
								
				Ad ad = new Ad();
				
				ad.setAdName(adName);
				
				ad.setAdRow(adRow);
				ad.setId(adId);

				AdDao adDao = DaoFactory.createAdDao();
				adDao.update(ad);
				response.sendRedirect("course");
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else {
			// 削除
		}

	}

	}


