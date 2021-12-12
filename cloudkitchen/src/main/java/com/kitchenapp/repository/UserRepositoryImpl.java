package com.kitchenapp.repository;

import com.kitchenapp.exceptions.UserNotFoundException;
import com.kitchenapp.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ArunSaiSurapaneni
 *
 */
public class UserRepositoryImpl implements IUserRepository {
	static Connection connection;

	@Override
	public void createUser(Customer customer) {
		// TODO Auto-generated method stub
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(Queries.INSERTCUSTOMERQUERY);
			statement.setString(1, customer.getName());
			statement.setLong(2, customer.getPhoneNumber());
			statement.setString(3, customer.getAddress());
			statement.setString(4, customer.getPincode());
			statement.setString(5, customer.getEmail());
			statement.setString(6, customer.getPassword());
			statement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				ModelDAO.closeConnection();
			}
		}

	}

	@Override
	public void updateUser(long phonenumber, String password, String address) throws UserNotFoundException {
		// TODO Auto-generated method stub
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(Queries.UPDATECUSTOMER);
			statement.setString(1, address);
			statement.setLong(2, phonenumber);
			statement.setString(3, password);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			ModelDAO.closeConnection();
		}

	}

	@Override
	public int selectUser(String email, String password) throws UserNotFoundException {
		connection = ModelDAO.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(Queries.SELECTCUSTOMER);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultset = statement.executeQuery();
			Customer customer = null;
			while (resultset.next()) {
				customer = new Customer();
				customer.setCustomerid(resultset.getInt("customerid"));
			}
			if (customer == null) {
				throw new UserNotFoundException("Email and Password not matched");
			}

		} catch (SQLException | UserNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0;
	}

}
