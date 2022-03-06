package com.miguelpazo.auth.dto;

import com.google.gson.annotations.SerializedName;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public class JwtPayload {

    private String iss;
    private String email;
    private String acr;
    private String sub;
    private Long exp;
    private Long iat;

    public JwtPayload() {
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcr() {
        return acr;
    }

    public void setAcr(String acr) {
        this.acr = acr;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public Long getIat() {
        return iat;
    }

    public void setIat(Long iat) {
        this.iat = iat;
    }

    @Override
    public String toString() {
        return "JwtPayload{" +
                "iss='" + iss + '\'' +
                ", email='" + email + '\'' +
                ", acr='" + acr + '\'' +
                ", sub='" + sub + '\'' +
                ", exp=" + exp +
                ", iat=" + iat +
                '}';
    }
}
