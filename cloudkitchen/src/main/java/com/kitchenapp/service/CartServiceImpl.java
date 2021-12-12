package com.kitchenapp.service;

import java.util.List;
import com.kitchenapp.exceptions.CartNotFoundException;
import com.kitchenapp.exceptions.ItemNotFoundException;
import com.kitchenapp.model.Cart;
import com.kitchenapp.repository.CartRepositoryImpl;
import com.kitchenapp.repository.ICartRepository;

public class CartServiceImpl implements ICartService {

	ICartRepository cartRepository = new CartRepositoryImpl();

	@Override
	public void addItemToCart(Cart cart) {
		cartRepository.addItemToCart(cart);

	}

	@Override
	public void calculateOrder() {
		// TODO Auto-generated method stub
		cartRepository.calculateOrder();

	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		cartRepository.clearCart();

	}

	@Override
	public List<Cart> getAllCart() throws CartNotFoundException {
		// TODO Auto-generated method stub

		// Implement this
		return cartRepository.getAllCart();
	}

	@Override
	public void clearCalculateOrder() {
		// TODO Auto-generated method stub
		cartRepository.clearCalculateOrder();

	}

}
