package com.Natwest.UserAuthenticationService.model;

import javax.persistence.*;
import java.util.Date;

/*
 * The class "User" will be acting as the data model for the User Table in the database.
 * Please note that this class is annotated with @Entity annotation.
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation.
 * If it finds any, then it will begin the process of looking through that particular
 * Java object to recreate it as a table in your database.
 */

@Entity
public class User {

    /*
     * This class should have five fields (userId,firstName,lastName,
     * userPassword,userRole,userAddedDate). Out of these five fields, the field
     * userId should be the primary key. This class should also contain the getters
     * and setters for the fields, along with the no-arg , parameterized constructor
     * and toString method.The value of userAddedDate should not be accepted from
     * the user but should be always initialized with the system date
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")
    private long userId;
    private String userName;
    private String userPassword;
    private String userLocation;
    private String email;
    private String contact;
    private Date userAddedDate;

    public long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public Date getUserAddedDate() {
        return userAddedDate;
    }

    public void setUserAddedDate(Date userAddedDate) {
        this.userAddedDate = userAddedDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userLocation='" + userLocation + '\'' +
                ", userAddedDate=" + userAddedDate +
                '}';
    }
}
