package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Option;

public class OptionDaoImpl implements OptionDao {

	private DataSource ds;

	public OptionDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Option> findAll() throws Exception {
		List<Option> optionList = new ArrayList<>();

		try {
			Connection con = ds.getConnection();
			String sql = " select smart_item_db.option.id,shop_inf.shopInf_name,\n"
					+ "smart_item_db.option.option_name,smart_item_db.option.option_fee,\n"
					+ "smart_item_db.option.option_row\n" + "from smart_item_db.option\n" + "join shop_inf\n"
					+ "on smart_item_db.option.shopInf_id=shop_inf.id;";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				optionList.add(mapToOption(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return optionList;

	}

	@Override
	public Option findById(Integer id) throws Exception {

		Option option = new Option();
		try {
			Connection con = ds.getConnection();
			String sql = " select smart_item_db.option.id,shop_inf.shopInf_name,\n"
					+ "smart_item_db.option.option_name,smart_item_db.option.option_fee,\n"
					+ "smart_item_db.option.option_row\n" + "from smart_item_db.option\n" + "join shop_inf\n"
					+ "on smart_item_db.option.shopInf_id=shop_inf.id" + " where option.id = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				option = mapToOption(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return option;
	}

	@Override
	public void insert(Option option) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Option option) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = " update smart_item_db.option set shopInf_id=?,option_name=?,option_fee=? , option_row=? where option.id=?; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, option.getShopInfId(), Types.INTEGER);
			stmt.setString(2, option.getOptionName());
			stmt.setObject(3, option.getOptionFee(), Types.INTEGER);
			stmt.setObject(4, option.getOptionRow(), Types.INTEGER);
			stmt.setObject(5, option.getId(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Option option) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Option mapToOption(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String shopName = rs.getString("shopInf_name");
		String optionName = rs.getString("option_name");
		Integer optionFee = (Integer) rs.getObject("option_fee");
		Integer optionRow = (Integer) rs.getObject("option_row");

		return new Option(id, shopName, optionName, optionFee, optionRow);

	}

}
