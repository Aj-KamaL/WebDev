package com.Natwest.UserAuthenticationService.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Natwest.UserAuthenticationService.model.User;
import org.springframework.stereotype.Repository;


/*
 * This class is implementing the JpaRepository interface for User.
 * Annotate this class with @Repository annotation
 * */
@Repository
public interface UserAuthenticationRepository extends JpaRepository<User, String> {



    /*
     * Apart from the standard CRUD methods already available in JPA Repository, based
     * on our requirements, we might need to create few query methods for getting
     * specific data from the database.
     * */

    /*
     * This method will validate a user from database by username and password.
     */

    User findByUserIdAndUserPassword(long userId, String userPassword);
    User findByUserNameAndUserPassword(String userName,String userPassword);
}
