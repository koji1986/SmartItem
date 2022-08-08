package domain;

public class Course {
	
	private Integer  id;
	private Integer  shopInfId;
	private String shopInfName;
	private String  courseName;
	private Integer  courseFee;
	private Integer  courseTime;
	private Integer  courseRow;
	
	public Course() {};
	
	
	
	
	public Course(Integer id, String shopInfName, String courseName, Integer courseFee, Integer courseTime,
			Integer courseRow) {
		super();
		this.id = id;
		this.shopInfName = shopInfName;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseTime = courseTime;
		this.courseRow = courseRow;
	}




	public Course(Integer id, Integer shopInfId, String courseName, Integer courseFee, Integer courseTime,
			Integer courseRow) {
		super();
		this.id = id;
		this.shopInfId = shopInfId;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseTime = courseTime;
		this.courseRow = courseRow;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(Integer courseFee) {
		this.courseFee = courseFee;
	}
	public Integer getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(Integer courseTime) {
		this.courseTime = courseTime;
	}
	public Integer getCourseRow() {
		return courseRow;
	}
	public void setCourseRow(Integer courseRow) {
		this.courseRow = courseRow;
	}




	public String getShopInfName() {
		return shopInfName;
	}




	public void setShopInfName(String shopInfName) {
		this.shopInfName = shopInfName;
	}

	
	
	
}
