package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Admins;

public class AdminsDaoImpl implements AdminsDao {

	private DataSource ds;

	public AdminsDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Admins> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Admins findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Admins admins) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Admins admins) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Admins admins) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
