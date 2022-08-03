package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
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

		try (Connection con = ds.getConnection()) {
			String sql = " select sales.id,sales.sales_date,sales.sales_time,\n"
					+ "shop_inf.shopInf_name,customer_categoly.customer_categoly_name,\n"
					+ "customer.customer_name,pic.pic_nameA,sales.sales_nomination,\n"
					+ "sales.sales_payment,course.course_name,\n"
					+ "smart_item_db.option.option_name,staff.staff_name,\n"
					+ "sales.sales_carfare,sales.sales_salary,\n"
					+ "sales.sales_cost,ad.ad_name,discount.discount_name,sales.sales_discount_fee\n" + "from sales\n"
					+ "join shop_inf on sales.shopInf_id=shop_inf.id\n"
					+ "join customer_categoly on sales.customerCategoly_id=customer_categoly.id\n"
					+ "join customer on sales.customer_id =customer.id\n" + "join pic on sales.pic_id=pic.id\n"
					+ "join course on sales.course_id=course.id\n"
					+ "join smart_item_db.option on sales.option_id=smart_item_db.option.id\n"
					+ "join staff on sales.staff_id=staff.id\n" + "join ad on sales.ad_id=ad.id\n"
					+ "join discount on sales.discount_id=discount.id; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				salesList.add(mapToSales(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return salesList;

	}

	@Override
	public Sales findById(Integer id) throws Exception {
		Sales sales = new Sales();
		try (Connection con = ds.getConnection()) {
		String sql = " select sales.id,sales.sales_date,sales.sales_time,\n"
				+ "shop_inf.shopInf_name,customer_categoly.customer_categoly_name,\n"
				+ "customer.customer_name,pic.pic_nameA,sales.sales_nomination,\n"
				+ "sales.sales_payment,course.course_name,\n"
				+ "smart_item_db.option.option_name,staff.staff_name,\n"
				+ "sales.sales_carfare,sales.sales_salary,\n"
				+ "sales.sales_cost,ad.ad_name,discount.discount_name,sales.sales_discount_fee\n"
				+ "from sales\n"
				+ "join shop_inf on sales.shopInf_id=shop_inf.id\n"
				+ "join customer_categoly on sales.customerCategoly_id=customer_categoly.id\n"
				+ "join customer on sales.customer_id =customer.id\n"
				+ "join pic on sales.pic_id=pic.id\n"
				+ "join course on sales.course_id=course.id\n"
				+ "join smart_item_db.option on sales.option_id=smart_item_db.option.id\n"
				+ "join staff on sales.staff_id=staff.id\n"
				+ "join ad on sales.ad_id=ad.id\n"
				+ "join discount on sales.discount_id=discount.id "
				+ " where sales.id=?;";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setObject(1, id, Types.INTEGER);
		ResultSet rs = stmt.executeQuery();
		if(rs.next() == true) {
		sales = mapToSales(rs);
		}
		} catch (Exception e) {
		throw e;
		}
		return sales;
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
	private Sales mapToSales(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		Date salesDate = rs.getTimestamp("sales_date");
		Date salesTime = rs.getTimestamp("sales_time");
		Integer shopInfId = (Integer) rs.getObject("shopInf_name");
		Integer customerCategolyId = (Integer) rs.getObject("customerCategoky_id");
		Integer customerId = (Integer) rs.getObject("customer_id");
		Integer picId = (Integer) rs.getObject("pic_id");
		String salesNomination = rs.getString("sales_nomination");
		String salesPayment = rs.getString("sales_payment");
		Integer courseId = (Integer) rs.getObject("course_id");
		Integer optionId = (Integer) rs.getObject("option_id");
		Integer staffId = (Integer) rs.getObject("staff_id");
		Integer salesCarfare = (Integer) rs.getObject("sales_carfare");
		Integer salesSalary = (Integer) rs.getObject("sales_salary");
		Integer salesCost = (Integer) rs.getObject("sales_cost");
		Integer adId = (Integer) rs.getObject("ad_id");
		Integer discountId = (Integer) rs.getObject("discount_id");
		Integer salesDiscountId = (Integer) rs.getObject("sales_discount_fee");
	
		return new Sales(id, salesDate, salesTime, shopInfId, customerCategolyId, customerId, picId,
				salesNomination,salesPayment,courseId,optionId,staffId,salesCarfare,salesSalary,
				salesCost,adId,discountId,salesDiscountId);
		}
	
	
}
