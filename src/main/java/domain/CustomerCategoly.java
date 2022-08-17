package domain;

public class CustomerCategoly {

	private Integer id;
	private String customerCategolyName;
	
	public CustomerCategoly() {};

	public CustomerCategoly(Integer id, String customerCategolyName) {
		super();
		this.id = id;
		this.customerCategolyName = customerCategolyName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerCategolyName() {
		return customerCategolyName;
	}

	public void setCustomerCategolyName(String customerCategolyName) {
		this.customerCategolyName = customerCategolyName;
	}

}
