package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Ad;

public class AdDaoImpl implements AdDao {

	private DataSource ds;

	public AdDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Ad> findAll() throws Exception {
		List<Ad> adList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select*from ad; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				adList.add(mapToAd(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return adList;
	}

	@Override
	public Ad findById(Integer id) throws Exception {
		Ad ad = new Ad();
		try {
			Connection con = ds.getConnection();
			String sql = " select*from ad  where ad.id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				ad = mapToAd(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return ad;
	}

	@Override
	public void insert(Ad ad) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Ad ad) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = " update ad set ad_name=?,ad_row=? where ad.id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, ad.getAdName());

			stmt.setObject(2, ad.getAdRow(), Types.INTEGER);
			stmt.setObject(3, ad.getId(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Ad ad) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Ad mapToAd(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String adName = rs.getString("ad_name");
		Integer row = (Integer) rs.getObject("ad_row");

		return new Ad(id, adName, row);

	}

}
