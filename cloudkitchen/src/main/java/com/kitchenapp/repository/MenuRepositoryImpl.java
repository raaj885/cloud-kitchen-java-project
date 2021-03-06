package com.kitchenapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kitchenapp.exceptions.CategoryNotFoundException;
import com.kitchenapp.exceptions.ItemNotFoundException;
import com.kitchenapp.exceptions.MenuNotFoundException;
import com.kitchenapp.model.Menu;

/**
 * @author RajasekharMandireddy
 *
 */
public class MenuRepositoryImpl implements IMenuRepository {

	static Connection connection;

	@Override
	public void addMenu(Menu menu) {

		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(Queries.INSERTMENUQUERY);
			statement.setString(1, menu.getMenuType());
			statement.setString(2, menu.getItemName());
			statement.setString(3, menu.getItemType());
			statement.setDouble(4, menu.getPrice());
			statement.setInt(5, menu.getServings());
			statement.setString(6, menu.getCategory());
			statement.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Please check what you entred");
				}
			ModelDAO.closeConnection();
		}

	}

	@Override
	public void updateMenu(double price, int itemId) throws ItemNotFoundException {
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();

		try {
			statement = connection.prepareStatement(Queries.UPDATEMENUQUERY);
			statement.setDouble(1, price);
			statement.setInt(2, itemId);
			int count = statement.executeUpdate();
			if (count == 0) {
				throw new ItemNotFoundException("Invalid Id");
			}
			System.out.println("Update successful");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Please check the item id carefully");
				}
			ModelDAO.closeConnection();
		}
	}

	@Override
	public void deleteMenu(int itemId) throws ItemNotFoundException {
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		try {
			statement = connection.prepareStatement(Queries.DELETEMENUQUERY);
			statement.setInt(1, itemId);
			statement.executeUpdate();
			System.out.println("delete successful");
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Please check the item id ");
				}
			ModelDAO.closeConnection();
		}
	}

	@Override
	public List<Menu> getAllMenu() {
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Menu> menuList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(Queries.SELECTMENU);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String menutype = resultset.getString("menutype");
				String itemname = resultset.getString("itemname");
				String itemtype = resultset.getString("itemtype");
				double price = resultset.getDouble("price");
				int servings = resultset.getInt("servings");
				String category = resultset.getString("category");
				Menu menu = new Menu(menutype, itemname, itemtype, price, servings, category);
				menuList.add(menu);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("There is an error in the Display");
				}
			ModelDAO.closeConnection();
		}

		return menuList;
	}

	@Override
	public List<Menu> getByMenuType(String menutype) throws MenuNotFoundException {
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Menu> menuList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.SELECTBYMENUTYPE);
			statement.setString(1, menutype);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String menutypes = resultset.getString("menutype");
				String itemname = resultset.getString("itemname");
				String itemtype = resultset.getString("itemtype");
				double price = resultset.getDouble("price");
				int servings = resultset.getInt("servings");
				String category = resultset.getString("category");
				Menu menu = new Menu(menutypes, itemname, itemtype, price, servings, category);
				menuList.add(menu);
			}
			if (menuList.isEmpty()) {
				throw new MenuNotFoundException("No Menu type found for the input");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			ModelDAO.closeConnection();
		}
		return menuList;
	}

	@Override
	public List<Menu> getByCategory(String category) throws CategoryNotFoundException {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		List<Menu> itemList = new ArrayList<Menu>();
		try {
			statement = connection.prepareStatement(Queries.FINDBYCATEGORY);
			statement.setString(1, category);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String menutype = resultset.getString("menutype");
				String itemname = resultset.getString("itemname");
				String itemtype = resultset.getString("itemtype");
				double price = resultset.getDouble("price");
				Integer servings = resultset.getInt("servings");
				String categorys = resultset.getString("category");
				Menu menu = new Menu(menutype, itemname, itemtype, price, servings, categorys);
				itemList.add(menu);
			}
			if (itemList.isEmpty()) {
				throw new CategoryNotFoundException("no category exists");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			ModelDAO.closeConnection();
		}

		return itemList;
	}
	
	@Override
	public List<Menu> getByItemtype(String itemType) throws ItemNotFoundException {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		List<Menu> itemList = new ArrayList<Menu>();
		try {
			statement = connection.prepareStatement(Queries.FINDBYITEMTYPE);
			statement.setString(1, itemType);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String menutype = resultset.getString("menutype");
				String itemname = resultset.getString("itemname");
				String itemtype = resultset.getString("itemtype");
				double price = resultset.getDouble("price");
				Integer servings = resultset.getInt("servings");
				String categorys = resultset.getString("category");
				Menu menu = new Menu(menutype, itemname, itemtype, price, servings, categorys);
				itemList.add(menu);
			}
			if (itemList.isEmpty()) {
				throw new ItemNotFoundException("Item type does not exists");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ModelDAO.closeConnection();
		}

		return itemList;
	}

	@Override
	public List<Menu> getbyPrice(double price) throws ItemNotFoundException {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		ResultSet resultset = null;
		List<Menu> itemList = new ArrayList<Menu>();

		try {
			statement = connection.prepareStatement(Queries.LESSERPRICEQUERY);
			statement.setDouble(1, price);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String menutype = resultset.getString("menutype");
				String itemname = resultset.getString("itemname");
				String itemtype = resultset.getString("itemtype");
				double prices = resultset.getDouble("price");
				Integer servings = resultset.getInt("servings");
				String category = resultset.getString("category");
				Menu menu = new Menu(menutype, itemname, itemtype, prices, servings, category);
				itemList.add(menu);
			}
			if (itemList.isEmpty()) {
				throw new ItemNotFoundException("no items below the price tag");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			ModelDAO.closeConnection();
		}

		return itemList;
	}

}
