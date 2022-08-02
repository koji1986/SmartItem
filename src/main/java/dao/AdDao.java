package dao;

import java.util.List;

import domain.Ad;

public interface AdDao {

	List<Ad> findAll() throws Exception;

	Ad findById(Integer id) throws Exception;

	void insert(Ad ad) throws Exception;

	void update(Ad ad) throws Exception;

	void delete(Ad ad) throws Exception;

}
