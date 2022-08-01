package domain;

import java.util.Date;

public class Sales {

	private Integer id;
	private Date salseDate;
	private Date salseTime;
	private Integer shopInfId;
	private Integer customerCategolyId;
	private Integer membersId;
	private Integer picId;
	private String salseNomination;
	private String salesPayment;
	private Integer courseId;
	private Integer optionId;
	private Integer staffId;
	private Integer salseCarfare;
	private Integer salesSalary;
	private Integer salesCost;
	private Integer adId;
	private Integer discountId;
	private Integer salesDiscountFee;

	public Sales(Integer id, Date salseDate, Date salseTime, Integer shopInfId, Integer customerCategolyId,
			Integer membersId, Integer picId, String salseNomination, String salesPayment, Integer courseId,
			Integer optionId, Integer staffId, Integer salseCarfare, Integer salesSalary, Integer salesCost,
			Integer adId, Integer discountId, Integer salesDiscountFee) {
		super();
		this.id = id;
		this.salseDate = salseDate;
		this.salseTime = salseTime;
		this.shopInfId = shopInfId;
		this.customerCategolyId = customerCategolyId;
		this.membersId = membersId;
		this.picId = picId;
		this.salseNomination = salseNomination;
		this.salesPayment = salesPayment;
		this.courseId = courseId;
		this.optionId = optionId;
		this.staffId = staffId;
		this.salseCarfare = salseCarfare;
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

	public Date getSalseDate() {
		return salseDate;
	}

	public void setSalseDate(Date salseDate) {
		this.salseDate = salseDate;
	}

	public Date getSalseTime() {
		return salseTime;
	}

	public void setSalseTime(Date salseTime) {
		this.salseTime = salseTime;
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

	public Integer getMembersId() {
		return membersId;
	}

	public void setMembersId(Integer membersId) {
		this.membersId = membersId;
	}

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public String getSalseNomination() {
		return salseNomination;
	}

	public void setSalseNomination(String salseNomination) {
		this.salseNomination = salseNomination;
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

	public Integer getSalseCarfare() {
		return salseCarfare;
	}

	public void setSalseCarfare(Integer salseCarfare) {
		this.salseCarfare = salseCarfare;
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
