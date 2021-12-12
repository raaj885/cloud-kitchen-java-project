package com.kitchenapp.model;

/**
 * @author ArunSaiSurapaneni
 *
 */
public class Order {
	private int orderid;
	private String email;
	private String itemName;
	private String orderdate;
	private double totalamount;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderid, String email, String itemName, String orderdate, double totalamount) {
		super();
		this.orderid = orderid;
		this.email = email;
		this.itemName = itemName;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", email=" + email + ", itemName=" + itemName + ", orderdate=" + orderdate
				+ ", totalamount=" + totalamount + "]";
	}
	
	

}
