package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.CostSubject;

public class CostSubjectDaoImpl implements CostSubjectDao {

	private DataSource ds;

	public CostSubjectDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<CostSubject> findAll() throws Exception {
		List<CostSubject> costSubjectList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = "  select* from cost_subject;  ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				costSubjectList.add(mapToCostSubject(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return costSubjectList;
	}

	@Override
	public CostSubject findById(Integer id) throws Exception {
		CostSubject costSubject = new CostSubject();
		try {
			Connection con = ds.getConnection();
			String sql = "   select cost_subject_name from cost_subject where id= ?;   ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				costSubject = mapToCostSubject(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return costSubject;
	}

	@Override
	public void insert(CostSubject costSubject) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(CostSubject costSubject) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(CostSubject costSubject) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private CostSubject mapToCostSubject(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String costSubjectName = rs.getString("cost_subject_name");

		return new CostSubject(id, costSubjectName);

	}

}
