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
import dao.SalesDao;
import domain.Sales;

/**
 * Servlet implementation class AdminUseReportAServlet
 */
@WebServlet("/admin/useReportA")
public class AdminUseReportAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUseReportAServlet() {
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
			if (request.getParameter("sales_day") != null) {
				SalesDao salesDao = DaoFactory.createSalesDao();

				List<Sales> salesList;

				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				Date salesDay = sdfDate.parse(request.getParameter("sales_day"));
				salesList = salesDao.findByDate(salesDay);
				request.setAttribute("salesList",salesList);
				
			} else {
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/view/admin/useReportA.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
