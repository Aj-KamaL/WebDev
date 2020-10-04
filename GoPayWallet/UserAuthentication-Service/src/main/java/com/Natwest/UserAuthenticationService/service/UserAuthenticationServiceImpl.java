package com.Natwest.UserAuthenticationService.service;

import com.Natwest.UserAuthenticationService.exception.UserNotFoundException;
import com.Natwest.UserAuthenticationService.exception.UserNullException;
import com.Natwest.UserAuthenticationService.model.User;
import com.Natwest.UserAuthenticationService.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	private UserAuthenticationRepository userAuthenticationRepository;
	@Autowired
	public UserAuthenticationServiceImpl(UserAuthenticationRepository userAuthenticationRepository) {
		this.userAuthenticationRepository = userAuthenticationRepository;
	}

	@Override
	public User findByUserIdAndPassword(long userId, String password) throws UserNotFoundException {
		User user = userAuthenticationRepository.findByUserIdAndUserPassword(userId,password);
		if (user == null) {
			throw new UserNotFoundException("Invalid credentials");
		}
		return user;
	}

	@Override
	public User findByUserNameAndUserPassword(String userName, String userPassword) throws UserNotFoundException {
		User user = userAuthenticationRepository.findByUserNameAndUserPassword(userName,userPassword);
		if (user == null) {
			throw new UserNotFoundException("Invalid credentials");
		}
		return user;
	}

	@Override
	public long saveUser(User user) throws UserNullException {
		user.setUserAddedDate(new java.util.Date(System.currentTimeMillis()));
		User user1 = null;
		boolean isRegistered = true;
		try {
			user1  = userAuthenticationRepository.save(user);
		} catch (Exception e){
			throw new UserNullException("User not Registered");
		}
		return user1.getUserId();

	}

	@Override
	public List<User> getAllUsers(){
		return userAuthenticationRepository.findAll();
	}
}
