package com.example.m03_datebase;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "userID")
    private Integer userID;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String full_name;

    public User(Integer userID, String email, String password, String full_name) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.full_name = full_name;
    }

    public User (UserDto userDto){
        this.userID = userDto.getUserID();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.full_name = userDto.getFull_name();
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
