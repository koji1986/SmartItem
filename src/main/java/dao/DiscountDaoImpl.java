package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Discount;

public class DiscountDaoImpl implements DiscountDao {

	private DataSource ds;

	public DiscountDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Discount> findAll() throws Exception {
		List<Discount> discountList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select discount.id, discount.shopInf_id, shop_inf.shopInf_name,discount.discount_name,\n"
					+ "discount.discount_fee,discount_row\n" + "from discount\n"
					+ "join shop_inf on discount.shopInf_id=shop_inf.id; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				discountList.add(mapToDiscount(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return discountList;
	}

	@Override
	public Discount findById(Integer id) throws Exception {
		Discount discount = new Discount();
		try {
			Connection con = ds.getConnection();
			String sql = " select discount.id, discount.shopInf_id, shop_inf.shopInf_name,discount.discount_name,\n"
					+ "discount.discount_fee,discount_row\n" + "from discount\n"
					+ "join shop_inf on discount.shopInf_id=shop_inf.id; where discount.id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				discount = mapToDiscount(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return discount;
	}

	@Override
	public void insert(Discount discount) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Discount discount) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = "   update discount set shopInf_id=?,discount_name=?,discount_fee=?,discount_row=? where id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, discount.getShopInfId(), Types.INTEGER);
			stmt.setString(2, discount.getDiscountName());
			stmt.setObject(3, discount.getDiscountFee(), Types.INTEGER);
			stmt.setObject(4, discount.getDiscountRow(), Types.INTEGER);
			stmt.setObject(5, discount.getId(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Discount discount) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Discount mapToDiscount(ResultSet rs) throws Exception {

		Discount discount = new Discount();

		discount.setId((Integer) rs.getObject("id"));
		discount.setShopInfName(rs.getString("shopInf_name"));
		discount.setShopInfId((Integer) rs.getObject("shopInf_id"));
		discount.setDiscountName(rs.getString("discount_name"));
		discount.setDiscountFee((Integer) rs.getObject("discount_fee"));
		discount.setDiscountRow((Integer) rs.getObject("discount_row"));

		return discount;

	}
}
