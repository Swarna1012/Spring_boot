package com.example.demo.JWT.dto;

public class RequestMeta {

    // to hold jwt payload
    private Long userId;
    private String name;
    private String emailId;
    private String userType;

    public Long getUserid() {
        return userId;
    }

    public void setUserId(Long userid) {
        this.userId = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
