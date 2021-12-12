package com.kitchenapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.kitchenapp.exceptions.CategoryNotFoundException;
import com.kitchenapp.exceptions.ItemNotFoundException;
import com.kitchenapp.exceptions.MenuNotFoundException;
import com.kitchenapp.model.Menu;
import com.kitchenapp.repository.IMenuRepository;
import com.kitchenapp.repository.MenuRepositoryImpl;

public class MenuServiceImpl implements IMenuService {
	
	IMenuRepository menuRepository = new MenuRepositoryImpl();

	@Override
	public void addMenu(Menu menu) {
		menuRepository.addMenu(menu);
		
	}

	@Override
	public void updateMenu(double price,int itemId) throws ItemNotFoundException {
		menuRepository.updateMenu(price,itemId);
		
	}

	@Override
	public void deleteMenu(int itemId) throws ItemNotFoundException {
		menuRepository.deleteMenu(itemId);
		
	}

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return  menuRepository
				.getAllMenu()
				.stream()
				.sorted((o1,o2)->o1.getItemName().compareTo(o2.getItemName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Menu> getByMenuType(String menutype) throws MenuNotFoundException {
		// TODO Auto-generated method stub

		return  menuRepository
				.getByMenuType(menutype)
				.stream()
				.sorted((o1,o2)->o1.getItemName().compareTo(o2.getItemName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Menu> getByCategory(String category) throws CategoryNotFoundException{
		// TODO Auto-generated method stub
		
		return menuRepository
				.getByCategory(category)
				.stream()
				.sorted((o1,o2)->o1.getItemName().compareTo(o2.getItemName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Menu> getbyPrice(double price) throws ItemNotFoundException{
		// TODO Auto-generated method stub
		return menuRepository
				.getbyPrice(price)
				.stream()
				.sorted((o1,o2)->o1.getItemName().compareTo(o2.getItemName()))
				.collect(Collectors.toList());
				
	}

	@Override
	public Iterable<Menu> getByItemtype(String itemtypee) throws ItemNotFoundException {
		// TODO Auto-generated method stub
		return menuRepository
				.getByItemtype(itemtypee)
				.stream()
				.sorted((o1,o2)->o1.getItemName().compareTo(o2.getItemName()))
				.collect(Collectors.toList());
	}

}
