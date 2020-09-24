package com.Natwest.UserAuthenticationService.service;

import com.Natwest.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.Natwest.UserAuthenticationService.exception.UserNotFoundException;
import com.Natwest.UserAuthenticationService.exception.UserNullException;
import com.Natwest.UserAuthenticationService.model.User;

public interface UserAuthenticationService {

    	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

    public User findByUserIdAndPassword(long userId, String password) throws UserNotFoundException;
	public User findByUserNameAndUserPassword(String userName,String userPassword) throws UserNotFoundException;
    boolean saveUser(User user) throws UserNullException;
}
