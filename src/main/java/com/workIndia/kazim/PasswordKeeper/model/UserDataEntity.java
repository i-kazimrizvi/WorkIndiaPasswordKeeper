package com.workIndia.kazim.PasswordKeeper.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDataEntity {

    @Id
    @GeneratedValue
    Integer userId;
    String username;
    String password;


    public UserDataEntity() {
    }

    public UserDataEntity(Integer userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
