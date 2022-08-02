package dao;

import java.util.List;

import domain.Course;



public interface CourseDao {
	
	List<Course> findAll() throws Exception;

	Course findById(Integer id) throws Exception;

	void insert(Course course) throws Exception;

	void update(Course course) throws Exception;

	void delete(Course course) throws Exception;

}
