package com.kitchenapp.service;

import java.util.List;

import com.kitchenapp.exceptions.OrderNotFoundExpection;
import com.kitchenapp.model.Order;

public interface IOrderService {

	// call by user

	List<Order> updateOrder(int orderId);
	
	void orderFood(String email, String items);

	List<Order> showOrders(String email) throws OrderNotFoundExpection;

	List<Order> showTodayOrders() throws OrderNotFoundExpection;

}
