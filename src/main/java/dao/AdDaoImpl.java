package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Ad;

public class AdDaoImpl implements AdDao {
	
	private DataSource ds;

	public AdDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Ad> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Ad findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Ad ad) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Ad ad) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Ad ad) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
