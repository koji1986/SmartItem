package domain;

public class Customer {

	private Integer id;
	private String customerNo;
	private String customerName;
	private String customerKana;
	private String customerPhoneNumber1;
	private String customerPhoneNumber2;
	private String customerPhoneNumber3;
	private String customerEmail;
	private String customerAddress1;
	private String customerAddress2;
	private String customerCreditNumber;
	private String customerCreditDate;
	private String customerCreditCvv;
	private String customerMemo;

	public Customer() {
	};

	public Customer(Integer id, String customerNo, String customerName, String customerKana,
			String customerPhoneNumber1, String customerPhoneNumber2, String customerPhoneNumber3, String customerEmail,
			String customerAddress1, String customerAddress2, String customerCreditNumber, String customerCreditDate,
			String customerCreditCvv, String customerMemo) {
		super();
		this.id = id;
		this.customerNo = customerNo;
		this.customerName = customerName;
		this.customerKana = customerKana;
		this.customerPhoneNumber1 = customerPhoneNumber1;
		this.customerPhoneNumber2 = customerPhoneNumber2;
		this.customerPhoneNumber3 = customerPhoneNumber3;
		this.customerEmail = customerEmail;
		this.customerAddress1 = customerAddress1;
		this.customerAddress2 = customerAddress2;
		this.customerCreditNumber = customerCreditNumber;
		this.customerCreditDate = customerCreditDate;
		this.customerCreditCvv = customerCreditCvv;
		this.customerMemo = customerMemo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerKana() {
		return customerKana;
	}

	public void setCustomerKana(String customerKana) {
		this.customerKana = customerKana;
	}

	public String getCustomerPhoneNumber1() {
		return customerPhoneNumber1;
	}

	public void setCustomerPhoneNumber1(String customerPhoneNumber1) {
		this.customerPhoneNumber1 = customerPhoneNumber1;
	}

	public String getCustomerPhoneNumber2() {
		return customerPhoneNumber2;
	}

	public void setCustomerPhoneNumber2(String customerPhoneNumber2) {
		this.customerPhoneNumber2 = customerPhoneNumber2;
	}

	public String getCustomerPhoneNumber3() {
		return customerPhoneNumber3;
	}

	public void setCustomerPhoneNumber3(String customerPhoneNumber3) {
		this.customerPhoneNumber3 = customerPhoneNumber3;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress1() {
		return customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public String getCustomerAddress2() {
		return customerAddress2;
	}

	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	public String getCustomerCreditNumber() {
		return customerCreditNumber;
	}

	public void setCustomerCreditNumber(String customerCreditNumber) {
		this.customerCreditNumber = customerCreditNumber;
	}

	public String getCustomerCreditDate() {
		return customerCreditDate;
	}

	public void setCustomerCreditDate(String customerCreditDate) {
		this.customerCreditDate = customerCreditDate;
	}

	public String getCustomerCreditCvv() {
		return customerCreditCvv;
	}

	public void setCustomerCreditCvv(String customerCreditCvv) {
		this.customerCreditCvv = customerCreditCvv;
	}

	public String getCustomerMemo() {
		return customerMemo;
	}

	public void setCustomerMemo(String customerMemo) {
		this.customerMemo = customerMemo;
	}

}
