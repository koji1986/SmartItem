package dao;

import java.util.List;

import domain.CostSubject;

public interface CostSubjectDao {

	List<CostSubject> findAll() throws Exception;

	CostSubject findById(Integer id) throws Exception;

	void insert(CostSubject costSubject) throws Exception;

	void update(CostSubject costSubject) throws Exception;

	void delete(CostSubject costSubject) throws Exception;

}
