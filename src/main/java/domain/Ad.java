package domain;

public class Ad {

	private Integer id;
	private String adName;
	private Integer adRow;

	public Ad() {};
	
	public Ad(Integer id, String adName, Integer adRow) {
		super();
		this.id = id;
		this.adName = adName;
		this.adRow = adRow;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public Integer getAdRow() {
		return adRow;
	}

	public void setAdRow(Integer adRow) {
		this.adRow = adRow;
	}

}
