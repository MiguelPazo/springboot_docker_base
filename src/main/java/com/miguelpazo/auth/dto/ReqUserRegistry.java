package com.miguelpazo.auth.dto;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public class ReqUserRegistry {

    private String firstname;
    private String lastnames;
    private String email;
    private String password;

    public ReqUserRegistry() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
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
        return "reqUserRegistry{" +
                "firstname='" + firstname + '\'' +
                ", lastnames='" + lastnames + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
