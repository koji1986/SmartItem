package domain;

import java.util.Date;

public class Sales {

	private Integer id;
	private Date salesDate;
	private Date salesTime;
	private Integer shopInfId;
	private Integer customerCategolyId;
	private Integer customerId;
	private Integer picId;
	private String salesNomination;
	private String salesPayment;
	private Integer courseId;
	private Integer optionId;
	private Integer staffId;
	private Integer salesCarfare;
	private Integer salesSalary;
	private Integer salesCost;
	private Integer adId;
	private Integer discountId;
	private Integer salesDiscountFee;
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

	

}
