package dao;

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
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Course findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Course course) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Course course) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Course course) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
