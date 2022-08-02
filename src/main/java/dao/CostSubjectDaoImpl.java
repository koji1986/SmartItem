package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.CostSubject;

public class CostSubjectDaoImpl implements CostSubjectDao {

	private DataSource ds;

	public CostSubjectDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<CostSubject> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public CostSubject findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(CostSubject costSubject) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(CostSubject costSubject) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(CostSubject costSubject) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
