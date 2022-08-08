package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private DataSource ds;

	public CustomerDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Customer> findAll() throws Exception {

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
	public Customer findById(Integer id) throws Exception {

		Customer customer = new Customer();
		try {
			Connection con = ds.getConnection();
			String sql = " select * from customer where id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				customer = mapToCustomer(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return customer;

	}

	@Override
	public void insert(Customer customer) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = " insert into customer(customer_no,customer_name,customer_kana,\n"
					+ "customer_phone_number1,customer_phone_number2,customer_phone_number3,\n"
					+ "customer_email,customer_address1,customer_address2,\n"
					+ "customer_credit_number,customer_credit_date,customer_credit_cvv,\n"
					+ "customer_memo) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getCustomerNo());
			stmt.setString(2, customer.getCustomerName());
			stmt.setString(3, customer.getCustomerKana());
			stmt.setString(4, customer.getCustomerPhoneNumber1());
			stmt.setString(5, customer.getCustomerPhoneNumber2());
			stmt.setString(6, customer.getCustomerPhoneNumber3());
			stmt.setString(7, customer.getCustomerEmail());
			stmt.setString(8, customer.getCustomerAddress1());
			stmt.setString(9, customer.getCustomerAddress2());
			stmt.setString(10, customer.getCustomerCreditNumber());
			stmt.setString(11, customer.getCustomerCreditDate());
			stmt.setString(12, customer.getCustomerCreditCvv());
			stmt.setString(13, customer.getCustomerMemo());

			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Customer customer) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = " update customer set \n" + "customer_no=?,\n" + "customer_name=?,\n" + "customer_kana=?,\n"
					+ "customer_phone_number1=?,\n" + "customer_phone_number2=?,\n" + "customer_phone_number3=?,\n"
					+ "customer_email=?,\n" + "customer_address1=?,\n" + "customer_address2=?,\n"
					+ "customer_credit_number=?,\n" + "customer_credit_date=?,\n" + "customer_credit_cvv=?,\n"
					+ "customer_memo=?\n" + "where id= ?;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getCustomerNo());
			stmt.setString(2, customer.getCustomerName());
			stmt.setString(3, customer.getCustomerKana());
			stmt.setString(4, customer.getCustomerPhoneNumber1());
			stmt.setString(5, customer.getCustomerPhoneNumber2());
			stmt.setString(6, customer.getCustomerPhoneNumber3());
			stmt.setString(7, customer.getCustomerEmail());
			stmt.setString(8, customer.getCustomerAddress1());
			stmt.setString(9, customer.getCustomerAddress2());
			stmt.setObject(10, customer.getCustomerCreditNumber(), Types.INTEGER);
			stmt.setString(11, customer.getCustomerCreditDate());
			stmt.setObject(12, customer.getCustomerCreditCvv(), Types.INTEGER);
			stmt.setString(13, customer.getCustomerMemo());
			stmt.setObject(14, customer.getId(), Types.INTEGER);

			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Customer customer) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

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

}
