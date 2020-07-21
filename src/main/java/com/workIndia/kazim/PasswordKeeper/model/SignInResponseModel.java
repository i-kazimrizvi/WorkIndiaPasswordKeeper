package com.workIndia.kazim.PasswordKeeper.model;

public class SignInResponseModel {

    String status;
    int userId;

    public SignInResponseModel() {
    }

    public SignInResponseModel(String status, int userId) {
        this.status = status;
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
