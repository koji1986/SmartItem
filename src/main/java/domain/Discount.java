package domain;

public class Discount {

	private Integer id;
	private Integer shopInfId;
	private String discountName;
	private Integer discountFee;
	private Integer discountRow;

	public Discount(Integer id, Integer shopInfId, String discountName, Integer discountFee, Integer discountRow) {
		super();
		this.id = id;
		this.shopInfId = shopInfId;
		this.discountName = discountName;
		this.discountFee = discountFee;
		this.discountRow = discountRow;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopInfId() {
		return shopInfId;
	}

	public void setShopInfId(Integer shopInfId) {
		this.shopInfId = shopInfId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public Integer getDiscountFee() {
		return discountFee;
	}

	public void setDiscountFee(Integer discountFee) {
		this.discountFee = discountFee;
	}

	public Integer getDiscountRow() {
		return discountRow;
	}

	public void setDiscountRow(Integer discountRow) {
		this.discountRow = discountRow;
	}

}
