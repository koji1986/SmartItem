package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Admins;

public class AdminsDaoImpl implements AdminsDao {

	private DataSource ds;

	public AdminsDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Admins> findAll() throws Exception {
		List<Admins> adminsList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select*from admins; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				adminsList.add(mapToAdmin(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return adminsList;
	}

	@Override
	public Admins findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Admins admins) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = " insert into admins(login_name,login_phone_number,\n"
					+ "login_email,login_id,login_pass)\n"
					+ "values(?,?,?,?,?);";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, admins.getLoginName());
			stmt.setString(2, admins.getLoginPhoneNumber());
			stmt.setString(3, admins.getLoginEmail());
			stmt.setString(4, admins.getLoginId());
			stmt.setString(5, admins.getLoginPass());
			

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Admins admins) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Admins admins) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Admins findByLoginIdAndLoginPass(String loginId, String loginPass) throws Exception {
		Admins admin = null;
		 try (Connection con = ds.getConnection()) {
		 String sql = "SELECT * FROM admins WHERE login_id=?";
		 PreparedStatement stmt = con.prepareStatement(sql);
		 stmt.setString(1, loginId);
		 ResultSet rs = stmt.executeQuery();
		 if (rs.next()) {
		 if (BCrypt.checkpw(loginPass, rs.getString("login_pass"))) {
		 admin = mapToAdmin(rs);
		 }
		 }
		 } catch (Exception e) {
		 throw e;
		 }
		 return admin;
		 }
		 
	private Admins mapToAdmin(ResultSet rs) throws Exception {
		 Admins admin = new Admins();
		 admin.setId((Integer) rs.getObject("id"));
		 admin.setLoginId(rs.getString("login_id")); 
		 admin.setLoginPass(rs.getString("login_pass"));
		 admin.setLoginName(rs.getString("login_name"));
		 return admin;
		 } 
	}


