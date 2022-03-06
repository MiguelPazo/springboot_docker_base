package com.miguelpazo.auth.dto;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public class GeneralResponse {

    private Boolean success;
    private String data;
    private String message;
    private Integer code;

    public GeneralResponse() {
        this.success = false;
    }

    public GeneralResponse(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "success=" + success +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
