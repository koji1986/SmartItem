package dao;

import java.util.List;

import domain.CustomerCategoly;

public interface CustomerCategolyDao {

	List<CustomerCategoly> findAll() throws Exception;

	CustomerCategoly findById(Integer id) throws Exception;

	void insert(CustomerCategoly customerCategoly) throws Exception;

	void update(CustomerCategoly customerCategoly) throws Exception;

	void delete(CustomerCategoly customerCategoly) throws Exception;

}
