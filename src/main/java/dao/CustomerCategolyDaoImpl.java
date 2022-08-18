package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.CustomerCategoly;

public class CustomerCategolyDaoImpl implements CustomerCategolyDao {

	private DataSource ds;

	public CustomerCategolyDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<CustomerCategoly> findAll() throws Exception {
		List<CustomerCategoly> customerCategolyList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = "select* from customer_categoly; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				customerCategolyList.add(mapToCustomerCategoly(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return customerCategolyList;

	}

	@Override
	public CustomerCategoly findById(Integer id) throws Exception {
		CustomerCategoly customerCategoly = new CustomerCategoly();
		try {
			Connection con = ds.getConnection();
			String sql = " select customer_categoly_name from customer_categoly where id= ?;  ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				customerCategoly = mapToCustomerCategoly(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return customerCategoly;
	}

	@Override
	public void insert(CustomerCategoly customerCategoly) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(CustomerCategoly customerCategoly) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(CustomerCategoly customerCategoly) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private CustomerCategoly mapToCustomerCategoly(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String customerCategolyName = rs.getString("customer_categoly_name");

		return new CustomerCategoly(id, customerCategolyName);

	}

}
