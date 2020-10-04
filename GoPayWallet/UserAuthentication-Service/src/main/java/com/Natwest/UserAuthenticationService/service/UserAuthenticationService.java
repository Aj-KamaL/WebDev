package com.Natwest.UserAuthenticationService.service;

import com.Natwest.UserAuthenticationService.exception.UserNotFoundException;
import com.Natwest.UserAuthenticationService.exception.UserNullException;
import com.Natwest.UserAuthenticationService.model.User;

import java.util.List;

public interface UserAuthenticationService {

    	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

    public User findByUserIdAndPassword(long userId, String password) throws UserNotFoundException;
	public User findByUserNameAndUserPassword(String userName,String userPassword) throws UserNotFoundException;
    long saveUser(User user) throws UserNullException;
    List<User> getAllUsers();
}
