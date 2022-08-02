package dao;

import java.util.List;

import domain.Cost;

public interface CostDao {
	List<Cost> findAll() throws Exception;

	Cost findById(Integer id) throws Exception;

	void insert(Cost cost) throws Exception;

	void update(Cost cost) throws Exception;

	void delete(Cost cost) throws Exception;

}
