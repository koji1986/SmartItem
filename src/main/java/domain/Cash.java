package domain;

import java.util.Date;

public class Cash {

	private Integer id;
	private Date cashDate;
	private Integer cashChange;
	private Integer staffId;
	private Integer cashCost;

	public Cash(Integer id, Date cashDate, Integer cashChange, Integer staffId, Integer cashCost) {
		super();
		this.id = id;
		this.cashDate = cashDate;
		this.cashChange = cashChange;
		this.staffId = staffId;
		this.cashCost = cashCost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCashDate() {
		return cashDate;
	}

	public void setCashDate(Date cashDate) {
		this.cashDate = cashDate;
	}

	public Integer getCashChange() {
		return cashChange;
	}

	public void setCashChange(Integer cashChange) {
		this.cashChange = cashChange;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getCashCost() {
		return cashCost;
	}

	public void setCashCost(Integer cashCost) {
		this.cashCost = cashCost;
	}

}
