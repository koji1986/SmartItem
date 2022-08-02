package dao;

import java.util.List;

import domain.Discount;

public interface DiscountDao {

	List<Discount> findAll() throws Exception;

	Discount findById(Integer id) throws Exception;

	void insert(Discount discount) throws Exception;

	void update(Discount discount) throws Exception;

	void delete(Discount discount) throws Exception;

}
