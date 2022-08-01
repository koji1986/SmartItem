package domain;

public class ShopInf {

	private Integer id;
	private String shopInfName;

	public ShopInf(Integer id, String shopInfName) {
		super();
		this.id = id;
		this.shopInfName = shopInfName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopInfName() {
		return shopInfName;
	}

	public void setShopInfName(String shopInfName) {
		this.shopInfName = shopInfName;
	}

}
