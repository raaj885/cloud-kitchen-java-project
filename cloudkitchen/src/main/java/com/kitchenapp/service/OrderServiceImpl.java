package com.kitchenapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.kitchenapp.exceptions.OrderNotFoundExpection;
import com.kitchenapp.model.Order;
import com.kitchenapp.repository.IOrderRepository;
import com.kitchenapp.repository.OrderRepositoryImpl;

public class OrderServiceImpl implements IOrderService {

	IOrderRepository orderRepository = new OrderRepositoryImpl();

	@Override
	public void orderFood(String email, String items) {
		orderRepository.orderFood(email, items);
		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> showOrders(String email) throws OrderNotFoundExpection {
		return orderRepository.showOrders(email).stream()
				.sorted((o1, o2) -> o1.getItemName().compareTo(o2.getItemName())).collect(Collectors.toList());
	}

	@Override
	public List<Order> updateOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> showTodayOrders() throws OrderNotFoundExpection {
		// TODO Auto-generated method stub
		return orderRepository.showTodayOrders();
	}

}
