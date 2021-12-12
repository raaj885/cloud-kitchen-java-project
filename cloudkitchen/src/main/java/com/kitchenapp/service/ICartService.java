package com.kitchenapp.service;

import java.util.List;

import com.kitchenapp.exceptions.CartNotFoundException;
import com.kitchenapp.exceptions.ItemNotFoundException;
import com.kitchenapp.model.Cart;

public interface ICartService {

	void addItemToCart(Cart cart);

	void calculateOrder();

	void clearCart();

	List<Cart> getAllCart() throws CartNotFoundException;

	void clearCalculateOrder();

}
