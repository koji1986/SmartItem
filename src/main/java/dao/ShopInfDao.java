package dao;

import java.util.List;

import domain.ShopInf;

public interface ShopInfDao {

	List<ShopInf> findAll() throws Exception;

	ShopInf findById(Integer id) throws Exception;

	void insert(ShopInf shopInf) throws Exception;

	void update(ShopInf shopInf) throws Exception;

	void delete(ShopInf shopInf) throws Exception;

}
