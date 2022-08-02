package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Pic;

public class PicDaoImpl implements PicDao {
	
	
	private DataSource ds;

	public PicDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Pic> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Pic findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Pic pic) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Pic pic) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Pic pic) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
