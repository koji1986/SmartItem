package domain;

import java.util.Date;

public class Cost {

	private Integer id;
	private Date costDate;
	private Integer staffId;
	private String staffName;
	private Integer shopNameId;
	private String shopInfName;
	private String costDestination;
	private Integer costSubjectId;
	private String costSubjectName;
	private Integer costFee;
	private String costDetail;

	public Cost() {
	};

	public Cost(Integer id, Date costDate, String staffName, String shopInfName, String costDestination,
			String costSubjectName, Integer costFee, String costDetail) {
		super();
		this.id = id;
		this.costDate = costDate;
		this.staffName = staffName;
		this.shopInfName = shopInfName;
		this.costDestination = costDestination;
		this.costSubjectName = costSubjectName;
		this.costFee = costFee;
		this.costDetail = costDetail;
	}

	public Cost(Integer id, Date costDate, Integer staffId, Integer shopNameId, String costDestination,
			Integer costSubjectId, Integer costFee, String costDetail) {
		super();
		this.id = id;
		this.costDate = costDate;
		this.staffId = staffId;
		this.shopNameId = shopNameId;
		this.costDestination = costDestination;
		this.costSubjectId = costSubjectId;
		this.costFee = costFee;
		this.costDetail = costDetail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCostDate() {
		return costDate;
	}

	public void setCostDate(Date costDate) {
		this.costDate = costDate;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getShopNameId() {
		return shopNameId;
	}

	public void setShopNameId(Integer shopNameId) {
		this.shopNameId = shopNameId;
	}

	public String getCostDestination() {
		return costDestination;
	}

	public void setCostDestination(String costDestination) {
		this.costDestination = costDestination;
	}

	public Integer getCostSubjectId() {
		return costSubjectId;
	}

	public void setCostSubjectId(Integer costSubjectId) {
		this.costSubjectId = costSubjectId;
	}

	public Integer getCostFee() {
		return costFee;
	}

	public void setCostFee(Integer costFee) {
		this.costFee = costFee;
	}

	public String getCostDetail() {
		return costDetail;
	}

	public void setCostDetail(String costDetail) {
		this.costDetail = costDetail;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getShopInfName() {
		return shopInfName;
	}

	public void setShopInfName(String shopInfName) {
		this.shopInfName = shopInfName;
	}

	public String getCostSubjectName() {
		return costSubjectName;
	}

	public void setCostSubjectName(String costSubjectName) {
		this.costSubjectName = costSubjectName;
	}

}
