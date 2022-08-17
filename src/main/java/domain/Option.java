package domain;

public class Option {

	private Integer id;
	private Integer shopInfId;
	private String shopInfName;
	private String optionName;
	private Integer optionFee;
	private Integer optionRow;

	public Option() {};
	
	public Option(Integer id, String shopInfName, String optionName, Integer optionFee, Integer optionRow) {
		super();
		this.id = id;
		this.shopInfName = shopInfName;
		this.optionName = optionName;
		this.optionFee = optionFee;
		this.optionRow = optionRow;
	}

	public Option(Integer id, Integer shopInfId, String optionName, Integer optionFee, Integer optionRow) {
		super();
		this.id = id;
		this.shopInfId = shopInfId;
		this.optionName = optionName;
		this.optionFee = optionFee;
		this.optionRow = optionRow;
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

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Integer getOptionFee() {
		return optionFee;
	}

	public void setOptionFee(Integer optionFee) {
		this.optionFee = optionFee;
	}

	public Integer getOptionRow() {
		return optionRow;
	}

	public void setOptionRow(Integer optionRow) {
		this.optionRow = optionRow;
	}

	public String getShopInfName() {
		return shopInfName;
	}

	public void setShopInfName(String shopInfName) {
		this.shopInfName = shopInfName;
	}

}
