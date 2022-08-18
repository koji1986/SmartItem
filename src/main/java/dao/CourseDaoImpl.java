package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Course;

public class CourseDaoImpl implements CourseDao {

	private DataSource ds;

	public CourseDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Course> findAll() throws Exception {
		List<Course> courseList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = "select course.id,course.shopInf_id, shop_inf.shopInf_name,course_name,\n"
					+ "course_fee,course_time,course_row\n" + "from course\n" + "join shop_inf\n"
					+ "on course.shopInf_id=shop_inf.id; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				courseList.add(mapToCourse(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return courseList;

	}

	@Override
	public Course findById(Integer id) throws Exception {
		Course course = new Course();
		try {
			Connection con = ds.getConnection();
			String sql = " select course.id,course.shopInf_id, shop_inf.shopInf_name,course_name,\n"
					+ "course_fee,course_time,course_row\n" + "from course\n" + "join shop_inf\n"
					+ "on course.shopInf_id=shop_inf.id" + " where course.id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				course = mapToCourse(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return course;
	}

	@Override
	public void insert(Course course) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Course course) throws Exception {

		try {
			Connection con = ds.getConnection();
			String sql = " update course set\n" + "shopInf_id=?,\n" + "course_name=?,\n" + "course_time=?,\n"
					+ "course_row=?\n" + "where course.id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, course.getShopInfId(), Types.INTEGER);
			stmt.setString(2, course.getCourseName());
			stmt.setObject(3, course.getCourseTime(), Types.INTEGER);
			stmt.setObject(4, course.getCourseRow(), Types.INTEGER);
			stmt.setObject(5, course.getId(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Course course) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Course mapToCourse(ResultSet rs) throws Exception {

		Course course = new Course();

		course.setId((Integer) rs.getObject("id"));
		course.setShopInfName(rs.getString("shopInf_name"));
		course.setShopInfId((Integer) rs.getObject("shopInf_id"));
		course.setCourseName(rs.getString("course_name"));
		course.setCourseFee((Integer) rs.getObject("course_fee"));
		course.setCourseTime((Integer) rs.getObject("course_time"));
		course.setCourseRow((Integer) rs.getObject("course_row"));

		return course;

	}

}
