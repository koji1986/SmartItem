package dao;

import java.util.List;

import javax.sql.DataSource;

import domain.Staff;

public class StaffDaoImpl implements StaffDao {
	
	
	private DataSource ds;

	public StaffDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Staff> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Staff findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Staff staff) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Staff staff) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Staff staff) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
