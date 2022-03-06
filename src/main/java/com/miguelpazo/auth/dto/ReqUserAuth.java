package com.miguelpazo.auth.dto;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public class ReqUserAuth {

    private String email;
    private String password;

    public ReqUserAuth() {
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

    @Override
    public String toString() {
        return "reqAuth{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
