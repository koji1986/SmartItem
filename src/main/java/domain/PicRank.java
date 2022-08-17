package domain;

public class PicRank {

	private Integer id;
	private Integer shopInfId;
	private String shopInfName;
	private String picRankName;
	private Integer picRankFee;
	private Integer picRankRow;

	public PicRank() {
		super();
	}

	public PicRank(Integer id, String shopInfName, String picRankName, Integer picRankFee, Integer picRankRow) {
		super();
		this.id = id;
		this.shopInfName = shopInfName;
		this.picRankName = picRankName;
		this.picRankFee = picRankFee;
		this.picRankRow = picRankRow;
	}

	public PicRank(Integer id, Integer shopInfId, String picRankName, Integer picRankFee, Integer picRankRow) {
		super();
		this.id = id;
		this.shopInfId = shopInfId;
		this.picRankName = picRankName;
		this.picRankFee = picRankFee;
		this.picRankRow = picRankRow;
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

	public String getPicRankName() {
		return picRankName;
	}

	public void setPicRankName(String picRankName) {
		this.picRankName = picRankName;
	}

	public Integer getPicRankFee() {
		return picRankFee;
	}

	public void setPicRankFee(Integer picRankFee) {
		this.picRankFee = picRankFee;
	}

	public Integer getPicRankRow() {
		return picRankRow;
	}

	public void setPicRankRow(Integer picRankRow) {
		this.picRankRow = picRankRow;
	}

	public String getShopInfName() {
		return shopInfName;
	}

	public void setShopInfName(String shopInfName) {
		this.shopInfName = shopInfName;
	}

}
