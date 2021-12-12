package com.kitchenapp.repository;

public class Queries {
	// Menu
	public static final String INSERTMENUQUERY = "insert into menu (menutype,itemname,itemtype,price,servings,category)values(?,?,?,?,?,?)";
	public static final String UPDATEMENUQUERY = "update menu set price =? where itemid=?";
	public static final String DELETEMENUQUERY = "delete from menu where itemid=?";
	public static final String SELECTMENU = "select* from menu";
	public static final String SELECTBYMENUTYPE = "select* from menu where menutype=?";
	public static final String FINDBYCATEGORY = "select * from menu where category = ?";
	public static final String LESSERPRICEQUERY = "select * from menu where price < ?";
	public static final String FINDBYITEMTYPE = "select * from menu where itemtype=?";
		
	

	// Customer
	public static final String INSERTCUSTOMERQUERY = "insert into customer(customername, phonenumber, address,pincode, email, password) values (?,?,?,?,?,?)";
	public static final String UPDATECUSTOMER = "update customer set address = ? where phonenumber = ? AND password like ?";
	public static final String SELECTCUSTOMER = "select customerid from customer where email = ? AND password = ?";

	// Order

	public static final String INSERTITEMQUERY = "insert into cart(mail, itemname, quantity) values (?,?,?)";
	public static final String INSERTORDERQUERY = "insert into orderdetails(customerid, itemname, quantity, totalamount) values (?,?,?,?)";
	public static final String CALCULATEORDERQUERY = "insert into calculatecart( mail, itemname, quantity, total) select cart.mail, cart.itemname, cart.quantity, sum(menu.price * cart.quantity) as TOTAl from cart join menu on cart.itemname = menu.itemname group by cart.itemname;";
	public static final String PLACEORDERQUERY = "insert into orderdetails(email, items, totalamount) values (?, ?, ?)";
	public static final String SELECTCARTQUERY = "select sum(total) as totalamount from calculatecart";
	public static final String TRUNCATECARTQUERY = "truncate table cart";
	public static final String TRUNCATECALCULATECARTQUERY = "truncate table calculatecart";
	public static final String DISPLAYCARTQUERY = "select * from calculatecart";
	public static final String SELECTPREVIOUSORDERSQUERY = "select * from orderdetails where email = ?";
	public static final String UPDATEORDERQUERY = "update menu set quantity=? where itemname=?";
	public static final String SELECTORDERSQUERY = "SELECT * FROM orderdetails WHERE DATE(orderdate) = CURDATE();";
	
}
