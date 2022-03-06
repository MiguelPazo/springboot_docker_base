package com.miguelpazo.auth.dto;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public class ReqPasswordNew {

    private String token;
    private String password;
    private String repassword;

    public ReqPasswordNew() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    @Override
    public String toString() {
        return "reqPasswordNew{" +
                "token='" + token + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                '}';
    }
}
