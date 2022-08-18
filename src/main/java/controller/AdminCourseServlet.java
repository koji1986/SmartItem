package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.DaoFactory;
import dao.ShopInfDao;
import domain.Course;
import domain.ShopInf;

/**
 * Servlet implementation class AdminCourseServlet
 */
@WebServlet("/admin/course")
public class AdminCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCourseServlet() {
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
			CourseDao courseDao = DaoFactory.createCourseDao();
			ShopInfDao shopInfDao = DaoFactory.createShopInfDao();
			List<Course> courseList = courseDao.findAll();
			List<ShopInf> shopInfList = shopInfDao.findAll();
			request.setAttribute("courseList", courseList);
			request.setAttribute("shopInfList", shopInfList);

			request.getRequestDispatcher("/WEB-INF/view/admin/course.jsp").forward(request, response);
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
				String courseName = request.getParameter("course_name");

				Integer courseFee = Integer.parseInt(request.getParameter("course_fee"));
				Integer courseTime = Integer.parseInt(request.getParameter("course_time"));
				Integer courseRow = Integer.parseInt(request.getParameter("course_row"));

				Integer courseId = Integer.parseInt(request.getParameter("id"));
				Course course = new Course();
				course.setShopInfId(shopInfId);
				course.setCourseName(courseName);
				course.setCourseFee(courseFee);
				course.setCourseTime(courseTime);
				course.setCourseRow(courseRow);
				course.setId(courseId);

				CourseDao courseDao = DaoFactory.createCourseDao();
				courseDao.update(course);
				response.sendRedirect("course");
		} else {
			// 削除
			Integer courseId = Integer.parseInt(request.getParameter("id"));
			Course course = new Course();
			course.setShopInfId(1);
			course.setCourseName(null);
			course.setCourseFee(0);
			course.setCourseTime(0);
			course.setCourseRow(0);
			course.setId(courseId);

			CourseDao courseDao = DaoFactory.createCourseDao();
			courseDao.update(course);
			response.sendRedirect("course");
		}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
