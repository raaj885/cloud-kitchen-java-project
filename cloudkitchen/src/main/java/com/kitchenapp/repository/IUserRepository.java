package com.kitchenapp.repository;

import com.kitchenapp.exceptions.*;
import com.kitchenapp.model.Customer;

public interface IUserRepository {

	//called by user
	
		void createUser(Customer customer);
		void updateUser(long phonenumber,String password, String address) throws UserNotFoundException;
		int selectUser(String email, String password) throws UserNotFoundException;
}

