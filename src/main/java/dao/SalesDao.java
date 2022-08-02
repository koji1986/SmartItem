package dao;

import java.util.List;

import domain.Sales;

public interface SalesDao {

	List<Sales> findAll() throws Exception;

	Sales findById(Integer id) throws Exception;

	void insert(Sales sales) throws Exception;

	void update(Sales sales) throws Exception;

	void delete(Sales sales) throws Exception;

}
