package domain;

public class Admins {
	
	private  Integer id; 
	private  String loginName; 
	private  String loginPhoneNumber; 
	private  String loginEmail; 
	private  String loginId; 
	private  String loginPass; 
	private  String loginPass2;
	
	public Admins() {};
	public Admins(Integer id, String loginName, String loginPhoneNumber, String loginEmail, String loginId,
			String loginPass, String loginPass2) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.loginPhoneNumber = loginPhoneNumber;
		this.loginEmail = loginEmail;
		this.loginId = loginId;
		this.loginPass = loginPass;
		this.loginPass2 = loginPass2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPhoneNumber() {
		return loginPhoneNumber;
	}
	public void setLoginPhoneNumber(String loginPhoneNumber) {
		this.loginPhoneNumber = loginPhoneNumber;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getLoginPass2() {
		return loginPass2;
	}
	public void setLoginPass2(String loginPass2) {
		this.loginPass2 = loginPass2;
	} 

	

}
