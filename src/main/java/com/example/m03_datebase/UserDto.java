package com.example.m03_datebase;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserDto {

    private Integer userID;
    private String email;
    private String password;
    private String full_name;

    public UserDto(User user){
        this.userID = user.getUserID();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.full_name = user.getFull_name();
    }

    public UserDto(Integer userID, String email, String password, String full_name) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.full_name = full_name;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
