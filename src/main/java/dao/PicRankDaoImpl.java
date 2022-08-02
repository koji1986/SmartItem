package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.PicRank;

public class PicRankDaoImpl implements PicRankDao {
	
	
	private DataSource ds;

	public PicRankDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<PicRank> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public PicRank findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(PicRank picRank) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(PicRank picRank) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(PicRank picRank) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
