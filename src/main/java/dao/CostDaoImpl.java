package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Cost;

public class CostDaoImpl implements CostDao {
	
	private DataSource ds;

	public CostDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Cost> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Cost findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Cost cost) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Cost cost) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Cost cost) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
