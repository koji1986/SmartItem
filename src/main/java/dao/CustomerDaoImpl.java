package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private DataSource ds;

	public CustomerDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Customer> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Customer findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Customer customer) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Customer customer) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Customer customer) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
