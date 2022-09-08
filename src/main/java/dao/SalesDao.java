package dao;

import java.util.Date;
import java.util.List;

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

public interface SalesDao {

	List<Sales> findAll() throws Exception;
	
	List<Sales> findByDate(Date salesDate) throws Exception;

	List<Sales> findByDateOderAd(Date salesDate) throws Exception;
	
	List<Sales> findByDateAd(Date salesDate) throws Exception;
	
	List<Sales> findByDatePicId(Date salesDate,Integer picId) throws Exception;
	

	Sales findById(Integer id) throws Exception;


	void insert(Sales sales) throws Exception;
	
	void insertUseReport(Sales sales) throws Exception;

	void update(Sales sales) throws Exception;

	void delete(Sales sales) throws Exception;
	
	List<ShopInf> findAllShopInf() throws Exception;
	
	List<CustomerCategoly> findAllCustomerCategoly() throws Exception;
	List<Customer> findAllCustomer() throws Exception;
	List<Pic> findAllPic() throws Exception;
	List<Course> findAllCourse() throws Exception;
	List<Option> findAllOption() throws Exception;
	List<Staff> findAllStaff() throws Exception;
	List<Ad> findAllAd() throws Exception;
	List<Discount> findAllDiscount() throws Exception;
	

	
	

}
