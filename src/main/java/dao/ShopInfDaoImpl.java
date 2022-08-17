package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.ShopInf;

public class ShopInfDaoImpl implements ShopInfDao {

	private DataSource ds;

	public ShopInfDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<ShopInf> findAll() throws Exception {
		List<ShopInf> shopInfList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select * from shop_inf;  ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				shopInfList.add(mapToShopInf(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return shopInfList;
	}

	@Override
	public ShopInf findById(Integer id) throws Exception {
		ShopInf shopInf = new ShopInf();
		try {
			Connection con = ds.getConnection();
			String sql = "   select shopInf_name from shop_inf where id=?;;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				shopInf = mapToShopInf(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return shopInf;
	}

	@Override
	public void insert(ShopInf shopInf) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(ShopInf shopInf) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(ShopInf shopInf) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private ShopInf mapToShopInf(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String shopInfName = rs.getString("shopInf_name");

		return new ShopInf(id, shopInfName);

	}

}
