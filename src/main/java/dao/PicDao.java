package dao;

import java.util.List;

import domain.Pic;



public interface PicDao {

	List<Pic> findAll() throws Exception;

	Pic findById(Integer id) throws Exception;

	void insert(Pic pic) throws Exception;

	void update(Pic pic) throws Exception;

	void delete(Pic pic) throws Exception;
	
}
