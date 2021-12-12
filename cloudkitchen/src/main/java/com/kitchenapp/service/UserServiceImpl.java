package com.kitchenapp.service;

import com.kitchenapp.exceptions.UserNotFoundException;
import com.kitchenapp.model.Customer;
import com.kitchenapp.repository.IUserRepository;
import com.kitchenapp.repository.UserRepositoryImpl;

public class UserServiceImpl implements IUserService {
	IUserRepository userRepository = new UserRepositoryImpl();

	@Override
	public void createUser(Customer customer) {
		// TODO Auto-generated method stub
		userRepository.createUser(customer);

	}

	@Override
	public void updateUser(long phonenmumber, String password, String address) throws UserNotFoundException {
		// TODO Auto-generated method stub
		userRepository.updateUser(phonenmumber, password, address);

	}

	@Override
	public int selectUser(String email, String password) throws UserNotFoundException{		
		// TODO Auto-generated method stub
		
		return userRepository.selectUser(email, password);	
	}

}
