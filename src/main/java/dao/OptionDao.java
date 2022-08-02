package dao;

import java.util.List;

import domain.Option;



public interface OptionDao {

	List<Option> findAll() throws Exception;

	Option findById(Integer id) throws Exception;

	void insert(Option option) throws Exception;

	void update(Option option) throws Exception;

	void delete(Option option) throws Exception;
	
}
