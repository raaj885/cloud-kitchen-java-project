package com.kitchenapp.model;

public class Cart {
	private String mail;
	private String itemname;
	private int quantity;
	private double total;
	
	public Cart() {
		super();
		
	}
	public Cart(String mail, String itemname, int quantity,double total) {
		super();
		this.mail = mail;
		this.itemname = itemname;
		this.quantity = quantity;
		this.total = total;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Cart [mail=" + mail + ", itemname=" + itemname + ", quantity=" + quantity + ", total=" + total + "]";
	}
	
	
	

}
