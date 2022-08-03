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
					+ "sales.sales_cost,ad.ad_name,discount.discount_name,sales.sales_discount_fee\n" + "from sales\n"
					+ "join shop_inf on sales.shopInf_id=shop_inf.id\n"
					+ "join customer_categoly on sales.customerCategoly_id=customer_categoly.id\n"
					+ "join customer on sales.customer_id =customer.id\n" + "join pic on sales.pic_id=pic.id\n"
					+ "join course on sales.course_id=course.id\n"
					+ "join smart_item_db.option on sales.option_id=smart_item_db.option.id\n"
					+ "join staff on sales.staff_id=staff.id\n" + "join ad on sales.ad_id=ad.id\n"
					+ "join discount on sales.discount_id=discount.id " + " where sales.id=?;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				sales = mapToSales(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return sales;
	}

	@Override
	public void insert(Sales sales) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = " insert into sales(sales_date,sales_time,shopInf_id,\n"
					+ "customerCategoly_id,customer_id,pic_id,sales_nomination,sales_payment,\n"
					+ "course_id,option_id,staff_id,sales_carfare,sales_salary,\n"
					+ "sales_cost,ad_id,discount_id,sales_discount_fee)\n"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, sales.getSalesDate());
			stmt.setObject(2, sales.getSalesTime());
			stmt.setObject(3, sales.getShopInfId(), Types.INTEGER);
			stmt.setObject(4, sales.getCustomerCategolyId(), Types.INTEGER);
			stmt.setObject(5, sales.getCustomerId(), Types.INTEGER);
			stmt.setObject(6, sales.getPicId(), Types.INTEGER);
			stmt.setString(7, sales.getSalesNomination());
			stmt.setString(8, sales.getSalesPayment());
			stmt.setObject(9, sales.getCourseId(), Types.INTEGER);
			stmt.setObject(10, sales.getOptionId(), Types.INTEGER);
			stmt.setObject(11, sales.getStaffId(), Types.INTEGER);
			stmt.setObject(12, sales.getSalesCarfare(), Types.INTEGER);
			stmt.setObject(13, sales.getSalesSalary(), Types.INTEGER);
			stmt.setObject(14, sales.getSalesCost(), Types.INTEGER);
			stmt.setObject(15, sales.getAdId(), Types.INTEGER);
			stmt.setObject(16, sales.getDiscountId(), Types.INTEGER);
			stmt.setObject(17, sales.getSalesDiscountFee(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
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
		String shopInfName = rs.getString("shopInf_name");
		String customerCategolyName = rs.getString("customer_categoly_name");
		String customerName = rs.getString("customer_name");
		String picName = rs.getString("pic_nameA");
		String salesNomination = rs.getString("sales_nomination");
		String salesPayment = rs.getString("sales_payment");
		String courseName = rs.getString("course_name");
		String optionName = rs.getString("option_name");
		String staffName = rs.getString("staff_name");
		Integer salesCarfare = (Integer) rs.getObject("sales_carfare");
		Integer salesSalary = (Integer) rs.getObject("sales_salary");
		Integer salesCost = (Integer) rs.getObject("sales_cost");
		String adName = rs.getString("ad_name");
		String discountName = rs.getString("discount_name");
		Integer salesDiscountId = (Integer) rs.getObject("sales_discount_fee");

		return new Sales(id, salesDate, salesTime, shopInfName, customerCategolyName, customerName, picName,
				salesNomination, salesPayment, courseName, optionName, staffName, salesCarfare, salesSalary, salesCost,
				adName, discountName, salesDiscountId);
	}

}
