package com.kitchenapp.repository;

import java.util.List;

import com.kitchenapp.exceptions.CartNotFoundException;
import com.kitchenapp.exceptions.ItemNotFoundException;
import com.kitchenapp.model.Cart;

public interface ICartRepository {

	void addItemToCart(Cart cart);

	void clearCart();

	void calculateOrder();

	void clearCalculateOrder();

	List<Cart> getAllCart() throws CartNotFoundException;


}
