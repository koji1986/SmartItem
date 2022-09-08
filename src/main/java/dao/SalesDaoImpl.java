package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.Ad;
import domain.Course;
import domain.Customer;
import domain.CustomerCategoly;
import domain.Discount;
import domain.Option;
import domain.Pic;
import domain.Sales;
import domain.ShopInf;
import domain.Staff;

public class SalesDaoImpl implements SalesDao {

	private DataSource ds;

	public SalesDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Sales> findAll() throws Exception {
		List<Sales> salesList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = " select sales.id,sales.sales_date,sales.sales_time,shop_inf.id,\r\n"
					+ "					 sales.shopInf_id,shop_inf.shopInf_name,sales.customerCategoly_id, customer_categoly.customer_categoly_name,\r\n"
					+ "					 sales.customer_id, customer.customer_name,sales.pic_id,  pic.pic_nameA,sales.sales_nomination,\r\n"
					+ "					 sales.sales_payment, sales.course_id, course.course_name,\r\n"
					+ "					 sales.option_id, smart_item_db.option.option_name,sales.staff_id, staff.staff_name,\r\n"
					+ "					 sales.sales_carfare,sales.sales_salary,\r\n"
					+ "					 sales.sales_cost, sales.ad_id, ad.ad_name, sales.discount_id, discount.discount_name,sales.sales_discount_fee ,\r\n"
					+ "					 sales.sales_amount,cash.cash_cost\r\n" + "					 from sales  \r\n"
					+ "					 left join shop_inf on sales.shopInf_id=shop_inf.id\r\n"
					+ "					 left join customer_categoly on sales.customerCategoly_id=customer_categoly.id\r\n"
					+ "					 left join customer on sales.customer_id =customer.id  join pic on sales.pic_id=pic.id\r\n"
					+ "					 left join course on sales.course_id=course.id\r\n"
					+ "					 left join smart_item_db.option on sales.option_id=smart_item_db.option.id\r\n"
					+ "					 left join staff on sales.staff_id=staff.id  \r\n"
					+ "					 left join ad on sales.ad_id=ad.id\r\n"
					+ "					 left join discount on sales.discount_id=discount.id\r\n"
					+ "                     left join cash on cash.sales_id=sales.id; ";
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
					+ "sales.shopInf_id, shop_inf.id, shop_inf.shopInf_name, sales.customerCategoly_id, customer_categoly.customer_categoly_name,\n"
					+ "sales.customer_id, customer.customer_name,sales.pic_id, pic.pic_nameA,sales.sales_nomination,\n"
					+ "sales.sales_payment,sales.course_id, course.course_name,\n"
					+ "sales.option_id,  smart_item_db.option.option_name,sales.staff_id,  staff.staff_name,\n"
					+ "sales.sales_carfare,sales.sales_salary,  sales.sales_cost, sales.ad_id, ad.ad_name,\n"
					+ "sales.discount_id, discount.discount_name,sales.sales_discount_fee,\n"
					+ "sales.sales_amount, cash.cash_cost  from sales\n"
					+ "left join shop_inf on sales.shopInf_id=shop_inf.id\n"
					+ "left join customer_categoly on sales.customerCategoly_id=customer_categoly.id\n"
					+ "left join customer on sales.customer_id =customer.id  join pic on sales.pic_id=pic.id\n"
					+ "left join course on sales.course_id=course.id\n"
					+ "left join smart_item_db.option on sales.option_id=smart_item_db.option.id\n"
					+ "left join staff on sales.staff_id=staff.id  left join ad on sales.ad_id=ad.id\n"
					+ "left join discount on sales.discount_id=discount.id  left join cash on sales.id=cash.sales_id where sales.id=?;";

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
					+ "sales_cost,ad_id,discount_id,sales_discount_fee,sales.sales_amount)\n"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

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
			stmt.setObject(18, sales.getSalesAmount(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Sales sales) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = " update sales set \n" + "sales_date=?, \n" + "sales_time=?,\n" + "shopInf_id=?,\n"
					+ "customerCategoly_id=?,\n" + "customer_id=?,\n" + "pic_id=?,\n" + "sales_nomination=?,\n"
					+ "sales_payment=?,\n" + "course_id=?,\n" + "option_id=?,\n" + "staff_id=?,\n"
					+ "sales_carfare=?,\n" + "sales_salary=?,\n" + "sales_cost=?,\n" + "ad_id=?,\n" + "discount_id=?,\n"
					+ "sales_discount_fee=?,sales.sales_amount=?\n" + "where id=?;";

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
			stmt.setObject(18, sales.getSalesAmount(), Types.INTEGER);
			stmt.setObject(19, sales.getId(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Sales sales) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM sales WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, sales.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<ShopInf> findAllShopInf() throws Exception {
		List<ShopInf> shopInfList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select * from shop_inf order by shop_inf.id asc;  ";
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

	private Sales mapToSales(ResultSet rs) throws Exception {
		Sales sales = new Sales();

		sales.setId((Integer) rs.getObject("id"));
		sales.setSalesDate(rs.getTimestamp("sales_date"));
		sales.setSalesTime(rs.getTimestamp("sales_time"));
		sales.setShopInfId((Integer) rs.getObject("shopInf_id"));
		sales.setShopInfName(rs.getString("shopInf_name"));
		sales.setCustomerCategolyName(rs.getString("customer_categoly_name"));
		sales.setCustomerCategolyId((Integer) rs.getObject("customerCategoly_id"));
		sales.setCustomerName(rs.getString("customer_name"));
		sales.setCustomerId((Integer) rs.getObject("customer_id"));
		sales.setPicName(rs.getString("pic_nameA"));
		sales.setPicId((Integer) rs.getObject("pic_id"));
		sales.setSalesNomination(rs.getString("sales_nomination"));
		sales.setSalesPayment(rs.getString("sales_payment"));
		sales.setCourseName(rs.getString("course_name"));
		sales.setCourseId((Integer) rs.getObject("course_id"));
		sales.setOptionName(rs.getString("option_name"));
		sales.setOptionId((Integer) rs.getObject("option_id"));
		sales.setStaffName(rs.getString("staff_name"));
		sales.setStaffId((Integer) rs.getObject("staff_id"));
		sales.setSalesAmount((Integer) rs.getObject("sales_amount"));
		sales.setSalesCarfare((Integer) rs.getObject("sales_carfare"));
		sales.setSalesSalary((Integer) rs.getObject("sales_salary"));
		sales.setSalesCost((Integer) rs.getObject("sales_cost"));
		sales.setAdName(rs.getString("ad_name"));
		sales.setAdId((Integer) rs.getObject("ad_id"));
		sales.setDiscountName(rs.getString("discount_name"));
		sales.setDiscountId((Integer) rs.getObject("discount_id"));
		sales.setSalesDiscountFee((Integer) rs.getObject("sales_discount_fee"));
		sales.setCashCost((Integer) rs.getObject("cash_cost"));

		return sales;
	}

	private ShopInf mapToShopInf(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String shopInfName = rs.getString("shopInf_name");

		return new ShopInf(id, shopInfName);
	}

	@Override
	public List<CustomerCategoly> findAllCustomerCategoly() throws Exception {
		List<CustomerCategoly> customerCategolyList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = "select* from customer_categoly order by customer_categoly.id asc; ";
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
	public List<Customer> findAllCustomer() throws Exception {
		List<Customer> customerList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select * from customer;";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				customerList.add(mapToCustomer(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return customerList;
	}

	@Override
	public List<Pic> findAllPic() throws Exception {
		List<Pic> picList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select pic.id,pic_rank.picRank_name,pic.picRank_idA, pic.pic_nameA,pic.pic_kanaA,\n"
					+ "pic_rank.picRank_name,pic.pic_nameB,pic.picRank_idB, pic.pic_kanaB,\n"
					+ "pic.pic_phone_number,pic.pic_email,pic.pic_address,\n"
					+ "pic.pic_entry_day,pic.pic_out_day,pic.pic_memo\n" + "from pic\n" + "join pic_rank\n"
					+ "on pic.picRank_idA=pic_rank.id ;";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				picList.add(mapToPic(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return picList;
	}

	@Override
	public List<Course> findAllCourse() throws Exception {
		List<Course> courseList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = "select course.id,course.shopInf_id, shop_inf.shopInf_name,course_name,\n"
					+ "course_fee,course_time,course_row\n" + "from course\n" + "join shop_inf\n"
					+ "on course.shopInf_id=shop_inf.id order by course_row asc; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				courseList.add(mapToCourse(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return courseList;
	}

	@Override
	public List<Option> findAllOption() throws Exception {
		List<Option> optionList = new ArrayList<>();

		try {
			Connection con = ds.getConnection();
			String sql = " select smart_item_db.option.id,option.shopInf_id, shop_inf.shopInf_name,\n"
					+ "smart_item_db.option.option_name,smart_item_db.option.option_fee,\n"
					+ "smart_item_db.option.option_row\n" + "from smart_item_db.option\n" + "join shop_inf\n"
					+ "on smart_item_db.option.shopInf_id=shop_inf.id order by smart_item_db.option.option_row asc;";
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
	public List<Staff> findAllStaff() throws Exception {
		List<Staff> staffList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select*from staff; ";
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
	public List<Ad> findAllAd() throws Exception {
		List<Ad> adList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select*from ad order by ad_row asc; ";
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
	public List<Discount> findAllDiscount() throws Exception {
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

	private CustomerCategoly mapToCustomerCategoly(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String customerCategolyName = rs.getString("customer_categoly_name");

		return new CustomerCategoly(id, customerCategolyName);

	}

	private Customer mapToCustomer(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String customerNo = rs.getString("customer_no");
		String customerName = rs.getString("customer_name");
		String customerKana = rs.getString("customer_kana");
		String customerPhoneNumber1 = rs.getString("customer_phone_number1");
		String customerPhoneNumber2 = rs.getString("customer_phone_number2");
		String customerPhoneNumber3 = rs.getString("customer_phone_number3");
		String customerEmail = rs.getString("customer_email");
		String customerAddress1 = rs.getString("customer_address1");
		String customerAddress2 = rs.getString("customer_address2");
		String customerCreditNumber = rs.getString("customer_credit_number");
		String customerCreditDate = rs.getString("customer_credit_date");
		String customerCreditCvv = rs.getString("customer_credit_cvv");
		String customerMemo = rs.getString("customer_memo");

		return new Customer(id, customerNo, customerName, customerKana, customerPhoneNumber1, customerPhoneNumber2,
				customerPhoneNumber3, customerEmail, customerAddress1, customerAddress2, customerCreditNumber,
				customerCreditDate, customerCreditCvv, customerMemo);

	}

	private Pic mapToPic(ResultSet rs) throws Exception {

		Pic pic = new Pic();

		pic.setId((Integer) rs.getObject("id"));
		pic.setPicRankName(rs.getString("picRank_name"));
		pic.setPicRankIdA((Integer) rs.getObject("picRank_idA"));
		pic.setPicNameA(rs.getString("pic_nameA"));
		pic.setPicKanaA(rs.getString("pic_kanaA"));
		pic.setPicRankIdB((Integer) rs.getObject("picRank_idB"));
		pic.setPicNameB(rs.getString("pic_nameB"));
		pic.setPicKanaB(rs.getString("pic_kanaB"));
		pic.setPicPhoneNumber(rs.getString("pic_phone_number"));
		pic.setPicEmail(rs.getString("pic_email"));
		pic.setPicAddress(rs.getString("pic_address"));
		pic.setPicEntryDay(rs.getDate("pic_entry_day"));
		pic.setPicOutDay(rs.getDate("pic_out_day"));
		pic.setPicMemo(rs.getString("pic_memo"));

		return pic;

	}

	private Course mapToCourse(ResultSet rs) throws Exception {

		Course course = new Course();

		course.setId((Integer) rs.getObject("id"));
		course.setShopInfName(rs.getString("shopInf_name"));
		course.setShopInfId((Integer) rs.getObject("shopInf_id"));
		course.setCourseName(rs.getString("course_name"));
		course.setCourseFee((Integer) rs.getObject("course_fee"));
		course.setCourseTime((Integer) rs.getObject("course_time"));
		course.setCourseRow((Integer) rs.getObject("course_row"));

		return course;

	}

	private Option mapToOption(ResultSet rs) throws Exception {

		Option option = new Option();

		option.setId((Integer) rs.getObject("id"));
		option.setShopInfName(rs.getString("shopInf_name"));
		option.setShopInfId((Integer) rs.getObject("shopInf_id"));
		option.setOptionName(rs.getString("option_name"));
		option.setOptionFee((Integer) rs.getObject("option_fee"));
		option.setOptionRow((Integer) rs.getObject("option_row"));

		return option;

	}

	private Staff mapToStaff(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String staffName = rs.getString("staff_name");
		Integer staffRow = (Integer) rs.getObject("staff_row");

		return new Staff(id, staffName, staffRow);

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

	private Ad mapToAd(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String adName = rs.getString("ad_name");
		Integer row = (Integer) rs.getObject("ad_row");

		return new Ad(id, adName, row);

	}

	@Override
	public List<Sales> findByDate(Date salesDate) throws Exception {
		List<Sales> salesList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = " select sales.id,sales.sales_date,sales.sales_time,  sales.shopInf_id,\r\n"
					+ "					 shop_inf.shopInf_name,  sales.customerCategoly_id,\r\n"
					+ "					 customer_categoly.customer_categoly_name,  sales.customer_id, customer.customer_name,\r\n"
					+ "					 sales.pic_id, pic.pic_nameA,sales.sales_nomination,\r\n"
					+ "					 sales.sales_payment,sales.course_id, course.course_name,  sales.option_id,\r\n"
					+ "					 smart_item_db.option.option_name,sales.staff_id, staff.staff_name,\r\n"
					+ "					 sales.sales_carfare,sales.sales_salary,  sales.sales_cost,sales.ad_id, \r\n"
					+ "					 sales.discount_id,ad.ad_name,discount.discount_name,sales.sales_discount_fee,sales.sales_amount,\r\n"
					+ "					  sales.cash_cost  from sales\r\n"
					+ "					 left join shop_inf on sales.shopInf_id=shop_inf.id\r\n"
					+ "					 left join customer_categoly on sales.customerCategoly_id=customer_categoly.id\r\n"
					+ "					 left join customer on sales.customer_id =customer.id  left join pic on sales.pic_id=pic.id\r\n"
					+ "					 left join course on sales.course_id=course.id\r\n"
					+ "					 left join smart_item_db.option on sales.option_id=smart_item_db.option.id\r\n"
					+ "					 left join staff on sales.staff_id=staff.id  left join ad on sales.ad_id=ad.id\r\n"
					+ "					 left join discount on sales.discount_id=discount.id   left join cash on sales.id = cash.sales_id\r\n"
					+ "					  where sales.sales_date =?;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, new java.sql.Date(salesDate.getTime()));
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
	public List<Sales> findByDateAd(Date salesDate) throws Exception {
		List<Sales> DateAdList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "select ad.ad_name, count(*) as ad_count from sales  \r\n" + "join ad on ad.id=sales.ad_id\r\n"
					+ "where sales_date=? group by ad_name ;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, new java.sql.Date(salesDate.getTime()));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DateAdList.add(mapToSalesAd(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return DateAdList;
	}

	private Sales mapToSalesAd(ResultSet rs) throws Exception {
		Sales sales = new Sales();

		sales.setAdName(rs.getString("ad_name"));
		Long count = rs.getLong("ad_count");
		sales.setAdCount(count.intValue());

		return sales;
	}

	@Override
	public List<Sales> findByDatePicId(Date salesDate, Integer picId) throws Exception {
		List<Sales> DatePicList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "select pic.pic_nameA,\n" + "shop_inf.shopInf_name,\n" + "customer.customer_name,\n"
					+ "course.course_name,\n" + "sales.sales_nomination,\n" + "sales.sales_amount,\n"
					+ "sales.sales_salary,\n" + "use_report.in_time,\n" + "use_report.out_time,\n"
					+ "sales.sales_time, use_report.start,\n" + "use_report.spot\n" + "from sales\n"
					+ "left join pic on pic.id = sales.pic_id\n"
					+ "left join shop_inf on shop_inf.id = sales.shopInf_id\n"
					+ "left join customer on customer.id = sales.customer_id\n"
					+ "left join course on course.id = sales.course_id\n"
					+ "left join use_report on use_report.sales_id = sales.id\n"
					+ "where sales.sales_date=? && sales.pic_id=?;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, new java.sql.Date(salesDate.getTime()));
			stmt.setObject(2, picId, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DatePicList.add(mapToSalesPic(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return DatePicList;
	}

	private Sales mapToSalesPic(ResultSet rs) throws Exception {
		Sales sales = new Sales();

		sales.setShopInfName(rs.getString("shopInf_name"));

		sales.setCustomerName(rs.getString("customer_name"));

		sales.setPicName(rs.getString("pic_nameA"));

		sales.setSalesNomination(rs.getString("sales_nomination"));

		sales.setCourseName(rs.getString("course_name"));

		sales.setSalesTime(rs.getTimestamp("sales_time"));

		sales.setSalesAmount((Integer) rs.getObject("sales_amount"));

		sales.setSalesSalary((Integer) rs.getObject("sales_salary"));

		sales.setInTime(rs.getTimestamp("in_time"));
		sales.setOutTime(rs.getTimestamp("out_time"));
		sales.setStart(rs.getTimestamp("start"));
		sales.setSpot(rs.getString("spot"));

		return sales;
	}

	@Override
	public void insertUseReport(Sales sales) throws Exception {

		try (Connection con = ds.getConnection()) {
			String sql = " insert into use_report(sales_id,pic_id,in_time,out_time,spot,start)\n"
					+ "values(?,?,?,?,?,?)\n"
					+ "ON DUPLICATE KEY UPDATE sales_id = ?\n"
					+ " ;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, sales.getId(), Types.INTEGER);
			stmt.setObject(2, sales.getPicId(), Types.INTEGER);
			stmt.setObject(3, sales.getInTime());
			stmt.setObject(4, sales.getOutTime());
			stmt.setString(5, sales.getSpot());
			stmt.setObject(6, sales.getStart());
			stmt.setObject(7, sales.getId(),Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<Sales> findByDateOderAd(Date salesDate) throws Exception {
		List<Sales> salesList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "select sales.id,sales.sales_date,sales.sales_time,  sales.shopInf_id,\n"
					+ "shop_inf.shopInf_name,  sales.customerCategoly_id,\n"
					+ "customer_categoly.customer_categoly_name,  sales.customer_id, customer.customer_name,\n"
					+ "sales.pic_id, pic.pic_nameA,sales.sales_nomination,\n"
					+ "sales.sales_payment,sales.course_id, course.course_name,  sales.option_id,\n"
					+ "smart_item_db.option.option_name,sales.staff_id, staff.staff_name,\n"
					+ "sales.sales_carfare,sales.sales_salary,  sales.sales_cost,sales.ad_id, \n"
					+ "sales.discount_id,ad.ad_name,discount.discount_name,sales.sales_discount_fee,sales.sales_amount,\n"
					+ "sales.cash_cost  from sales\n"
					+ "left join shop_inf on sales.shopInf_id=shop_inf.id\n"
					+ "left join customer_categoly on sales.customerCategoly_id=customer_categoly.id\n"
					+ "left join customer on sales.customer_id =customer.id  left join pic on sales.pic_id=pic.id\n"
					+ "left join course on sales.course_id=course.id\n"
					+ "left join smart_item_db.option on sales.option_id=smart_item_db.option.id\n"
					+ "left join staff on sales.staff_id=staff.id  left join ad on sales.ad_id=ad.id\n"
					+ "left join discount on sales.discount_id=discount.id   left join cash on sales.id = cash.sales_id\n"
					+ "where sales.sales_date =?\n"
					+ "ORDER BY sales.discount_id DESC;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, new java.sql.Date(salesDate.getTime()));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				salesList.add(mapToSales(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return salesList;
	}




}
