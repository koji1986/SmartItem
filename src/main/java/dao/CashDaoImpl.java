package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.Cash;

public class CashDaoImpl implements CashDao {

	private DataSource ds;

	public CashDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Cash> findAll() throws Exception {
		List<Cash> cashList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = "  select cash.id,cash.cash_date,cash.cash_change,staff.staff_name,cash.cash_cost\n"
					+ "from cash join staff \n" + "on cash.staff_id=staff.id; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cashList.add(mapToCash(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return cashList;
	}

	@Override
	public Cash findById(Integer id) throws Exception {
		Cash cash = new Cash();
		try {
			Connection con = ds.getConnection();
			String sql = "  select cash.cash_date,cash.cash_change,staff.staff_name,cash.cash_cost\n"
					+ "from cash join staff \n" + "on cash.staff_id=staff.id where id=?; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				cash = mapToCash(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return cash;
	}

	@Override
	public void insert(Cash cash) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Cash cash) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = "    update cash set cash_date=? , cash_change=?,staff_id=?, cash_cost=? where id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, cash.getCashDate());
			stmt.setObject(2, cash.getCashChange(), Types.INTEGER);

			stmt.setObject(3, cash.getStaffId(), Types.INTEGER);
			stmt.setObject(4, cash.getCashCost(), Types.INTEGER);
			stmt.setObject(5, cash.getId(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Cash cash) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Cash mapToCash(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		Date cashDate = rs.getTimestamp("cash_date");
		Integer cashChange = (Integer) rs.getObject("cash_change");
		String staffName = rs.getString("staff_name");
		Integer cashCost = (Integer) rs.getObject("cash_cost");

		return new Cash(id, cashDate, cashChange, staffName, cashCost);

	}

	@Override
	public Cash findByDate(Date cashDate) throws Exception {
		Cash cash = new Cash();
		try {
			Connection con = ds.getConnection();
			String sql = "  select cash.cash_date,cash.cash_change,staff.staff_name,cash.cash_cost\n"
					+ "from cash join staff \n" + "on cash.staff_id=staff.id where cash.cash_date=?; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, cash.getCashDate());
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				cash = mapToCash(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return cash;
	}

}
