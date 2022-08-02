package dao;

import java.util.List;

import domain.Cash;

public interface CashDao {

	List<Cash> findAll() throws Exception;

	Cash findById(Integer id) throws Exception;

	void insert(Cash cash) throws Exception;

	void update(Cash cash) throws Exception;

	void delete(Cash cash) throws Exception;

}
