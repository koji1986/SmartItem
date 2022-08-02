package dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Sales;

public class SalesDaoImpl implements SalesDao {

	private DataSource ds;

	public SalesDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Sales> findAll() throws Exception {
		List<Sales> salesList = new ArrayList<>();
		
		try(Connection con =ds.getConnection()){
			String sql = " select "
					+ " sales.id, salse.sales_date, sales.sales_time, "
					+ " shop_inf.shopInf_name, "
					+ " customer_categoly.customer_categoly_name, "
					+ " cutomer.customer_name, pic.pic_name, "
					+ " sales.sales_nomination"
					
		}
	}

	@Override
	public Sales findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Sales sales) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Sales sales) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Sales sales) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
