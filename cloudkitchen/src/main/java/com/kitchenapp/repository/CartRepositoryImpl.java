package com.kitchenapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kitchenapp.model.Customer;
import com.kitchenapp.exceptions.CartNotFoundException;
import com.kitchenapp.exceptions.ItemNotFoundException;
import com.kitchenapp.model.Cart;

public class CartRepositoryImpl implements ICartRepository {

	static Connection connection;
	Customer customer = new Customer();
	Cart cart = new Cart();

	@Override
	public void addItemToCart(Cart cart) {

		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Queries.INSERTITEMQUERY);
			statement.setString(1, cart.getMail());
			statement.setString(2, cart.getItemname());
			statement.setInt(3, cart.getQuantity());
			statement.execute();

		} catch (SQLException e) {
			System.out.println("Item Not Avaliable");
			;
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Please enter correct name");
				}
			ModelDAO.closeConnection();
		}

	}

	@Override
	public void calculateOrder() {
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		try {
			statement = connection.prepareStatement(Queries.CALCULATEORDERQUERY);
			statement.execute();
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			;
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Please Enter correct Item name");
				}
			ModelDAO.closeConnection();
		}
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub

		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();

		try {
			statement = connection.prepareStatement(Queries.TRUNCATECARTQUERY);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Cleared cart");
				}
			ModelDAO.closeConnection();
		}

	}

	@Override
	public List<Cart> getAllCart() throws CartNotFoundException {
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Cart> cartList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(Queries.DISPLAYCARTQUERY);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				String mail = resultset.getString("mail");
				String itemname = resultset.getString("itemname");
				int quantity = resultset.getInt("quantity");
				double total = resultset.getDouble("total");

				Cart cart = new Cart(mail, itemname, quantity, total);
				cartList.add(cart);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("The Cart is Empty. Add items to calculate cart");
				}
			ModelDAO.closeConnection();
		}

		return cartList;
	}

	@Override
	public void clearCalculateOrder() {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		try {
			statement = connection.prepareStatement(Queries.TRUNCATECALCULATECARTQUERY);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("cart cannot be cleared");
				}
			ModelDAO.closeConnection();
		}

	}



}
