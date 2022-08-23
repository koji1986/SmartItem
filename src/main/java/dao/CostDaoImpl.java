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
			String sql = " select cost.id,cost.cost_date,staff.staff_name,"
					+ " cost.staff_id,shop_inf.shopInf_name,cost.shopName_id, \n"
					+ "cost.cost_destination,cost_subject.cost_subject_name," + " cost.costSubject_id,\n"
					+ "cost.cost_fee,cost.cost_detail\n" + "from cost\n" + "join staff on cost.staff_id=staff.id\n"
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
			String sql = "select cost.id,cost.cost_date,staff.staff_name,"
					+ "cost.staff_id, shop_inf.shopInf_name,cost.shopName_id, \n"
					+ "cost.cost_destination,cost_subject.cost_subject_name," + " cost.costSubject_id, \n"
					+ "cost.cost_fee,cost.cost_detail\n" + "from cost\n" + "join staff on cost.staff_id=staff.id\n"
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
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM cost WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, cost.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	private Cost mapToCost(ResultSet rs) throws Exception {
		Cost cost = new Cost();

		cost.setId((Integer) rs.getObject("id"));
		cost.setCostDate(rs.getTimestamp("cost_date"));
		cost.setStaffName(rs.getString("staff_name"));
		cost.setStaffId((Integer) rs.getObject("staff_id"));
		cost.setShopInfName(rs.getString("shopInf_name"));
		cost.setShopNameId((Integer) rs.getObject("shopName_id"));
		cost.setCostDestination(rs.getString("cost_destination"));
		cost.setCostSubjectName(rs.getString("cost_subject_name"));
		cost.setCostSubjectId((Integer) rs.getObject("costSubject_id"));
		cost.setCostFee((Integer) rs.getObject("cost_fee"));
		cost.setCostDetail(rs.getString("cost_detail"));

		return cost;
	}
	@Override
	public List<Cost> findByCostDate(Date costDate) throws Exception {
		List<Cost> costList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "select cost.id,cost.cost_date,staff.staff_name,"
					+ "cost.staff_id, shop_inf.shopInf_name,cost.shopName_id, \n"
					+ "cost.cost_destination,cost_subject.cost_subject_name," + " cost.costSubject_id, \n"
					+ "cost.cost_fee,cost.cost_detail\n" + "from cost\n" + "join staff on cost.staff_id=staff.id\n"
					+ "join shop_inf on cost.shopName_id=shop_inf.id\n"
					+ "join cost_subject on cost.costSubject_id=cost_subject.id where cost.cost_date=?;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, new java.sql.Date(costDate.getTime()));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				costList.add(mapToCost(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return costList;

	}
	
	
}
