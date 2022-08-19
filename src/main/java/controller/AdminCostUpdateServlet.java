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

import dao.CostDao;
import dao.CostSubjectDao;
import dao.DaoFactory;
import dao.ShopInfDao;
import dao.StaffDao;
import domain.Cost;
import domain.CostSubject;
import domain.ShopInf;
import domain.Staff;

/**
 * Servlet implementation class AdminCostUpdateServlet
 */
@WebServlet("/admin/cost/update")
public class AdminCostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCostUpdateServlet() {
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

		CostDao costDao = DaoFactory.createCostDao();
		StaffDao staffDao = DaoFactory.createStaffDao();
		ShopInfDao shopInfDao = DaoFactory.createShopInfDao();
		CostSubjectDao costSubjectDao = DaoFactory.createCostSubjectDao();
	
		try {
			Cost cost = costDao.findById(id);

			List<Staff> staffList = staffDao.findAll();
			List<ShopInf> shopInfList = shopInfDao.findAll();
			List<CostSubject> costSubjectList = costSubjectDao.findAll();
			request.setAttribute("staffList", staffList);
			request.setAttribute("shopInfList", shopInfList);
			request.setAttribute("costSubjectList", costSubjectList);

			request.setAttribute("costDate", cost.getCostDate());
			request.setAttribute("staffId", cost.getStaffId());
			request.setAttribute("shopNameId", cost.getShopNameId());
			request.setAttribute("costDestination", cost.getCostDestination());
			request.setAttribute("costSubjectId", cost.getCostSubjectId());
			request.setAttribute("costFee", cost.getCostFee());
			request.setAttribute("costDetail", cost.getCostDetail());

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/view/admin/cost/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date costDate;
			costDate = sdf.parse(request.getParameter("cost_date"));
			Integer staffId = Integer.parseInt(request.getParameter("staff_id"));
			Integer shopNameId = Integer.parseInt(request.getParameter("shop_id"));
			String costDestination = request.getParameter("cost_destination");
			Integer costSubjectId = Integer.parseInt(request.getParameter("cost_subject_id"));
			Integer costFee = Integer.parseInt(request.getParameter("cost_fee"));
			String costDetail = request.getParameter("cost_detail");
			Integer costId = Integer.parseInt(request.getParameter("id"));

			Cost cost = new Cost();
			cost.setCostDate(costDate);
			cost.setStaffId(staffId);
			cost.setShopNameId(shopNameId);
			cost.setCostDestination(costDestination);
			cost.setCostSubjectId(costSubjectId);
			cost.setCostFee(costFee);
			cost.setCostDetail(costDetail);
			cost.setId(costId);

			CostDao costDao = DaoFactory.createCostDao();
			costDao.update(cost);
			response.sendRedirect("../costA");

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
