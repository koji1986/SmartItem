package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import dao.DaoFactory;
import domain.Cost;

/**
 * Servlet implementation class AdminCostInputServlet
 */
@WebServlet("/admin/cost/input")
public class AdminCostInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCostInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/admin/cost/input.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			
		Date costDate = sdfDate.parse(request.getParameter("cost_date"));
		Integer staffId = Integer.parseInt(request.getParameter("staff_id"));
		Integer shopNameId = Integer.parseInt(request.getParameter("shop_id"));
		String costDestination = request.getParameter("cost_destination");
		Integer costSubjectId = Integer.parseInt(request.getParameter("cost_subject_id"));
		Integer costFee = Integer.parseInt(request.getParameter("cost_fee"));
		String costDetail = request.getParameter("cost_detail");
		
		

		Cost cost = new Cost();
		cost.setCostDate(costDate);
		cost.setStaffId(staffId);
		cost.setShopNameId(shopNameId);
		cost.setCostDestination(costDestination);
		cost.setCostSubjectId(costSubjectId);
		cost.setCostFee(costFee);
		cost.setCostDetail(costDetail);
		
		
		
		

			CostDao costDao = DaoFactory.createCostDao();
			costDao.insert(cost);
			response.sendRedirect("../costA");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
