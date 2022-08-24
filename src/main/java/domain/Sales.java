package domain;

import java.util.Date;

public class Sales {

	private Integer id;
	private Date salesDate;
	private Date salesTime;
	private Integer shopInfId;
	private String shopInfName;
	private Integer customerCategolyId;
	private String customerCategolyName;
	private Integer customerId;
	private String customerName;
	private Integer picId;
	private String picName;
	private String salesNomination;
	private String salesPayment;
	private Integer courseId;
	private String courseName;
	private Integer optionId;
	private String optionName;
	private Integer staffId;
	private String staffName;
	private Integer salesCarfare;
	private Integer salesSalary;
	private Integer salesCost;
	private Integer adId;
	private String adName;
	private Integer discountId;
	private String discountName;
	private Integer salesDiscountFee;
	private Integer salesAmount;
	private Integer cashCost;
	private Integer cashId;

	public Sales(Integer id, Date salesDate, Date salesTime, String shopInfName, String customerCategolyName,
			String customerName, String picName, String salesNomination, String salesPayment, String courseName,
			String optionName, String staffName, Integer salesCarfare, Integer salesSalary, Integer salesCost,
			String adName, String discountName, Integer salesDiscountFee) {
		super();
		this.id = id;
		this.salesDate = salesDate;
		this.salesTime = salesTime;
		this.shopInfName = shopInfName;
		this.customerCategolyName = customerCategolyName;
		this.customerName = customerName;
		this.picName = picName;
		this.salesNomination = salesNomination;
		this.salesPayment = salesPayment;
		this.courseName = courseName;
		this.optionName = optionName;
		this.staffName = staffName;
		this.salesCarfare = salesCarfare;
		this.salesSalary = salesSalary;
		this.salesCost = salesCost;
		this.adName = adName;
		this.discountName = discountName;
		this.salesDiscountFee = salesDiscountFee;
	}

	public Sales(Integer id, Date salesDate, Date salesTime, Integer shopInfId, Integer customerCategolyId,
			Integer customerId, Integer picId, String salesNomination, String salesPayment, Integer courseId,
			Integer optionId, Integer staffId, Integer salesCarfare, Integer salesSalary, Integer salesCost,
			Integer adId, Integer discountId, Integer salesDiscountFee) {
		super();
		this.id = id;
		this.salesDate = salesDate;
		this.salesTime = salesTime;
		this.shopInfId = shopInfId;
		this.customerCategolyId = customerCategolyId;
		this.customerId = customerId;
		this.picId = picId;
		this.salesNomination = salesNomination;
		this.salesPayment = salesPayment;
		this.courseId = courseId;
		this.optionId = optionId;
		this.staffId = staffId;
		this.salesCarfare = salesCarfare;
		this.salesSalary = salesSalary;
		this.salesCost = salesCost;
		this.adId = adId;
		this.discountId = discountId;
		this.salesDiscountFee = salesDiscountFee;
	}

	public Sales() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public Date getSalesTime() {
		return salesTime;
	}

	public void setSalesTime(Date salesTime) {
		this.salesTime = salesTime;
	}

	public Integer getShopInfId() {
		return shopInfId;
	}

	public void setShopInfId(Integer shopInfId) {
		this.shopInfId = shopInfId;
	}

	public Integer getCustomerCategolyId() {
		return customerCategolyId;
	}

	public void setCustomerCategolyId(Integer customerCategolyId) {
		this.customerCategolyId = customerCategolyId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public String getSalesNomination() {
		return salesNomination;
	}

	public void setSalesNomination(String salesNomination) {
		this.salesNomination = salesNomination;
	}

	public String getSalesPayment() {
		return salesPayment;
	}

	public void setSalesPayment(String salesPayment) {
		this.salesPayment = salesPayment;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getSalesCarfare() {
		return salesCarfare;
	}

	public void setSalesCarfare(Integer salesCarfare) {
		this.salesCarfare = salesCarfare;
	}

	public Integer getSalesSalary() {
		return salesSalary;
	}

	public void setSalesSalary(Integer salesSalary) {
		this.salesSalary = salesSalary;
	}

	public Integer getSalesCost() {
		return salesCost;
	}

	public void setSalesCost(Integer salesCost) {
		this.salesCost = salesCost;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public Integer getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	public Integer getSalesDiscountFee() {
		return salesDiscountFee;
	}

	public void setSalesDiscountFee(Integer salesDiscountFee) {
		this.salesDiscountFee = salesDiscountFee;
	}

	public String getShopInfName() {
		return shopInfName;
	}

	public void setShopInfName(String shopInfName) {
		this.shopInfName = shopInfName;
	}

	public String getCustomerCategolyName() {
		return customerCategolyName;
	}

	public void setCustomerCategolyName(String customerCategolyName) {
		this.customerCategolyName = customerCategolyName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public Integer getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(Integer salesAmount) {
		this.salesAmount = salesAmount;
	}

	public Integer getCashCost() {
		return cashCost;
	}

	public void setCashCost(Integer cashCost) {
		this.cashCost = cashCost;
	}

	public Integer getCashId() {
		return cashId;
	}

	public void setCashId(Integer cashId) {
		this.cashId = cashId;
	}

}
