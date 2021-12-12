package com.kitchenapp.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import com.kitchenapp.exceptions.OrderNotFoundExpection;
import com.kitchenapp.model.Order;

public class OrderRepositoryImpl implements IOrderRepository {
	static Connection connection;

	@Override
	public void orderFood(String email, String items) {
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		ResultSet resultset = null;
		connection = ModelDAO.openConnection();
		try {
			statement = connection.prepareStatement(Queries.SELECTCARTQUERY);
			resultset = statement.executeQuery();
			String totalamount = "";
			while (resultset.next()) {
				totalamount = resultset.getString(1);
				System.out.println("The Total amount to be paid is : " + totalamount);
			}
			statement1 = connection.prepareStatement(Queries.PLACEORDERQUERY);
			statement1.setString(1, email);
			statement1.setString(2, items);
			statement1.setString(3, totalamount);
			statement1.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					;
				}
			ModelDAO.closeConnection();
		}
	}

	@Override
	public List<Order> showOrders(String email) throws OrderNotFoundExpection {
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Order> orderList = new ArrayList<>();

		try {
			statement = connection.prepareStatement(Queries.SELECTPREVIOUSORDERSQUERY);
			statement.setString(1, email);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int orderid = resultset.getInt("orderid");
				String emailid = resultset.getString("email");
				String items = resultset.getString("items");
				String orderdate = resultset.getString("orderdate");
				double totalamount = resultset.getDouble("totalamount");
				Order order = new Order(orderid, emailid, items, orderdate, totalamount);
				orderList.add(order);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					;
				}
			ModelDAO.closeConnection();
		}
		return orderList;
	}

	@Override
	public void updateOrder(int quantity, String itemname) throws OrderNotFoundExpection {
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();

		try {
			statement = connection.prepareStatement(Queries.UPDATEORDERQUERY);
			statement.setInt(1, quantity);
			statement.setString(2, itemname);
			int count = statement.executeUpdate();
			if (count == 0) {
				throw new OrderNotFoundExpection();
			}
			System.out.println("Update successful");

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
	}

	@Override
	public List<Order> showTodayOrders() throws OrderNotFoundExpection {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		connection = ModelDAO.openConnection();
		ResultSet resultset = null;
		List<Order> orderList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(Queries.SELECTORDERSQUERY);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				int orderid = resultset.getInt("orderid");
				String emailid = resultset.getString("email");
				String items = resultset.getString("items");
				String orderdate = resultset.getString("orderdate");
				double totalamount = resultset.getDouble("totalamount");
				Order order = new Order(orderid, emailid, items, orderdate, totalamount);
				orderList.add(order);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No Orders Today");
		}

		return orderList;
	}

}
