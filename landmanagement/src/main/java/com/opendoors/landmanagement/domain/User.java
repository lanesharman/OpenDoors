package com.opendoors.landmanagement.domain;



public class User {
    private String email;
    private String code;
    private String name;
    private String phone;
    private String status;
    private String message;
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User [code=" + code + ", email=" + email + ", message=" + message + ", name=" + name + ", phone="
                + phone + ", status=" + status + "]";
    }
    
    
}
