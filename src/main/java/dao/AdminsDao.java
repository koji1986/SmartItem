package dao;

import java.util.List;

import domain.Admins;

public interface AdminsDao {

	List<Admins> findAll() throws Exception;

	Admins findById(Integer id) throws Exception;

	void insert(Admins admins) throws Exception;

	void update(Admins admins) throws Exception;

	void delete(Admins admins) throws Exception;

	Admins findByLoginIdAndLoginPass(String loginId, String loginPass) throws Exception;

}
