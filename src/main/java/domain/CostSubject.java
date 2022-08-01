package domain;

public class CostSubject {

	private Integer id;
	private String costSubjectName;

	public CostSubject(Integer id, String costSubjectName) {
		super();
		this.id = id;
		this.costSubjectName = costSubjectName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCostSubjectName() {
		return costSubjectName;
	}

	public void setCostSubjectName(String costSubjectName) {
		this.costSubjectName = costSubjectName;
	}

}
