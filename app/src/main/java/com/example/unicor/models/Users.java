package com.example.unicor.models;

public class Users {
    private String password, user;

    public Users() {
        this.password = "admin";
        this.user = "admin";
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
