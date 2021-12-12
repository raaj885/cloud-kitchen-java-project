package com.kitchenapp.repository;

import java.util.List;

import com.kitchenapp.exceptions.OrderNotFoundExpection;
import com.kitchenapp.model.Order;

/**
 * @author ArunSaiSurapaneni
 *
 */
public interface IOrderRepository {

	// call by user
	void orderFood(String mail, String items);


	List<Order> showOrders(String email) throws OrderNotFoundExpection;

	void updateOrder(int quantity, String itemname) throws OrderNotFoundExpection;

	List<Order> showTodayOrders() throws OrderNotFoundExpection;
}
