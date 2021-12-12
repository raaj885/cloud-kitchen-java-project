package com.kitchenapp.service;

import java.util.List;

import com.kitchenapp.exceptions.*;
import com.kitchenapp.model.Menu;

public interface IMenuService {
	// call by kitchen

	void addMenu(Menu menu);

	void updateMenu(double prices, int itemId) throws ItemNotFoundException;

	void deleteMenu(int itemId) throws ItemNotFoundException;

	// call by user
	List<Menu> getAllMenu();

	List<Menu> getByMenuType(String menutype) throws MenuNotFoundException;

	List<Menu> getByCategory(String category) throws CategoryNotFoundException;

	List<Menu> getbyPrice(double price) throws ItemNotFoundException;

	Iterable<Menu> getByItemtype(String itemtypee) throws ItemNotFoundException;

}
