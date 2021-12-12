package com.kitchenapp.repository;
/**
 * @author ArunSaiSurapaneni
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ModelDAO {
	static Connection connection;
	public static final String URL = "jdbc:mysql://localhost:3306/cloudkitchen";

	public static final String USERNAME = "root";

	public static final String PASSWORD = "root";

	public static Connection openConnection() {

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}