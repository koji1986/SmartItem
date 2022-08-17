package domain;

public class Staff {

	private Integer id;
	private String staffName;
	private Integer staffRow;

	
	public Staff() {};
	
	public Staff(Integer id, String staffName, Integer staffRow) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.staffRow = staffRow;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getStaffRow() {
		return staffRow;
	}

	public void setStaffRow(Integer staffRow) {
		this.staffRow = staffRow;
	}

}
