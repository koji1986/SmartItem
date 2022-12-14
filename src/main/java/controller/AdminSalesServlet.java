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
import domain.Pic;
import domain.Sales;

/**
 * Servlet implementation class AdminSalesServlet
 */
@WebServlet("/admin/sales")
public class AdminSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSalesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			SalesDao salesDao = DaoFactory.createSalesDao();
			List<Sales> salesList = salesDao.findAll();
			List<Pic> picList =salesDao.findAllPic();		
			request.setAttribute("salesList", salesList);
			request.setAttribute("picList", picList);
			
			request.getRequestDispatcher("/WEB-INF/view/admin/sales.jsp").forward(request, response);
			} catch (Exception e) {
			throw new ServletException(e);
			}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SalesDao salesDao = DaoFactory.createSalesDao();
		List<Sales> salesList = null;
		
		if(request.getParameter("sales_date")!=null && !request.getParameter("sales_date").isBlank()) {
			try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			Date salesDay;
				salesDay = sdfDate.parse(request.getParameter("sales_date"));
				salesList = salesDao.findByDate(salesDay);
				request.setAttribute("date", salesDay);
				
			} catch (Exception e) {
				// TODO ????????????????????? catch ????????????
				e.printStackTrace();
			}
			
		}else {
			 try {
				salesList = salesDao.findAll();
			} catch (Exception e) {
				// TODO ????????????????????? catch ????????????
				e.printStackTrace();
			}
			
			
		}
		request.setAttribute("salesList", salesList);
		request.getRequestDispatcher("/WEB-INF/view/admin/sales.jsp").forward(request, response);;
	}

}
