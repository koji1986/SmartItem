package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.CustomerCategoly;

public class CustomerCategolyDaoImpl implements CustomerCategolyDao {
	
	private DataSource ds;

	public CustomerCategolyDaoImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public List<CustomerCategoly> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public CustomerCategoly findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(CustomerCategoly customerCategoly) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(CustomerCategoly customerCategoly) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(CustomerCategoly customerCategoly) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
