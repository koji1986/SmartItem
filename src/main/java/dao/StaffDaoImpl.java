package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
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
		List<Staff> staffList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select*from staff order by staff_row asc; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				staffList.add(mapToStaff(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return staffList;
	}

	@Override
	public Staff findById(Integer id) throws Exception {
		Staff staff = new Staff();
		try {
			Connection con = ds.getConnection();
			String sql = "   select staff_name,staff_row from staff where id= ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				staff = mapToStaff(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return staff;
	}

	@Override
	public void insert(Staff staff) throws Exception {
		Connection con = ds.getConnection();
		String sql = "insert into staff(staff_name,staff_row)\n"
				+ "values(?,?);";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, staff.getStaffName());
	
		stmt.setObject(2, staff.getStaffRow(), Types.INTEGER);

		stmt.executeUpdate();
	}

	@Override
	public void update(Staff staff) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = "   update staff set staff_name=?,staff_row=? where id=? ;";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, staff.getStaffName());

			stmt.setObject(2, staff.getStaffRow(), Types.INTEGER);
			stmt.setObject(3, staff.getId(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Staff staff) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM staff WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, staff.getId(), Types.INTEGER);
			stmt.executeUpdate();
			} catch (Exception e) {
			throw e;
			}

	}

	private Staff mapToStaff(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String staffName = rs.getString("staff_name");
		Integer staffRow = (Integer) rs.getObject("staff_row");

		return new Staff(id, staffName, staffRow);

	}

}
