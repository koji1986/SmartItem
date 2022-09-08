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
import dao.SalesDao;
import domain.Pic;
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
			SalesDao salesDao = DaoFactory.createSalesDao();
			PicDao picDao = DaoFactory.createPicDao();
			List<Sales> salesList;
			List<Pic> picList;
			List<Sales> salesDatePicList1;
			List<Sales> salesDatePicList2;
			List<Sales> salesDatePicList3;
			List<Sales> salesDatePicList4;
			
			Date salesDay;
			Integer picId1;
			Integer picId2;
			Integer picId3;
			Integer picId4;
			
			picList = picDao.findAll();
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			
			if (request.getParameter("sales_day") != null) {

				salesDay = sdfDate.parse(request.getParameter("sales_day"));
				salesList = salesDao.findByDate(salesDay);

			} else {

				salesDay = new Date();
				salesList = salesDao.findByDate(salesDay);

			}

			if (request.getParameter("pic_id_1") != null) {
				picId1 = Integer.parseInt(request.getParameter("pic_id_1"));
			/*	
			if(request.getParameter("in_time1").isBlank()) {
				
			}else {	
				Date inTime1 = sdfTime.parse(request.getParameter("in_time1"));
				sales1.setInTime(inTime1);
			}
			
			
			if(request.getParameter("out_time1").isBlank()) {
				
			}else {
				Date outTime1 = sdfTime.parse(request.getParameter("out_time1"));
				sales1.setOutTime(outTime1);
			}
			
			if(request.getParameter("start1")==null) {
				
			}else {
				Date start1 = sdfTime.parse(request.getParameter("start1"));
				sales1.setStart(start1);
			}
			
			if(request.getParameter("sales_id_1")==null || request.getParameter("sales_id_1").isBlank() ) {
				
			}else {
				Integer salesId1 = Integer.parseInt(request.getParameter("sales_id_1"));
				sales1.setId(salesId1);
			}
			
			String spot1 =request.getParameter("spot1");
			sales1.setSpot(spot1);
				
				salesDao.insertUseReport(sales1);
				*/
				
				
				salesDatePicList1 = salesDao.findByDatePicId(salesDay, picId1);
				request.setAttribute("salesDatePicList1", salesDatePicList1);

				int totalSales1 = 0;
				int totalSalary1 = 0;

				for (Sales s : salesDatePicList1) {
					if(s.getSalesAmount()==null) {}
					else {
					totalSales1 += s.getSalesAmount();
					totalSalary1 += s.getSalesSalary();

				}}
				
				
				
				
				
				
				request.setAttribute("totalSales1", totalSales1);
				request.setAttribute("totalSalary1", totalSalary1);
				request.setAttribute("picId1", picId1);

			}
			if (request.getParameter("pic_id_2") != null) {
				picId2 = Integer.parseInt(request.getParameter("pic_id_2"));
				
				/*if(request.getParameter("in_time2").isBlank() || request.getParameter("in_time2")==null) {
					
				}else {	
					Date inTime2 = sdfTime.parse(request.getParameter("in_time2"));
					sales2.setInTime(inTime2);
				}
				
				
				if(request.getParameter("out_time2").isBlank()) {
					
				}else {
					Date outTime2 = sdfTime.parse(request.getParameter("out_time2"));
					sales2.setOutTime(outTime2);
				}
				
				if(request.getParameter("start2")==null) {
					
				}else {
					Date start2 = sdfTime.parse(request.getParameter("start2"));
					sales2.setStart(start2);
				}
				
				if(request.getParameter("sales_id_2")==null || request.getParameter("sales_id_2").isBlank() ) {
					
				}else {
					Integer salesId1 = Integer.parseInt(request.getParameter("sales_id_2"));
					sales2.setId(salesId1);
				}
				
				String spot2 =request.getParameter("spot2");
				sales2.setSpot(spot2);
					
					salesDao.insertUseReport(sales2);
				
				*/
				
				
				
				salesDatePicList2 = salesDao.findByDatePicId(salesDay, picId2);
				request.setAttribute("salesDatePicList2", salesDatePicList2);

				int totalSales2 = 0;
				int totalSalary2 = 0;

				for (Sales s : salesDatePicList2) {
					if(s.getSalesAmount()==null) {}
					else {
					totalSales2 += s.getSalesAmount();
					totalSalary2 += s.getSalesSalary();
					}
				}
				request.setAttribute("totalSales2", totalSales2);
				request.setAttribute("totalSalary2", totalSalary2);
				request.setAttribute("picId2", picId2);

			}
			if (request.getParameter("pic_id_3") != null) {
				picId3 = Integer.parseInt(request.getParameter("pic_id_3"));
				salesDatePicList3 = salesDao.findByDatePicId(salesDay, picId3);
				request.setAttribute("salesDatePicList3", salesDatePicList3);

				int totalSales3 = 0;
				int totalSalary3 = 0;

				for (Sales s : salesDatePicList3) {
					if(s.getSalesAmount()==null) {}
					else {
					totalSales3 += s.getSalesAmount();
					totalSalary3 += s.getSalesSalary();
					}
				}
				request.setAttribute("totalSales3", totalSales3);
				request.setAttribute("totalSalary3", totalSalary3);
				request.setAttribute("picId3", picId3);

			}
			if (request.getParameter("pic_id_4") != null) {
				picId4 = Integer.parseInt(request.getParameter("pic_id_4"));
				salesDatePicList4 = salesDao.findByDatePicId(salesDay, picId4);
				request.setAttribute("salesDatePicList4", salesDatePicList4);

				int totalSales4 = 0;
				int totalSalary4 = 0;

				for (Sales s : salesDatePicList4) {
					if(s.getSalesAmount()==null) {}
					else {
					totalSales4 += s.getSalesAmount();
					totalSalary4 += s.getSalesSalary();
					}
				}
				request.setAttribute("totalSales4", totalSales4);
				request.setAttribute("totalSalary4", totalSalary4);
				request.setAttribute("picId4", picId4);

			}

			request.setAttribute("salesList", salesList);
			request.setAttribute("picList", picList);

			request.setAttribute("salesDay", salesDay);
			
			
			

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
