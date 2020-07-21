package com.workIndia.kazim.PasswordKeeper.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PasswordKeeperEntity {

    @Id
    @GeneratedValue
    Integer id;
    Integer userId;
    String website;
    String username;
    String password;

    public PasswordKeeperEntity(Integer userId, String website, String username, String password) {
        this.userId = userId;
        this.website = website;
        this.username = username;
        this.password = password;
    }

    public PasswordKeeperEntity() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
