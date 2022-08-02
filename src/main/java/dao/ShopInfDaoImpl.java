package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.ShopInf;

public class ShopInfDaoImpl implements ShopInfDao {
	
	private DataSource ds;

	public ShopInfDaoImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public List<ShopInf> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ShopInf findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(ShopInf shopInf) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(ShopInf shopInf) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(ShopInf shopInf) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
