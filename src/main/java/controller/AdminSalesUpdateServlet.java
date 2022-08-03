package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.SalesDao;
import domain.Sales;

/**
 * Servlet implementation class AdminSalesUpdateServlet
 */
@WebServlet("/admin/sales/update")
public class AdminSalesUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSalesUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	Integer id =Integer.parseInt(request.getParameter("id"));
	
	
	SalesDao salesDao = DaoFactory.createSalesDao();

	
		try {
			Sales sales = salesDao.findById(id);
	
	request.setAttribute("salesDate", sales.getSalesDate());
	request.setAttribute("salesTime", sales.getSalesTime());
	request.setAttribute("shopInfId", sales.getShopInfId());
	request.setAttribute("customerCategolyId", sales.getCustomerCategolyId());
	request.setAttribute("picId", sales.getPicId());
	request.setAttribute("sales_nomination", sales.getSalesNomination());
	request.setAttribute("salesPayment", sales.getSalesPayment());
	request.setAttribute("courseId", sales.getCourseId());
	request.setAttribute("optionId", sales.getOptionId());
	request.setAttribute("staffId", sales.getStaffId());
	request.setAttribute("salesCarfare", sales.getSalesCarfare());
	request.setAttribute("salesCost", sales.getSalesCost());
	request.setAttribute("adId", sales.getAdId());
	request.setAttribute("discountId", sales.getDiscountId());
	request.setAttribute("salesDiscountFee", sales.getSalesDiscountFee());
	
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	
	
	
	
		
		
		request.getRequestDispatcher("/WEB-INF/view/admin/sales/update.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
