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
			String sql = "  select sales.id,sales.sales_date,sales.sales_time, shop_inf.shopInf_name, pic.pic_nameA, sales.sales_amount,sales.sales_salary, sales.cash_change,staff.staff_name,sales.cash_cost,sales.salary_done \r\n"
					+ "					 from sales   \r\n"
					+ "                     left join cash on cash.sales_id = sales.id  \r\n"
					+ "                     left join staff on cash.staff_id=staff.id \r\n"
					+ "                     left join shop_inf on sales.shopInf_id = shop_inf.id \r\n"
					+ "					 left join  pic on sales.pic_id= pic.id;  ";
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
			String sql = "  select sales.id,sales.sales_date,sales.sales_time, shop_inf.shopInf_name, pic.pic_nameA, sales.sales_amount,sales.sales_salary, sales.cash_change,staff.staff_name,sales.cash_cost,sales.salary_done \r\n"
					+ "					 from sales   \r\n"
					+ "                     left join cash on cash.sales_id = sales.id  \r\n"
					+ "                     left join staff on cash.staff_id=staff.id \r\n"
					+ "                     left join shop_inf on sales.shopInf_id = shop_inf.id \r\n"
					+ "					 left join  pic on sales.pic_id= pic.id  where sales.id=?; ";
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
			String sql = "    update sales set  cash_change=?, cash_cost=? ,salary_done=? where id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setObject(1, cash.getCashChange(), Types.INTEGER);

			stmt.setObject(2, cash.getCashCost(), Types.INTEGER);
			stmt.setObject(3, cash.getSalaryDone(), Types.INTEGER);
			stmt.setObject(4, cash.getId(), Types.INTEGER);

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

		Cash cash = new Cash();
		cash.setId((Integer) rs.getObject("id"));

		cash.setCashDate(rs.getTimestamp("sales_date"));
		cash.setSalesTime(rs.getTimestamp("sales_time"));
		cash.setStaffName(rs.getString("staff_name"));
//		cash.setStaffId((Integer) rs.getObject("staff_id"));
		cash.setShopInfName(rs.getString("shopInf_name"));
		// cash.setShopInfId((Integer) rs.getObject("shopInf_id"));
		cash.setPicNameA(rs.getString("pic_nameA"));
//		cash.setPicId((Integer) rs.getObject("pic_id"));
		cash.setSalesAmount((Integer) rs.getObject("sales_amount"));
		cash.setSalesSalary((Integer) rs.getObject("sales_salary"));
		cash.setCashChange((Integer) rs.getObject("cash_change"));
		cash.setCashCost((Integer) rs.getObject("cash_cost"));
		cash.setSalaryDone((Integer) rs.getObject("salary_done"));

		return cash;

	}

	@Override
	public List<Cash> findByDate(Date cashDate) throws Exception {
		List<Cash> cashList = new ArrayList<>();

		try {
			Connection con = ds.getConnection();
			String sql = "  select sales.id,sales.sales_date,sales.sales_time, shop_inf.shopInf_name, pic.pic_nameA, sales.sales_amount,sales.sales_salary, sales.cash_change,staff.staff_name,sales.cash_cost,sales.salary_done \r\n"
					+ "					 from sales   \r\n"
					+ "                     left join cash on cash.sales_id = sales.id  \r\n"
					+ "                     left join staff on cash.staff_id=staff.id \r\n"
					+ "                     left join shop_inf on sales.shopInf_id = shop_inf.id \r\n"
					+ "					 left join  pic on sales.pic_id= pic.id where sales.sales_date=?;  ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(cashDate.getTime()));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cashList.add(mapToCash(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return cashList;
	}

}
