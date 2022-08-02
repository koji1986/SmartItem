package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Option;

public class OptionDaoImpl implements OptionDao {
	
	
	private DataSource ds;

	public OptionDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Option> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Option findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Option option) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Option option) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Option option) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
