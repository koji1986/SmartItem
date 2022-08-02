package dao;

import java.util.List;

import domain.Staff;

public interface StaffDao {

	List<Staff> findAll() throws Exception;

	Staff findById(Integer id) throws Exception;

	void insert(Staff staff) throws Exception;

	void update(Staff staff) throws Exception;

	void delete(Staff staff) throws Exception;

}
