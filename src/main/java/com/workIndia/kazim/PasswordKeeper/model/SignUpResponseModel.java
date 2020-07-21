package com.workIndia.kazim.PasswordKeeper.model;

public class SignUpResponseModel {

    String status;

    public SignUpResponseModel() {
    }

    public SignUpResponseModel(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
