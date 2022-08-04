package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.Cost;

public class CostDaoImpl implements CostDao {

	private DataSource ds;

	public CostDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Cost> findAll() throws Exception {
		List<Cost> costList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = " select cost.id,cost.cost_date,staff.staff_name,shop_inf.shopInf_name,\n"
					+ "cost.cost_destination,cost_subject.cost_subject_name,\n" + "cost.cost_fee,cost.cost_detail\n"
					+ "from cost\n" + "join staff on cost.staff_id=staff.id\n"
					+ "join shop_inf on cost.shopName_id=shop_inf.id\n"
					+ "join cost_subject on cost.costSubject_id=cost_subject.id; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				costList.add(mapToCost(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return costList;
	}

	@Override
	public Cost findById(Integer id) throws Exception {
		Cost cost = new Cost();
		try (Connection con = ds.getConnection()) {
			String sql = "select cost.id,cost.cost_date,staff.staff_name,shop_inf.shopInf_name,\n"
					+ "cost.cost_destination,cost_subject.cost_subject_name,\n" + "cost.cost_fee,cost.cost_detail\n"
					+ "from cost\n" + "join staff on cost.staff_id=staff.id\n"
					+ "join shop_inf on cost.shopName_id=shop_inf.id\n"
					+ "join cost_subject on cost.costSubject_id=cost_subject.id where cost.id=?;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				cost = mapToCost(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return cost;
	}

	@Override
	public void insert(Cost cost) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = " insert into cost(\n" + "cost_date,\n" + "staff_id,\n" + "shopName_id,\n"
					+ "cost_destination,\n" + "costSubject_id,\n" + "cost_fee,\n" + "cost_detail)\n"
					+ "values(?,?,?,?,?,?,?);";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, cost.getCostDate());
			stmt.setObject(2, cost.getStaffId(), Types.INTEGER);
			stmt.setObject(3, cost.getShopNameId(), Types.INTEGER);
			stmt.setString(4, cost.getCostDestination());
			stmt.setObject(5, cost.getCostSubjectId(), Types.INTEGER);
			stmt.setObject(6, cost.getCostFee(), Types.INTEGER);
			stmt.setString(7, cost.getCostDetail());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Cost cost) throws Exception {

		try {
			Connection con = ds.getConnection();
			String sql = " update cost set\n" + "cost_date=?,\n" + "staff_id=?,\n" + "shopName_id=?,\n"
					+ "cost_destination=?,\n" + "costSubject_id=?,\n" + "cost_fee=?,\n" + "cost_detail=?\n"
					+ "where id=?; ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setObject(1, cost.getCostDate());
			stmt.setObject(2, cost.getStaffId(), Types.INTEGER);
			stmt.setObject(3, cost.getShopNameId(), Types.INTEGER);
			stmt.setString(4, cost.getCostDestination());
			stmt.setObject(5, cost.getCostSubjectId(), Types.INTEGER);
			stmt.setObject(6, cost.getCostFee(), Types.INTEGER);
			stmt.setString(7, cost.getCostDetail());
			stmt.setObject(8, cost.getId(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Cost cost) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Cost mapToCost(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		Date costDate = rs.getTimestamp("cost_date");
		String staffName = rs.getString("staff_name");

		String shopInfName = rs.getString("shopInf_name");

		String costDestination = rs.getString("cost_destination");
		String costSubjectId = rs.getString("cost_subject_name");
		Integer costFee = (Integer) rs.getObject("cost_fee");
		String costDetail = rs.getString("cost_detail");

		return new Cost(id, costDate, staffName, shopInfName, costDestination, costSubjectId, costFee, costDetail);
	}

}
