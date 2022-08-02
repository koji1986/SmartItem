package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Discount;

public class DiscountDaoImpl implements DiscountDao {
	
	private DataSource ds;

	public DiscountDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Discount> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Discount findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Discount discount) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Discount discount) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Discount discount) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
