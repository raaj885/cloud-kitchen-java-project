package com.kitchenapp.model;


/**
 * @author ArunSaiSurapaneni
 *
 */
public class Customer {
	private int customerId;

	private String name;
	private long phoneNumber;
	private String address;
	private String pincode;
	private String email;
	private String password;
	private int customerid;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, long phoneNumber, String address, String pincode, String email, String password) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.pincode = pincode;
		this.email = email;
		this.password = password;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + ", pincode="
				+ pincode + ", email=" + email + ", password=" + password + "]";
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
}
