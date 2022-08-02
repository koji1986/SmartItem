package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Cash;

public class CashDaoImpl implements CashDao {
	
	private DataSource ds;

	public CashDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	

	@Override
	public List<Cash> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Cash findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Cash cash) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Cash cash) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Cash cash) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
